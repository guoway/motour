package club.motour.search.obj;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

public class OrderCritSearch extends DispatchMotorSearch {

	private static final long serialVersionUID = -1631243480564077614L;
	
//	/**
//	 * 營業所ids
//	 */
//	private BigDecimal[] officeIds ;
//	
//	/**
//	 * 狀態
//	 */
//	private String[] orderStatus ;
//	
//
//	public BigDecimal[] getOfficeIds() {
//		return officeIds;
//	}
//
//	public void setOfficeIds(BigDecimal[] officeIds) {
//		this.officeIds = officeIds;
//	}
//	
//	public String[] getOrderStatus() {
//		return orderStatus;
//	}
//
//	public void setOrderStatus(String[] orderStatus) {
//		this.orderStatus = orderStatus;
//	}

	@Override
	public DetachedCriteria composeDetachedCriteria(DetachedCriteria crit) {
		
		if(!StringUtils.isEmpty(getOrderCode())) {
			crit.add(Restrictions.eq("orderCode", getOrderCode()));
		}
		if(!StringUtils.isEmpty(getMobile())) {
			crit.add(Restrictions.eq("mobile", getMobile())) ;
		}
		
		if(!StringUtils.isEmpty(getIdentity())) {
			crit.add(Restrictions.eq("identity", getIdentity()));
		}
		
		if(!StringUtils.isEmpty(getName())) {
			crit.add(Restrictions.like("renter", "%"+getName()+"%")) ;
		}
		
		if(null != getOrderDate()) {
			crit.add(Restrictions.between("orderTime", getOrderDate(), DateUtils.addDays(getOrderDate(), 1)));
		}
		if(null != getRentDate()) {
			crit.add(Restrictions.between("rentTime", getRentDate(), DateUtils.addDays(getRentDate(), 1)));
		}
		
//		if(null!= officeIds && officeIds.length !=0){
//			crit.add(Restrictions.in("oid", officeIds)) ;
//		}
		
//		if(null!= orderStatus && orderStatus.size()!=0){
//			crit.add(Restrictions.in("status", orderStatus)) ;
//		}
		return crit ;
	}
	
}
