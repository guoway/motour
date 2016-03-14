package club.motour.adm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;

import club.motour.model.Manager;
import club.motour.model.OperationOffice;
import club.motour.model.User;
import club.motour.model.enums.MessageCode;
import club.motour.service.ManagerService;
import club.motour.service.OperationOfficeService;
import club.motour.service.UserService;
import club.motour.util.MessageUtils;

@Controller
@SessionAttributes("manager")
public class ManagerController extends BaseController {

	@Autowired
	UserService userService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	OperationOfficeService operationOfficeService;
	
	@RequestMapping(value="/mgrList")
	public String list() {
		return "system_mgmt/mgr/mgr_mgmt";
	}
	
	@RequestMapping(value="/mgrSearch", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public @ResponseBody PageResponse search(PageRequest pageRequest) {
		PageResponse res = managerService.getAllManagers(pageRequest);
		return res;
	}
	
	@RequestMapping(value="/mgrUpdate", method=RequestMethod.GET)
	public String updateShow(String mgrId, ModelMap model) {
		
		try {
			Manager manager = managerService.findManagerById(mgrId);
			model.addAttribute("manager", manager);
			
			List<OperationOffice> offices = operationOfficeService.findAll();
			model.addAttribute("officesList", offices);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "system_mgmt/mgr/mgr_view";
	}
	
	@RequestMapping(value="/mgrUpdate", method=RequestMethod.POST)
	public String update(@ModelAttribute("manager") Manager manager, SessionStatus status) {		
		try {
			managerService.updateManager(manager);
			status.setComplete();
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.UPDATE_MANAGER_SUCCESS));	
		} catch (Exception e) {
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.UPDATE_MANAGER_FAIL));	
			e.printStackTrace();
		}		
		
		return "redirect:mgrUpdate?mgrId=" + manager.getId();
	}
	
	@RequestMapping(value="/mgrUpdateCancelPassAuth", method=RequestMethod.GET)
	public String cancelUpdate(SessionStatus status) {
		status.setComplete();
		return "redirect:mgrList";
	}
	
	@RequestMapping(value="/mgrCreate", method=RequestMethod.GET)
	public String createShow(SessionStatus status, ModelMap model) {
		status.setComplete();
		List<OperationOffice> offices = operationOfficeService.findAll();
		model.addAttribute("officesList", offices);

		return "system_mgmt/mgr/mgr_view";
	}
	
	@RequestMapping(value="mgrCreate", method=RequestMethod.POST)
	public String create(Manager manager, ModelMap model) {
		try {
			manager = managerService.createManager(manager);
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_MANAGER_SUCCESS));	
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_MANAGER_FAIL));	
		}
		
		return "redirect:mgrUpdate?mgrId=" + manager.getId();
	}
	
	@RequestMapping(value="mgrUpdatePassword", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updatePassword(@ModelAttribute("manager") User manager, String newPassword, ModelMap model) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			userService.resetPassword(manager.getId(), newPassword);
			User m = userService.findUserByUserId(manager.getId());
			model.addAttribute("manager", m);
			result.put("result", true);
			result.put("message", MessageUtils.getInstance().getMessageByMessageCode(MessageCode.PASSWORD_UPDATE_SUCCESS));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
			result.put("message", MessageUtils.getInstance().getMessageByMessageCode(MessageCode.PASSWORD_UPDATE_FAIL));
		}
		return result;
	}
	
	@RequestMapping(value="/mgrDelete", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> removeManager(String mgrId) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			managerService.removeManager(mgrId);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("messageCode", MessageCode.UPDATE_MANAGER_FAIL.toString());
		} 
		
		return resultMap;
	}
	
	/**
	 * 驗證欲註冊的Email是否已被人註冊
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/validUser", method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE}, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean validUser(@RequestBody String email){
		try {
			User user = userService.findUserByUserId(email) ;
			return (user!=null)?false:true ;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return false ;
		}
	}
}
