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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_motorcycle_type")
public class MotorcycleType extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 1571384253554394788L;

	/**
	 * 車型名稱
	 */
	private String name;
	
	/**
	 * 車型廠牌
	 */
	private CodeMeta brand;
	
	private BigDecimal languageId;
	
	private Set<Motorcycle> motorcycles = new TreeSet<>();
	
	/**
	 * 適用租用方案
	 */
	private Set<RentPlan> rentPlans = new TreeSet<>();
	
	/**
	 * 最高時速
	 */
	private BigDecimal maxSpeed;
	
	/**
	 * 續航能力
	 */
	private BigDecimal stamina;
	
	/**
	 * 電池類型
	 */
	private String batteryType;
	
	/**
	 * 爬坡力
	 */
	private BigDecimal slope;
	
	/**
	 * 雙載能力
	 */
	private String doubleLoad;
	
	/**
	 * 適用駕照
	 */
	private String properLicense;

	
	/**
	 * 主要圖檔
	 * 用於車型列表頁
	 */
	private MotorcycleTypeMandatoryImage mandatoryImage;
	
	public MotorcycleType() {
		// TODO Auto-generated constructor stub
	}
	
	public MotorcycleType(BigDecimal id) {
		setId(id);
	}
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mt_id")
	public BigDecimal getId() {
		return super.getId();
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToOne
	@JoinColumn(name="brand")
	public CodeMeta getBrand() {
		return brand;
	}


	public void setBrand(CodeMeta brand) {
		this.brand = brand;
	}

	@OneToMany(mappedBy="type")
	public Set<Motorcycle> getMotorcycles() {
		return motorcycles;
	}

	public void setMotorcycles(Set<Motorcycle> motorcycles) {
		this.motorcycles = motorcycles;
	}

	@Column(name="language_id")
	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	@OneToMany
	@JoinTable(
			name="mt_motorcycle_type_to_rent_plan",
			joinColumns=@JoinColumn(name="mt_id"),
			inverseJoinColumns=@JoinColumn(name="rp_id")
	)
	public Set<RentPlan> getRentPlans() {
		return rentPlans;
	}

	public void setRentPlans(Set<RentPlan> rentPlans) {
		this.rentPlans = rentPlans;
	}

	@Column(name="max_speed")
	public BigDecimal getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(BigDecimal maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Column(name="stamina")
	public BigDecimal getStamina() {
		return stamina;
	}

	public void setStamina(BigDecimal stamina) {
		this.stamina = stamina;
	}

	@Column(name="battery_type")
	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	@Column(name="slope")
	public BigDecimal getSlope() {
		return slope;
	}

	public void setSlope(BigDecimal slope) {
		this.slope = slope;
	}

	@Column(name="double_load")
	public String getDoubleLoad() {
		return doubleLoad;
	}

	public void setDoubleLoad(String doubleLoad) {
		this.doubleLoad = doubleLoad;
	}

	@Column(name="proper_license")
	public String getProperLicense() {
		return properLicense;
	}

	public void setProperLicense(String properLicense) {
		this.properLicense = properLicense;
	}

	@OneToOne(mappedBy="motorcycleType")
	public MotorcycleTypeMandatoryImage getMandatoryImage() {
		return mandatoryImage;
	}

	public void setMandatoryImage(MotorcycleTypeMandatoryImage mandatoryImage) {
		this.mandatoryImage = mandatoryImage;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
