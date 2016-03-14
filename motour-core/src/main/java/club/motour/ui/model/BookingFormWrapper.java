package club.motour.ui.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BookingFormWrapper implements Serializable {

	private static final long serialVersionUID = 4890180660417871218L;

	/**
	 * 開始日期
	 */
	private String startDatetime;
	
	/**
	 * 開始時間
	 */
	private String startTime ;
	/**
	 * 結束日期
	 */
	private String endDatetime ;
	/**
	 * 租賃方案
	 */
	private char rentPlan;
	/**
	 * 租期(日)
	 */
	private int rentDay;

	/**
	 * 營業據點ID
	 */
	private BigDecimal motorOffice;
	/**
	 * 營業據點
	 */
	private String motorOfficeName ;
	/**
	 * 取車點ID
	 */
	private BigDecimal motorLocation ;
	/**
	 * 取車點
	 */
	private String motorLocationName ;

	/**
	 * 車型資料
	 */
	private List<MotorType> motorTypesList;
	
	private int totalMoney ;

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public char getRentPlan() {
		return rentPlan;
	}

	public void setRentPlan(char rentPlan) {
		this.rentPlan = rentPlan;
	}

	public int getRentDay() {
		return rentDay;
	}

	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}

	public List<MotorType> getMotorTypesList() {
		return motorTypesList;
	}

	public void setMotorTypesList(List<MotorType> motorTypesList) {
		this.motorTypesList = motorTypesList;
	}

	public String getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
	}

	public BigDecimal getMotorOffice() {
		return motorOffice;
	}

	public void setMotorOffice(BigDecimal motorOffice) {
		this.motorOffice = motorOffice;
	}

	public String getMotorOfficeName() {
		return motorOfficeName;
	}

	public void setMotorOfficeName(String motorOfficeName) {
		this.motorOfficeName = motorOfficeName;
	}

	public BigDecimal getMotorLocation() {
		return motorLocation;
	}

	public void setMotorLocation(BigDecimal motorLocation) {
		this.motorLocation = motorLocation;
	}

	public String getMotorLocationName() {
		return motorLocationName;
	}

	public void setMotorLocationName(String motorLocationName) {
		this.motorLocationName = motorLocationName;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	
}
