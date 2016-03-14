package club.motour.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_operation_office")
public class OperationOffice extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 2950175126879612676L;

	/**
	 * 據點名稱
	 */
	private String name;
	
	/**
	 * 郵遞區號。
	 */
	private String zip;
	
	/**
	 * 詳細地址
	 */
	private String address;
	
	/**
	 * 連絡電話
	 */
	private String tel;
	
	/**
	 * 管理者
	 */
	private User manager;
	
	/**
	 * 連絡人Email
	 */
	private String contactEmail;
	
	/**
	 * 連絡人行動電話
	 */
	private String contactMobile;
	
	private BigDecimal languageId;
	
	/**
	 * 是否於首頁上顯示
	 */
	private Boolean showInIndex;
	
	/**
	 * 取車點
	 */
	private Set<GetMotorLocation> getMotorLocations = new TreeSet<>();
	
	/**
	 * 主要圖檔
	 */
	private OperationOfficeMandatoryImage mandatoryImage;
	
	/**
	 * 介紹用圖檔
	 */
	private Set<OperationOfficeIntroImage> introImeges = new TreeSet<>();
	
	private Double latitude;
	
	private Double longitude;
	
	/**
	 * 排序
	 */
	private BigDecimal sortOrder;
	
	
	
	public OperationOffice() {
		// TODO Auto-generated constructor stub
	}
	
	public OperationOffice(BigDecimal id) {
		setId(id);
	}
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oid")
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


	@Column(name="zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(name="tel")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	@ManyToOne
	@JoinColumn(name="manager")
	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}


	@Column(name="contact_email")
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	@Column(name="contact_mobile")
	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	@Column(name="language_id")
	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	@Column(name="show_in_index")
	public Boolean getShowInIndex() {
		return showInIndex;
	}

	public void setShowInIndex(Boolean showInIndex) {
		this.showInIndex = showInIndex;
	}

	@OneToMany
	@JoinColumn(name="oid", referencedColumnName="oid")	
	public Set<GetMotorLocation> getGetMotorLocations() {
		return getMotorLocations;
	}

	public void setGetMotorLocations(Set<GetMotorLocation> getMotorLocations) {
		this.getMotorLocations = getMotorLocations;
	}

	@OneToOne(mappedBy="office")
	public OperationOfficeMandatoryImage getMandatoryImage() {
		return mandatoryImage;
	}

	public void setMandatoryImage(OperationOfficeMandatoryImage mandatoryImage) {
		this.mandatoryImage = mandatoryImage;
	}

	@OneToMany(fetch=FetchType.EAGER)	
	@JoinColumn(name="oid", referencedColumnName="oid")
	public Set<OperationOfficeIntroImage> getIntroImeges() {
		return introImeges;
	}

	public void setIntroImeges(Set<OperationOfficeIntroImage> introImeges) {
		this.introImeges = introImeges;
	}

	@Column(name="latitude")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name="longitude")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name="sort_order")
	public BigDecimal getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(BigDecimal sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
