package club.motour.model.wrapper;

import java.util.Date;

import com.sylksoft.sql.annotation.NativeQuery;

@NativeQuery(query="select om.order_code, om.order_time, om.rent_time, om.renter_name, om.phone, om.identity from mt_order_master om ", orderBy=" order by ")
public class OrderGridWrapper {

	private String orderCode ;
	private Date orderTime ;
	private Date rentTime ;
	private String renter ;
	private String phone ;
	private String identity ;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getRentTime() {
		return rentTime;
	}
	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}
	public String getRenter() {
		return renter;
	}
	public void setRenter(String renter) {
		this.renter = renter;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
}
