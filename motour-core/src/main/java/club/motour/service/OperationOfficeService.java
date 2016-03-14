package club.motour.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import club.motour.model.GetMotorLocation;
import club.motour.model.OperationOffice;

public interface OperationOfficeService {

	
	/**
	 * 取出某特定摩途據點
	 * @param officeId
	 * @param withFetch 是否取出關聯資料
	 * @return OperationOffice
	 * 
	 */
	public OperationOffice getOperationOfficeById(BigDecimal officeId, boolean withFetch);
	
	
	/**
	 * 取得在首頁上顯示的摩途據點
	 * @return List<OperationOffice>
	 */
	public List<OperationOffice> getShowInIndexOperationOffices();
	
	/**
	 * 取得所有可營運之摩途據點
	 * 僅取出據點名稱、id
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getSimpleDataEnabledOperationOffices();
	
	/**
	 * 取出可分頁的摩途據點(前台用)
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getPageableOperationOffices();
	
	/**
	 * 取出取還車點
	 * @param gmId
	 * @return GetMotorLocation
	 */
	public GetMotorLocation findMotorLocationById(BigDecimal gmId) ;
	
	public List<OperationOffice> findAll();
}
