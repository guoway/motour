package club.motour.adm.controller;

import java.util.HashMap;
import java.util.Map;

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

import club.motour.exception.MotourException;
import club.motour.model.User;
import club.motour.model.enums.MessageCode;
import club.motour.service.UserService;
import club.motour.util.MessageUtils;

@Controller
@SessionAttributes("user")
public class UserController extends BaseController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/userList")
	public String list() {
		return "customer_service/user_mgmt";
	}
	
	@RequestMapping(value="/userSearch", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public @ResponseBody PageResponse getUserList(PageRequest pageRequest) {
		PageResponse res = userService.getAllUsers(pageRequest);
		return res;
	}
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.GET)
	public String updateShow(String userId, ModelMap model) {
		
		try {
			User user = userService.findUserByUserId(userId);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer_service/user_view";
	}
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.POST)
	public String update(@ModelAttribute("user") User user, SessionStatus status) {		
		try {
			userService.updateUserProfile(user);
			status.setComplete();
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.USER_PROFILE_UPDATE_SUCCESS));	
		} catch (Exception e) {
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.USER_PROFILE_UPDATE_FAIL));	
			e.printStackTrace();
		}		
		
		return "redirect:userUpdate?userId=" + user.getId();
	}
	
	@RequestMapping(value="/userUpdateCancelPassAuth", method=RequestMethod.GET)
	public String cancelUpdate(SessionStatus status) {
		status.setComplete();
		return "redirect:userList";
	}
	
	@RequestMapping(value="/userDelete", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> delete(String userId) {
		Map<String, Object> resultMap = new HashMap<>();
					
		try {
			userService.deleteUser(userId);
			resultMap.put("result", true);
		} catch (MotourException me) {
			resultMap.put("result", false);
			resultMap.put("messageCode", MessageCode.DELETE_DATA_FAIL.toString());
			resultMap.put("customMessage", me.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("messageCode", MessageCode.DELETE_DATA_FAIL.toString());
		} 
		
		return resultMap;
	}
}
