package club.motour.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sylksoft.generic.PageResponse;

import club.motour.search.obj.DispatchMotorSearch;
import club.motour.service.DispatchMotorService;


@Controller
public class MotorOperationController extends BaseController {

	@Autowired
	private DispatchMotorService dispatchMotorService;
	
	@RequestMapping(value="/dispatchList")
	public String list()  {
		return "office_mgmt/dispatch_list";
	}
	
	@RequestMapping(value="/dispatchSearch", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageResponse search(DispatchMotorSearch search) {
	
		PageResponse response = dispatchMotorService.searchForDispatch(search);
		return response;
	}
}
