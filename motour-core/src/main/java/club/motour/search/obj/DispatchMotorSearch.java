package club.motour.search.obj;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.sylksoft.generic.PageRequest;

public class DispatchMotorSearch extends SearchWithPageRequest{

	private static final long serialVersionUID = 1495757301675587569L;

	private PageRequest pageRequest;
	
	private String orderCode;
	
	private String mobile;
	
	private String identity;
	
	private String name;
	
	private Date orderDate;
	
	private Date rentDate;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	@Override
	public DetachedCriteria composeDetachedCriteria(DetachedCriteria crit) {
		DetachedCriteria userCriteria = crit.createCriteria("user");
		if(!StringUtils.isEmpty(orderCode)) {
			crit.add(Restrictions.eq("orderCode", orderCode));
			return crit;
		}
		
		if(!StringUtils.isEmpty(mobile)) {
			userCriteria.add(Restrictions.eq("mobile", mobile));
		}
		if(!StringUtils.isEmpty(identity)) {
			userCriteria.add(Restrictions.eq("identity", identity));
		}
		if(!StringUtils.isEmpty(name)) {
			userCriteria.add(Restrictions.eq("name", name));
		}
		if(null != orderDate) {
			crit.add(Restrictions.between("orderTime", orderDate, DateUtils.addDays(orderDate, 1)));
		}
		if(null != rentDate) {
			crit.add(Restrictions.between("rentTime", rentDate, DateUtils.addDays(rentDate, 1)));
		}

		return crit;
	}

	@Override
	public String composeSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from mt_order_master m left join mt_order_detail d on m.order_id = d.order_id left join mt_user u on m.user_id = u.user_id ");
		sb.append("where 1 =1 ");
		if(!StringUtils.isEmpty(orderCode)) {
			sb.append("and m.order_code = '" + orderCode + "' ");
			return sb.toString();
		}
		
		return null;
	}
	
	
}
