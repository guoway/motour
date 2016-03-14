package club.motour.ui.model;

import java.math.BigDecimal;

import club.motour.model.RentPlan;

public class MotorType {
	private BigDecimal motorTypeCode;
	private String motorType ;
	private int motorQuantity ;
	private RentPlan rentPlan ;
	private int subTotal ;
	
	public BigDecimal getMotorTypeCode() {
		return motorTypeCode;
	}
	public void setMotorTypeCode(BigDecimal motorTypeCode) {
		this.motorTypeCode = motorTypeCode;
	}
	public String getMotorType() {
		return motorType;
	}
	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}


	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	public RentPlan getRentPlan() {
		return rentPlan;
	}
	public void setRentPlan(RentPlan rentPlan) {
		this.rentPlan = rentPlan;
	}
	public int getMotorQuantity() {
		return motorQuantity;
	}
	public void setMotorQuantity(int motorQuantity) {
		this.motorQuantity = motorQuantity;
	}
	

	
}
