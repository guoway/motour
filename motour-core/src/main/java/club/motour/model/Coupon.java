package club.motour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_coupon")
public class Coupon extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = -7467319567682316496L;

	private CouponPlan couponPlan;
	
	/**
	 * 折扣碼
	 */
	private String code;
	
	/**
	 * 該折扣券使用之訂單
	 */
	private Order order;
	
	/**
	 * 擁有人
	 */
	private User owner;
	
	/**
	 * 折扣券使用時間
	 */
	private Date applyTime;
	
	private Date createTIme;
	
	private String creator;
	
	private Date updateTime;
	
	private String updator;
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	
	@ManyToOne
	@JoinColumn(name="cp_id")
	public CouponPlan getCouponPlan() {
		return couponPlan;
	}



	public void setCouponPlan(CouponPlan couponPlan) {
		this.couponPlan = couponPlan;
	}


	@Column(name="cp_code")
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}


	@Column(name="create_time")
	public Date getCreateTIme() {
		return createTIme;
	}



	public void setCreateTIme(Date createTIme) {
		this.createTIme = createTIme;
	}


	@Column(name="creator")
	public String getCreator() {
		return creator;
	}



	public void setCreator(String creator) {
		this.creator = creator;
	}


	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@Column(name="updator")
	public String getUpdator() {
		return updator;
	}



	public void setUpdator(String updator) {
		this.updator = updator;
	}

	@OneToOne
	@JoinColumn(name="apply_order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne
	@JoinColumn(name="owner_id")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Column(name="apply_time")
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
