package club.motour.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="mt_order_detail")
public class OrderDetail extends LoggableEntity<BigDecimal> {

	private static final long serialVersionUID = -4111845157097933042L;

	/**
	 * 
	 */
	private Order order;
	
	/**
	 * 租用車型
	 */
	private MotorcycleType motorcycleType;
	
	/**
	 * 數量
	 */
	private BigDecimal quantity;

	/**
	 * 租用方案
	 */
	private RentPlan rentPlan;
	
	/**
	 * 原始單價
	 */
	private BigDecimal unitPrice;
	
	/**
	 * 此筆明細總折扣金額
	 */
	private BigDecimal discount;
	
	/**
	 * 此筆明細小結。
	 * total_price = (quantity * unit_price) - discount
	 */
	private BigDecimal totalPrice;
	
	/**
	 * 此筆明細所租用車輛
	 */
	private Set<Motorcycle> motors = new TreeSet<>();

	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="od_id")
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	
	@ManyToOne
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	@ManyToOne
	@JoinColumn(name="mt_id")
	public MotorcycleType getMotorcycleType() {
		return motorcycleType;
	}

	public void setMotorcycleType(MotorcycleType motorcycleType) {
		this.motorcycleType = motorcycleType;
	}



	@Column(name="quantity")
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	@ManyToOne
	@JoinColumn(name="rp_id")
	public RentPlan getRentPlan() {
		return rentPlan;
	}

	public void setRentPlan(RentPlan rentPlan) {
		this.rentPlan = rentPlan;
	}

	@Column(name="unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name="discount")
	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Column(name="total_price")
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@OneToMany
	@JoinTable(
			name="mt_order_detail_to_motorcycle", 
			joinColumns=@JoinColumn(name="od_id", referencedColumnName="od_id"),
			inverseJoinColumns=@JoinColumn(name="mid", referencedColumnName="mid"))	
	public Set<Motorcycle> getMotors() {
		return motors;
	}

	public void setMotors(Set<Motorcycle> motors) {
		this.motors = motors;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
