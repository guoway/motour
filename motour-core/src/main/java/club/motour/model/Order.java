package club.motour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import club.motour.model.enums.OrderStatus;
import club.motour.model.enums.OrderStatusConverter;
import club.motour.model.enums.UniformInvoiceType;
import club.motour.model.enums.UniformInvoiceTypeConverter;

@Entity
@Table(name="mt_order_master")
public class Order extends LoggableEntity<BigDecimal> {
	
	private static final long serialVersionUID = 5452175004375011280L;
	
	/**
	 * 訂單編號
	 * M{yyyyMMddzzzz}
	 */
	private String orderCode;
	/**
	 * 紅陽訂單編號
	 */
	private String buySafeNo ;

	/**
	 * 租用人
	 */
	private User user;

	/**
	 * 租用人姓名
	 */
	private String renter;
	
	/**
	 * 下單時間
	 */
	private Date orderTime;
	
	/**
	 * 租用時間
	 */
	private Date rentTime;
	
	/**
	 * 預計還車時間
	 */
	private Date predictReturnTime;
	
	/**
	 * 實際還車時間
	 */
	private Date realReturnTime;
	
	
	/**
	 * 取車點
	 */
	private GetMotorLocation getMotorLocation;
	
	/**
	 * 還車點
	 */
	private GetMotorLocation returnMotorLocation;
	
	/**
	 * 總金額
	 */
	private BigDecimal amount;
	
	/**
	 * 連絡人電話
	 */
	private String phone;
	
	/**
	 * 連絡人EMAIL
	 */
	private String email;
	
	/**
	 * 識別ID(身份證、護照號碼、居留證號)
	 */
	private String identity;
	
	/**
	 * 發票地址
	 */
	private String invAddress;
	
	/**
	 * 發票抬頭
	 */
	private String invTitle;
	
	/**
	 * 發票統編
	 */
	private String invBid;
	
	/**
	 * 發票地址郵遞區號
	 */
	private String invZip;
	
	/**
	 * 發票號碼
	 */
	private String invNum;
	
	/**
	 * 發票類型(二聯、三聯)
	 */
	private UniformInvoiceType invType ;
	/**
	 * 發票收件
	 */
	private String invReceiver ;
	
	/**
	 * 訂單狀態
	 */
	private OrderStatus status ;
	
	/**
	 * 營業所資料
	 */
	private BigDecimal officeId ;
	/**
	 * 訂單明細
	 */
	private Set<OrderDetail> details = new TreeSet<>();
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Column(name="renter_name")
	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}


	@Column(name="order_time")
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	@Column(name="rent_time")
	public Date getRentTime() {
		return rentTime;
	}

	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}

	@Column(name="amount")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="identity")
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}


	@Column(name="inv_address")
	public String getInvAddress() {
		return invAddress;
	}

	public void setInvAddress(String invAddress) {
		this.invAddress = invAddress;
	}


	@Column(name="inv_title")
	public String getInvTitle() {
		return invTitle;
	}

	public void setInvTitle(String invTitle) {
		this.invTitle = invTitle;
	}


	@Column(name="inv_bid")
	public String getInvBid() {
		return invBid;
	}
	
	public void setInvBid(String invBid) {
		this.invBid = invBid;
	}
	

	@Column(name="inv_zip")
	public String getInvZip() {
		return invZip;
	}

	public void setInvZip(String invZip) {
		this.invZip = invZip;
	}

	
	@Column(name="inv_number")
	public String getInvNum() {
		return invNum;
	}

	public void setInvNum(String invNum) {
		this.invNum = invNum;
	}


	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	public Set<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(Set<OrderDetail> details) {
		this.details = details;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	@Column(name="inv_type")
	@Convert(converter=UniformInvoiceTypeConverter.class)
	public UniformInvoiceType getInvType() {
		return invType;
	}

	public void setInvType(UniformInvoiceType invType) {
		this.invType = invType;
	}

	@Column(name="inv_receiver")
	public String getInvReceiver() {
		return invReceiver;
	}

	

	public void setInvReceiver(String invReceiver) {
		this.invReceiver = invReceiver;
	}

	@Column(name="predict_return_time")
	public Date getPredictReturnTime() {
		return predictReturnTime;
	}

	public void setPredictReturnTime(Date predictReturnTime) {
		this.predictReturnTime = predictReturnTime;
	}

	@Column(name="real_return_time")
	public Date getRealReturnTime() {
		return realReturnTime;
	}

	public void setRealReturnTime(Date realReturnTime) {
		this.realReturnTime = realReturnTime;
	}

	@ManyToOne
	@JoinColumn(name="get_gm_id")
	public GetMotorLocation getGetMotorLocation() {
		return getMotorLocation;
	}

	public void setGetMotorLocation(GetMotorLocation getMotorLocation) {
		this.getMotorLocation = getMotorLocation;
	}

	@ManyToOne
	@JoinColumn(name="return_gm_id")
	public GetMotorLocation getReturnMotorLocation() {
		return returnMotorLocation;
	}

	public void setReturnMotorLocation(GetMotorLocation returnMotorLocation) {
		this.returnMotorLocation = returnMotorLocation;
	}

	
	@Column(name="buy_safe_no")
	public String getBuySafeNo() {
		return buySafeNo;
	}

	public void setBuySafeNo(String buySafeNo) {
		this.buySafeNo = buySafeNo;
	}

	
	@Column(name="status")
	@Convert(converter=OrderStatusConverter.class)
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	@Column(name="oid")
	public BigDecimal getOfficeId() {
		return officeId;
	}

	public void setOfficeId(BigDecimal officeId) {
		this.officeId = officeId;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}


}
