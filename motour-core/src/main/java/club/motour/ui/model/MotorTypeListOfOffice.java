package club.motour.ui.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sylksoft.sql.annotation.ColumnMapping;

public class MotorTypeListOfOffice implements Serializable {

	private static final long serialVersionUID = -5051464812830737046L;
	
	@ColumnMapping(columnName="mt_id")
	private BigDecimal mtId;
	
	@ColumnMapping(columnName="name")
	private String motorTypeName;
	
	@ColumnMapping(columnName="brand")
	private String brandName;
	
	@ColumnMapping(columnName="double_load")
	private String doubleLoad;
	
	@ColumnMapping(columnName="max_speed")
	private BigDecimal maxSpeed;
	
	@ColumnMapping(columnName="battery_type")
	private String batteryType;
	
	@ColumnMapping(columnName="proper_license")
	private String properLicense;
	
	@ColumnMapping(columnName="slope")
	private BigDecimal slope;
	
	@ColumnMapping(columnName="stamina")
	private BigDecimal stamina;
	
	@ColumnMapping(columnName="rentFee")
	private String rentFee;
	
	@ColumnMapping(columnName="numberOfMotor")
	private BigDecimal numberOfMotor;
	
	@ColumnMapping(columnName="image")
	private String imagePath;

	private List<Map<BigDecimal, String>> getMotorLocations = new ArrayList<>();
	
	public BigDecimal getMtId() {
		return mtId;
	}

	public void setMtId(BigDecimal mtId) {
		this.mtId = mtId;
	}

	public String getMotorTypeName() {
		return motorTypeName;
	}

	public void setMotorTypeName(String motorTypeName) {
		this.motorTypeName = motorTypeName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getDoubleLoad() {
		return doubleLoad;
	}

	public void setDoubleLoad(String doubleLoad) {
		this.doubleLoad = doubleLoad;
	}

	public BigDecimal getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(BigDecimal maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public String getProperLicense() {
		return properLicense;
	}

	public void setProperLicense(String properLicense) {
		this.properLicense = properLicense;
	}

	public BigDecimal getSlope() {
		return slope;
	}

	public void setSlope(BigDecimal slope) {
		this.slope = slope;
	}

	public BigDecimal getStamina() {
		return stamina;
	}

	public void setStamina(BigDecimal stamina) {
		this.stamina = stamina;
	}

	public BigDecimal getNumberOfMotor() {
		return numberOfMotor;
	}

	public void setNumberOfMotor(BigDecimal numberOfMotor) {
		this.numberOfMotor = numberOfMotor;
	}

	public String getRentFee() {
		return rentFee;
	}

	public void setRentFee(String rentFee) {
		this.rentFee = rentFee;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Map<BigDecimal, String>> getGetMotorLocations() {
		return getMotorLocations;
	}

	public void setGetMotorLocations(List<Map<BigDecimal, String>> getMotorLocations) {
		this.getMotorLocations = getMotorLocations;
	}
	
	
	
}
