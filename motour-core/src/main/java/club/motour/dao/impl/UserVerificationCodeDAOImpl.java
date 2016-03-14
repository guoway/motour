package club.motour.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.UserVerificationCodeDAO;
import club.motour.model.CodeMeta;
import club.motour.model.UserVerificationCode;

@Repository
public class UserVerificationCodeDAOImpl extends SpringHibernateDAO<UserVerificationCode, BigDecimal>
		implements UserVerificationCodeDAO {

	@SuppressWarnings("unchecked")
	@Override
	public UserVerificationCode findOneByUserIdAndVType(String userId, BigDecimal vType) {
		DetachedCriteria crit = createDetachedCriteria();
		crit.createCriteria("user").add(Restrictions.eq("id", userId));
		crit.add(Restrictions.eq("vType", new CodeMeta(vType)));		
		crit.addOrder(Order.desc("createTime"));
		List<UserVerificationCode> list = (List<UserVerificationCode>) getTemplate().findByCriteria(crit);
		if(list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVerificationCode> findListByUserIdAndVType(String userId, BigDecimal vType) {
		DetachedCriteria crit = createDetachedCriteria();
		crit.createCriteria("user").add(Restrictions.eq("id", userId));
		if(null != vType) {
			crit.add(Restrictions.eq("vType", new CodeMeta(vType)));
		}
				
		crit.addOrder(Order.desc("createTime"));
		List<UserVerificationCode> list = (List<UserVerificationCode>) getTemplate().findByCriteria(crit);
		return list;
	}

	@Override
	public int deleteByUserIdAndVType(String userId, BigDecimal vType) {
		StringBuffer sb = new StringBuffer("delete from UserVerificationCode uvc where user.id=? ");
		if(vType != null) {
			sb.append("and vType.id=? ");
		}
		if(vType == null) {
			return getTemplate().bulkUpdate(sb.toString(), userId);
		} else {
			return getTemplate().bulkUpdate(sb.toString(), userId, vType);
		}
	}
	
	

}
