package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;
import com.sylksoft.sql.GenericRowMapper;
import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;
import com.sylksoft.ss3a.dao.Ss3aMemberDAO;
import com.sylksoft.ss3a.model.Role;
import com.sylksoft.ss3a.model.Ss3aMember;
import com.sylksoft.util.DateUtil;
import com.sylksoft.util.PasswordUtil;

import club.motour.dao.ManagerDAO;
import club.motour.dao.UserDAO;
import club.motour.dao.UserVerificationCodeDAO;
import club.motour.exception.LoginException;
import club.motour.exception.MotourException;
import club.motour.exception.VerificationCodeException;
import club.motour.exception.WebUserException;
import club.motour.model.CodeMeta;
import club.motour.model.EmailWrapper;
import club.motour.model.Manager;
import club.motour.model.User;
import club.motour.model.UserVerificationCode;
import club.motour.model.enums.MessageCode;
import club.motour.model.enums.RoleType;
import club.motour.service.MailService;
import club.motour.service.UserService;
import club.motour.ui.model.Select2Item;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ManagerDAO managerDAO ;
	
	@Autowired
	Ss3aMemberDAO ss3aMemberDAO;
	
	@Autowired
	UserVerificationCodeDAO userVerificationCodeDAO;
	
	@Autowired
	MailService mailService;
	
	@Value("${code.verification.register}")
	private BigDecimal VERIFICATION_TYPE_REGISTER; 
	
	@Value("${code.verification.forgetpassword}")
	private BigDecimal VERIFICATION_TYPE_FORGET_PASSWORD;
	
	
	@Value("${ap.host}")
	private String SERVER_HOST;

	@Override
	@Transactional
	public User createWebUser(User user) throws Exception {
		
		user.getSs3aMember().setId(user.getId());
		user.getSs3aMember().setEnabled(false);
		
		//給予權限
		user.getSs3aMember().getRoles().add(new Role(RoleType.GUEST.getName()));
		user.setSs3aMember(user.getSs3aMember());		
		
		/**
		if(StringUtils.isEmpty(user.getEmail())) {
			user.setEmail(user.getId());
		}
		**/
		
		//密碼加密
		user.getSs3aMember().setPassword(PasswordUtil.encryptMD5(user.getSs3aMember().getPassword()));
		
		ss3aMemberDAO.makePersistent(user.getSs3aMember());
		userDAO.makePersistent(user);
		
		//產生註冊驗證碼
		UserVerificationCode uvc = createUserVerificationCode(user, VERIFICATION_TYPE_REGISTER);
		
		//寄發註冊驗證信
		sendRegisterConfirmMail(user, uvc);
		
		return user;
	}

	@Override
	@Transactional
	public void enableWebUser(String userId, String verificationCode) throws VerificationCodeException {
		UserVerificationCode uvc = userVerificationCodeDAO.findOneByUserIdAndVType(userId, VERIFICATION_TYPE_REGISTER);
		if(null == uvc) {
			throw new VerificationCodeException("Cannot find coressponding record", MessageCode.VCODE_INCORRECT);
		}
		
		if(uvc.getCode().equals(verificationCode)) {
			Date d = new Date();
			uvc.setVerifyTime(d);
			Ss3aMember m = ss3aMemberDAO.findById(userId);
			m.setEnabled(true);
		} else {
			throw new VerificationCodeException("Verification code is incorrect", MessageCode.VCODE_INCORRECT);
		}
	}
	
	@Override
	public void resendVerificationCode(String userId) throws VerificationCodeException {
				
		
		UserVerificationCode uvc = userVerificationCodeDAO.findOneByUserIdAndVType(userId, VERIFICATION_TYPE_REGISTER);
		User u = null;
		if(uvc == null) {
			u = userDAO.findById(userId);
			if(u == null) {
				throw new VerificationCodeException("User id(" + userId + ") doesn't exist", MessageCode.USER_ID_NOT_EXIST);
			}
		} else {
			u = uvc.getUser();
			if(u.getSs3aMember().isEnabled()) {
				throw new VerificationCodeException("User id(" + userId + ") has enabled", MessageCode.USER_HAS_ENABLED);
			} else {
				sendRegisterConfirmMail(u, uvc);
				return;
			}
		}
		
	}

	@Override
	@Transactional
	public User loginWebUser(String userId, String passwd) throws LoginException {
		
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
		crit.createCriteria("ss3aMember")
			.add(Restrictions.eq("id", userId))
			.add(Restrictions.eq("password", PasswordUtil.encryptMD5(passwd)));
			//.add(Restrictions.eq("enabled", true));
		
		List<User> list = userDAO.findByCriteria(crit);
		
		if(list == null || list.size() == 0) {
			throw new LoginException("帳號密碼錯誤，請重新登入", MessageCode.PASSWORD_INCORRECT, userId);
		}else if(!list.get(0).getSs3aMember().isEnabled()){
			throw new LoginException("帳號尚未驗證，請重新驗證", MessageCode.USER_NOT_VALID, userId);
		}
		
		User u = list.get(0);
		u.getSs3aMember().setLastLoginTime(new Date());
		ss3aMemberDAO.makePersistent(u.getSs3aMember());
		
		return u;
	}

	@Override
	@Transactional
	public void forgetPassword(String userId) throws WebUserException{
		User u = userDAO.findById(userId);
		if(!u.getSs3aMember().isEnabled()) {
			throw new WebUserException("User ID:" + userId + " is disabled", MessageCode.USER_DISABLED);
		}
		
		UserVerificationCode uvc = createUserVerificationCode(u, VERIFICATION_TYPE_FORGET_PASSWORD);
		
		sendForgetPasswordMail(u, uvc);
	}

	@Override
	@Transactional
	public void confirmResetPassword(String userId, String vCode) throws VerificationCodeException {
		UserVerificationCode uvc = userVerificationCodeDAO.findOneByUserIdAndVType(userId, VERIFICATION_TYPE_FORGET_PASSWORD);
		if(null == uvc) {
			throw new VerificationCodeException("Cannot find coressponding record", MessageCode.VCODE_INCORRECT);
		}
		
		if(uvc.getCode().equals(vCode)) {
			Date d = new Date();
			uvc.setVerifyTime(d);
			userVerificationCodeDAO.makePersistent(uvc);
		} else {
			throw new VerificationCodeException("Verification code is incorrect", MessageCode.VCODE_INCORRECT);
		}
		
	}

	@Override
	@Transactional
	public void resetPassword(String userId, String password) {
		Ss3aMember m = ss3aMemberDAO.findById(userId);
		m.setPassword(PasswordUtil.encryptMD5(password));
		ss3aMemberDAO.makePersistent(m);
	}

	@Override
	public User findUserByUserId(String userId) throws Exception {
		
		return userDAO.findById(userId);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) throws MotourException{
		
		SqlParameter<Map<String, Object>> sql = new SqlParameter<>("select * from ss3a_member_role_mapping where member_id = ? and role_id = 'adm_user';");
		sql.setArguments(userId);
		
		List<Map<String, Object>> list = SqlDAOFactory.getInstance().getSqlDAO().queryAsListOfMap(sql);
		
		if(list.size() > 0) {
			throw new MotourException("該使用者具管理者權限，請先移除該管理員權限。", MessageCode.DELETE_DATA_FAIL);
		}
		
		
		userVerificationCodeDAO.deleteByUserIdAndVType(userId, null);	
		userDAO.deleteById(userId);
		ss3aMemberDAO.deleteById(userId);
	}

	@Override
	@Transactional
	public User updateUserProfile(User user) {
		userDAO.makePersistent(user);
		return user;
	}

	@Override
	@Transactional
	public Manager loginAdminUser(String userId, String passwd) throws LoginException {
		DetachedCriteria crit = DetachedCriteria.forClass(Manager.class);
		crit.createCriteria("user.ss3aMember")
			.add(Restrictions.eq("id", userId))
			.add(Restrictions.eq("password", PasswordUtil.encryptMD5(passwd)))
			.add(Restrictions.eq("enabled", true))
			.createCriteria("roles")
			.add(Restrictions.in("id", new String[]{"adm_user", "administrator"}));
			
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		
		List<Manager> list = managerDAO.findByCriteria(crit);
		
		if(list == null || list.size() == 0) {
			throw new LoginException("帳號密碼錯誤或權限不符，請重新登入", MessageCode.PASSWORD_INCORRECT, userId);
		}else if(!list.get(0).getUser().getSs3aMember().isEnabled()){
			throw new LoginException("帳號尚未驗證，請重新驗證", MessageCode.USER_NOT_VALID, userId);
		}
		Manager m = list.get(0) ;
		//User u = list.get(0);
		m.getUser().getSs3aMember().setLastLoginTime(new Date());
		ss3aMemberDAO.makePersistent(m.getUser().getSs3aMember());
		
		return m ;
	}

	@Override
	public PageResponse getAllManagers(PageRequest request) {
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
		crit.createCriteria("ss3aMember").createCriteria("roles").add(Restrictions.in("id", new String[]{"adm_user"}));
		return userDAO.findByCriteria(crit, request);
	}

	@Override
	public PageResponse getAllUsers(PageRequest request) {
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);		
		return userDAO.findByCriteria(crit, request);
	}

	private UserVerificationCode createUserVerificationCode(User user, BigDecimal verificationType) {
		UserVerificationCode uvc = new UserVerificationCode();
		uvc.setUser(user);
		uvc.setvType(new CodeMeta(verificationType));
		uvc.setCode(generateRegisterVerificationCode(user.getId()));
		uvc.setCreateTime(new Date());
		userVerificationCodeDAO.makePersistent(uvc);
		return uvc;
	}
	
	private String generateRegisterVerificationCode(String userId) {
		StringBuilder sb = new StringBuilder();
		sb.append(userId).append(DateUtil.formatDate(DateUtil.formatDate(new Date(), "yyyyMMddhhmmssSSS")));
		String code = DigestUtils.md5Hex(sb.toString());
		return code;
	}
	
	private void sendRegisterConfirmMail(User user, UserVerificationCode uvc) {
		
		EmailWrapper email = new EmailWrapper();
		email.setTo(user.getId());
		email.setSubject("Motour Club註冊驗證通知");
		email.getVars().add("Motour Club註冊驗證通知");
		
		StringBuilder sb = new StringBuilder();
		sb.append(user.getName() + "您好：<br/>");
		String url = "http://" + SERVER_HOST + "/enableUser/" + user.getId() + "/" + uvc.getCode();
		sb.append("請至" + "<a href='" + url + "'>" + url + "</a>");
		sb.append("進行帳號開通");
		email.getVars().add(sb.toString());
		mailService.sendMail(email);
		
	}
	
	private void sendForgetPasswordMail(User user, UserVerificationCode uvc) {
		
		EmailWrapper email = new EmailWrapper();
		email.setTo(user.getId());
		email.setSubject("Motour Club重設密碼通知");
		email.getVars().add("Motour Club重設密碼通知");
		
		StringBuilder sb = new StringBuilder();
		sb.append(user.getName() + "您好：<br/>");
		String url = "http://" + SERVER_HOST + "/resetPasswordRequest?userId=" + user.getId() + "&vCode=" + uvc.getCode();
		sb.append("請至" + "<a href='" + url + "'>" + url + "</a>");
		sb.append("進行密碼重設");
		email.getVars().add(sb.toString());
		mailService.sendMail(email);
	}

	@Override
	@Transactional
	public User createFBWebUser(User user) throws Exception {
		//產生亂數密碼
		String randomPW = PasswordUtil.generateRandomString(8) ;
		Ss3aMember ss3aMember = new Ss3aMember() ;
		ss3aMember.setId(user.getId());
		//密碼加密
		ss3aMember.setPassword(PasswordUtil.encryptMD5(randomPW));
		ss3aMember.setEnabled(true);
		//給予權限
		ss3aMember.getRoles().add(new Role(RoleType.WEB_USER.getName()));
		user.setSs3aMember(ss3aMember);

		ss3aMemberDAO.makePersistent(user.getSs3aMember());
		userDAO.makePersistent(user);
		
		//Facebook 登入 Motour Club 快速註冊通知
		sendRegisterRandomPWMail(user, randomPW);
		
		return user;
	}
	
	private void sendRegisterRandomPWMail(User user, String randomPW) {
		
		EmailWrapper email = new EmailWrapper();
		email.setTo(user.getId());
		email.setSubject("Facebook 登入 Motour Club 快速註冊通知");
		email.getVars().add("Facebook 登入 Motour Club 快速註冊通知");
		
		StringBuilder sb = new StringBuilder();
		sb.append(user.getName() + "您好：<br/>");
		sb.append("您透過facebook登入Motour Club 以下是您的帳號資訊 : <br/>");
		sb.append("帳號 : "+user.getId() +"<br/>");
		sb.append("密碼 : "+randomPW+"<br/><br/>") ;
		sb.append("感謝您使用 Motour Club") ;
		email.getVars().add(sb.toString());
		mailService.sendMail(email);
	}

	@Override
	public PageResponse getUsersByIdLike(String id, PageRequest request) {
		SqlParameter<Select2Item> param = new SqlParameter<>();
		param.setStatement("select m.member_id as id, m.member_id as text "
				+ "from ss3a_member m "
				+ "where m.member_id like ? "
				+ "and m.member_id not in ( "
					+ "select distinct member_id "
					+ "from ss3a_member_role_mapping mr "
					+ "where mr.role_id in ('adm_user','administrator')) ");
		param.setMapper(new GenericRowMapper<Select2Item>(Select2Item.class));
		param.setArguments("%" + id + "%");
		PageResponse pr = SqlDAOFactory.getInstance().getSqlDAO().queryAsPageResponse(param, request);
		return pr;
	}
}
