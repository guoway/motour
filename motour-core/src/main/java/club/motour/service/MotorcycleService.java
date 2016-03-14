package club.motour.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import club.motour.model.MotorcycleType;
import club.motour.ui.model.MotorTypeListOfOffice;

public interface MotorcycleService {

	/**
	 * 取得某摩托據點所擁有之所有車型(及各車型所擁有之可租用車數)。
	 * @param officeId
	 * @return List<MotorTypeListOfOffice>
	 */
	public List<MotorTypeListOfOffice> getMotorTypeListOfOffice(BigDecimal officeId);
	
	/**
	 * 取得某據點於某時間點上可租用的所有車型(及各車型所擁有之可租用車數)。
	 * @param orderTime
	 * @param officeId
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getAvailableMotors(Date orderTime, BigDecimal officeId, Integer rentDay);
	
	/**
	 * 
	 * @param mtId
	 * @return motorcycleType
	 */
	public MotorcycleType getMotorTypeById(BigDecimal mtId);
}
