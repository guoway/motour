package club.motour.service;

import java.math.BigDecimal;

import club.motour.model.RentPlan;


public interface RentPlanService {
	
	public RentPlan findRentPlanByMtIdAndBasicPlanType(BigDecimal mtId,String basicPlanType) ;

}
