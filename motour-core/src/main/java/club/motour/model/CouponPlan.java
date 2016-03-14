package club.motour.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 折扣方案
 * @author Ken Chen
 *
 */
@Entity
@Table(name="mt_coupon_plan")
public class CouponPlan extends LoggableEntity<BigDecimal> {

	private static final long serialVersionUID = 5331020454724800019L;

	/**
	 * 名稱
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String description;
	
	private BigDecimal languageId;
	

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cp_id")
	public BigDecimal getId() {
		return super.getId();
	}
	
	
	@Column(name="cp_name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="language_id")
	public BigDecimal getLanguageId() {
		return languageId;
	}


	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}


	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
