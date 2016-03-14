package club.motour.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import club.motour.exception.LoginException;
import club.motour.exception.VerificationCodeException;
import club.motour.exception.WebUserException;
import club.motour.model.User;
import club.motour.model.enums.MessageCode;
import club.motour.service.RentPlanService;
import club.motour.service.UserService;

import club.motour.util.MessageUtils;

@Controller
@Scope("prototype")
public class LoginController extends BaseController{

	Logger log = Logger.getLogger(getClass()) ;
	
	@Autowired
	UserService userService;
	@Autowired
	RentPlanService rentPlanService;
	
	@Value("${cs.phone}")
	private String CUSTOMER_SERVICE_PHONE_NUMBER;
	
	@RequestMapping(value="/login", method={RequestMethod.POST})	
	public String login(String userId, String passwd, ModelMap model) {
		String referer = getHttpServletRequest().getHeader("Referer");
		try {
			User u = userService.loginWebUser(userId, passwd);
			setUserInSession(u);
		} catch (LoginException e) {
			e.printStackTrace();
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(e.getMsgCode()));			
		}
		
		return "redirect:" + referer;
	}
	
	@RequestMapping(value="/logout")	
	public String logout() {
		setUserInSession(null);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/forgetPassword")
	public String forgetPassword(String userId, ModelMap model) {
		try {
			userService.forgetPassword(userId);
		} catch (WebUserException e) {
			e.printStackTrace();
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(e.getMsgCode(), CUSTOMER_SERVICE_PHONE_NUMBER));
		}
		return "user/fgpw_confirm";
	}
	
	@RequestMapping(value="/resetPasswordRequest")
	public String resetPaswordRequest(String userId, String vCode, ModelMap model) {
		try {
			userService.confirmResetPassword(userId, vCode);
			model.addAttribute("userId", userId);
			return "user/fgpw_reset";
		} catch (VerificationCodeException e) {
			e.printStackTrace();
			return "user/fgpw_confirm_failed";
		}
	}
	
	@RequestMapping(value="/resetPassword")
	public String resetPassword(String userId, String password, ModelMap model) {
		userService.resetPassword(userId, password);
		return "redirect:resetPasswordDone";
	}
	
	@RequestMapping(value="/resetPasswordDone")
	public String resetPasswdDone() {
		return "user/fgpw_reset_done";
	}

	/**
	 * ajax 登入
	 * @param userId
	 * @param password
	 * @param model
	 * @return @return "N" 帳密錯誤，"S"已開通，"F"未開通
	 */
	@RequestMapping(value="/loginAjax", method={RequestMethod.POST})	
	public @ResponseBody String loginAjax(String userId, String password, ModelMap model) {
		try {
			User u = userService.loginWebUser(userId, password);
			setUserInSession(u);
			return "S";
		} catch (LoginException e) {
			//e.printStackTrace();
			if(e.getMsgCode()==MessageCode.USER_NOT_VALID){
				return "F" ;
			}else{
				return "N" ;
			}
		}
	}

}
