package club.motour.web.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import club.motour.service.OperationOfficeService;


@Controller
@Scope("prototype")
public class MotourController extends BaseController {

	Logger log = Logger.getLogger(MotourController.class) ;
	
	@Autowired
	OperationOfficeService operationOfficeService;
	
	@RequestMapping(value="index", method={RequestMethod.GET})
	public String index(Locale locale, ModelMap modelMap){
		modelMap.addAttribute("operationOfficeList", operationOfficeService.getShowInIndexOperationOffices());
		return "index";
	}
	@RequestMapping(value="testMessage" , method={RequestMethod.GET})
	public String testMessage(){
		return "testMessage" ; 
	}
}
