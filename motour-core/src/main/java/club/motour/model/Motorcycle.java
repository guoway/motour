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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_motorcycle")
public class Motorcycle extends GenericEntity<BigDecimal> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2952539866294974865L;
	
	/**
	 * 車型
	 */
	private MotorcycleType type;
	
	/**
	 * 車型型式
	 */
	private String subType;
	
	/**
	 * 所屬營業據點
	 */
	private OperationOffice office;
	
	/**
	 * 行照號碼
	 */
	private String licenseNumber;
	
	/**
	 * 發照日期
	 */
	private Date licenseIssueDate;
	
	/**
	 * 馬達號碼
	 */
	private String motorNumber;
	
	/**
	 * 狀態
	 * 服役中 - 7
	 * 預訂中 - 47
	 * 租用中 - 10
	 * 報修中 - 9
	 * 備用  - 11
	 * 已退役 - 8
	 * code_meta.parent_id = 6
	 */
	private CodeMeta status;
	
	/**
	 * 顏色
	 */
	private BigDecimal color;

	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mid")
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@ManyToOne
	@JoinColumn(name="mt_id")
	public MotorcycleType getType() {
		return type;
	}

	public void setType(MotorcycleType type) {
		this.type = type;
	}


	@ManyToOne
	@JoinColumn(name="operation_office_id")
	public OperationOffice getOffice() {
		return office;
	}

	public void setOffice(OperationOffice office) {
		this.office = office;
	}


	@Column(name="license_number")
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	@Column(name="motor_number")
	public String getMotorNumber() {
		return motorNumber;
	}

	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}


	@ManyToOne
	@JoinColumn(name="status")
	public CodeMeta getStatus() {
		return status;
	}

	public void setStatus(CodeMeta status) {
		this.status = status;
	}

	@Column(name="sub_type")
	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Column(name="license_issue_date")
	public Date getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Date licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}
	
	@Column(name="color")
	public BigDecimal getColor() {
		return color;
	}

	public void setColor(BigDecimal color) {
		this.color = color;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
