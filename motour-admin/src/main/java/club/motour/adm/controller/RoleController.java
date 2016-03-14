package club.motour.adm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;
import com.sylksoft.ss3a.exception.ObjectNotFoundException;
import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.model.Role;
import com.sylksoft.ss3a.service.RoleService;
import com.sylksoft.ss3a.service.Ss3aFunctionService;

import club.motour.model.enums.MessageCode;
import club.motour.util.MessageUtils;

@Controller
@SessionAttributes("role")
public class RoleController extends BaseController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	Ss3aFunctionService functionService;
	
	@RequestMapping(value="/roleSearch", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public @ResponseBody PageResponse getRoleList(PageRequest pageRequest) {
		PageResponse res = roleService.getAllRoles(pageRequest);
		return res;
	}
	
	@RequestMapping(value="/rolesList")
	public String list() {
		return "system_mgmt/role/role_mgmt";
	}
	
	@RequestMapping(value="/roleCreate", method=RequestMethod.GET)
	public String createShow(SessionStatus status) {
		status.setComplete();
		return "system_mgmt/role/role_view";
	}
	
	@RequestMapping(value="roleCreate", method=RequestMethod.POST)
	public String create(Role role, ModelMap model) {
		role = roleService.createOrUpdateRole(role);
		setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_ROLE_SUCCESS));	
		return "redirect:roleUpdate?roleId=" + role.getId();
	}

	@RequestMapping(value="/roleUpdate", method=RequestMethod.GET)
	public String updateShow(String roleId, ModelMap model) {
		
		try {
			Role r = roleService.getRoleByIdForUpdate(roleId);
			model.addAttribute("role", r);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return "system_mgmt/role/role_view";
	}
	
	@RequestMapping(value="/roleUpdate", method=RequestMethod.POST)
	public String update(@ModelAttribute("role") Role role, SessionStatus status) {
		roleService.createOrUpdateRole(role);
		status.setComplete();
		setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.UPDATE_ROLE_SUCCESS));	
		return "redirect:roleUpdate?roleId=" + role.getId();
	}
	
	@RequestMapping(value="/roleUpdateCancelPassAuth", method=RequestMethod.GET)
	public String cancelUpdate(SessionStatus status) {
		status.setComplete();
		return "redirect:rolesList";
	}
	
	@RequestMapping(value="/roleDelete", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> delete(String roleId) {
		Map<String, Object> resultMap = new HashMap<>();
		boolean result = false;
		try {
			result = roleService.deleteRole(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		resultMap.put("result", result);
		if(!result) {
			resultMap.put("messageCode", MessageCode.DELETE_DATA_FAIL.toString());
		}
		
		return resultMap;
	}

	@RequestMapping(value="/roleFuncSetting", method=RequestMethod.GET)
	public String functionSettingShow(String roleId, ModelMap model) {
		try {
			Role r = roleService.getRoleByIdForUpdate(roleId);
			model.addAttribute("role", r);
			
			List<Function> functions = functionService.getMainFunctions(true);
			model.addAttribute("functions", functions);
			for(Function f : functions) {
				if(Collections.binarySearch(new ArrayList<>(r.getFunctions()), f) >= 0) {
					System.out.println(f.getId());
				}
			}
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return "system_mgmt/role/role_func_setting";
	}
	
	@RequestMapping(value="/roleFuncSetting", method=RequestMethod.POST)
	public String functionSetting(@ModelAttribute("role") Role role, String[] selectedFuncs, SessionStatus status) {
		
		Set<Function> newFunctions = new TreeSet<>();
		for(String f : selectedFuncs) {
			Function nf = new Function();
			nf.setId(f);
			newFunctions.add(nf);
		}
		role.setFunctions(newFunctions);
		
		roleService.createOrUpdateRole(role);
		status.setComplete();
		setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.UPDATE_ROLE_SUCCESS));	
		return "redirect:roleFuncSetting?roleId=" + role.getId();
	}
}
