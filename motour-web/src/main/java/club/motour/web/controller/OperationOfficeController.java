package club.motour.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sylksoft.util.DateUtil;

import club.motour.service.MotorcycleService;
import club.motour.service.OperationOfficeService;

@Controller
@Scope("prototype")
public class OperationOfficeController extends BaseController {

	@Autowired
	OperationOfficeService operationOfficeService;
	
	@Autowired
	MotorcycleService motorcycleService;
	
	@RequestMapping(value="/operationOffices", method={RequestMethod.GET})
	public String operationOfficeList(ModelMap model){
		model.addAttribute("offices", operationOfficeService.getPageableOperationOffices());
		return "booking/office_list";
	}
	
	@RequestMapping(value="/operationOffice" , method={RequestMethod.GET})
	public String operationOffice(@RequestParam("operationOfficeId") BigDecimal oid, ModelMap model){
		
		model.addAttribute("office", operationOfficeService.getOperationOfficeById(oid, true));
		model.addAttribute("motorTypes", motorcycleService.getMotorTypeListOfOffice(oid));
		model.addAttribute("enabledOffices", operationOfficeService.getSimpleDataEnabledOperationOffices());
		return "booking/operation_office" ;
	}
	
	/**
	 * 預訂表單
	 * 1. 撈出 startDateTime(預訂租用時間) + officeId(營業點id) 可租用的車型、數量
	 * 2. 撈出officeId(營業點) 的 取車點List資料(用於selectbox) 
	 * @param startDatetime yyyy-MM-dd hh:mm
	 * @param officeId
	 * @param rentDay
	 * @return motorTypeListOffice 
	 */
	@RequestMapping(value="/getMotorTypeListOfOffice", method={RequestMethod.POST})
	public @ResponseBody List<Map<String, Object>> getMotorTypeListOfOffice(String startDatetime, BigDecimal officeId, Integer rentDay){
		getHttpSession().removeAttribute("bookingFormInSession");
		
		Date rentDate = DateUtil.parseDate(startDatetime, "yyyy-MM-dd hh:mm");
		
		List<Map<String, Object>> list = motorcycleService.getAvailableMotors(rentDate, officeId, rentDay);
		return list;
	}
	
}
