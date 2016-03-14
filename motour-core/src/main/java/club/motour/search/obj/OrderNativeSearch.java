package club.motour.search.obj;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sylksoft.generic.PageRequest;
import com.sylksoft.sql.SqlCondition;
import com.sylksoft.sql.SqlSpecification;
import com.sylksoft.sql.SqlSpecification.Operator;
import com.sylksoft.sql.annotation.ColumnName;
import com.sylksoft.sql.annotation.NativeQuery;
/**
 * 訂單查詢
 * @author ryan
 *
 */
@NativeQuery(query="select om.order_code, om.order_time, om.rent_time, om.renter_name, om.phone, om.identity from mt_order_master om ", orderBy=" order by om.order_time desc")
public class OrderNativeSearch extends NativeSearchWithPageRequest {

	private static final long serialVersionUID = 4477707916076228697L;

	private PageRequest pageRequest;
	/**
	 * 訂單編號
	 */
	@ColumnName(name="om.order_code")
	private String orderCode;
	
	/**
	 * 手機號號
	 */
	@ColumnName(name="om.phone")
	private String mobile;
	
	/**
	 * 身份證ID
	 */
	@ColumnName(name="om.identity")
	private String identity;
	
	/**
	 * 租用人姓名
	 */
	@ColumnName(name="om.renter_name")
	private String renter;
	
	/**
	 * 訂單日期
	 */
	@ColumnName(name="om.order_time")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	
	/**
	 * 預約取車時間
	 */
	@ColumnName(name="om_rent_time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
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

	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
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
	public StringBuffer composeNativeSql(String sql, SqlSpecification spec) {
		
		conditionStringBuilder.append(sql);
		
		if (spec.getConditionList() != null && spec.getConditionList().size() > 0) {
			for (SqlCondition condition : spec.getConditionList()) {
				if (condition.getOperator() == Operator.and) {
					addCondition(Operator.and, condition);
				} else if (condition.getOperator() == Operator.or) {
					addCondition(Operator.or, condition);
				} else if (condition.getOperator() == Operator.where) {
					addCondition(Operator.where, condition);
				}
			}
		}
		
		return conditionStringBuilder;
	}

}
