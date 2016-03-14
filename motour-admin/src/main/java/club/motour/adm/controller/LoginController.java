package club.motour.adm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.service.Ss3aFunctionService;

import club.motour.adm.UserSessionStorage;
import club.motour.exception.LoginException;
import club.motour.model.Manager;
import club.motour.service.UserService;

@Controller
@Scope("prototype")
public class LoginController extends BaseController {

	@Autowired
	Ss3aFunctionService functionService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String login(String userId, String password) {
		
		//User user = null;
		Manager manager = null ;
		try {
			manager = userService.loginAdminUser(userId, password);
			userSessionStorage.setManager(manager); 
		} catch (LoginException e) {
			e.printStackTrace();
			//setMessage(MessageUtils.getInstance().getMessageByMessageCode(e.getMsgCode()));
			setMessage(e.getMessage());
			return "index";
		}
		
		List<Function> menus = functionService.getMenuTree(new ArrayList<>(manager.getUser().getSs3aMember().getRoles()));
		userSessionStorage.setMenus(menus);
		
		userSessionStorage.setActiveMenu(menus == null||menus.size()==0? null : menus.get(0));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard() {
		return "main";
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		userSessionStorage = new UserSessionStorage();
		HttpSession session = getHttpSession();
		if(session != null) {
			session.setMaxInactiveInterval(1);
		}
		return "redirect:/index";
	}
}
