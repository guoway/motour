package club.motour.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import club.motour.model.enums.BasicPlanType;
import club.motour.model.enums.BasicPlanTypeConverter;


/**
 * 租用方案
 * @author Ken Chen
 *
 */
@Entity
@Table(name="mt_rent_plan")
public class RentPlan extends LoggableEntity<BigDecimal> {

	private static final long serialVersionUID = -7635134071752110842L;

	/**
	 * 方案名稱
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 價格
	 */
	private BigDecimal price;
	
	private boolean isBasicPlan;
	
	private BasicPlanType basicPlanType;
	
	private BigDecimal languageId;

	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rp_id")
	public BigDecimal getId() {
		return super.getId();
	}

	@Column(name="rp_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="language_id")
	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name="is_basic_plan")
	public boolean isBasicPlan() {
		return isBasicPlan;
	}

	public void setBasicPlan(boolean isBasicPlan) {
		this.isBasicPlan = isBasicPlan;
	}

	@Column(name="basic_plan_type")
	@Convert(converter=BasicPlanTypeConverter.class)
	public BasicPlanType getBasicPlanType() {
		return basicPlanType;
	}

	public void setBasicPlanType(BasicPlanType basicPlanType) {
		this.basicPlanType = basicPlanType;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
