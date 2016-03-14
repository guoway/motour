package club.motour.adm;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sylksoft.ss3a.model.Function;

import club.motour.model.Manager;
import club.motour.model.User;

@Component
@Scope("session")
public class UserSessionStorage implements Serializable {

	private static final long serialVersionUID = 5569909152074497768L;
	
	private final String KEY_USER = "loginUser";
	private final String KEY_MANAGER = "loginManager" ;

	private final String KEY_ACTIVE_MENU = "activeMenu";
	
	private final String KEY_MENUS = "menus";
	
	private final String KEY_BREADCRUMB = "breadcrumbs";
	
	/**
	 * 回傳function id
	 * @return
	 */
	public Function getActiveMenu() {
		return (Function)getAttributeFromSession(KEY_ACTIVE_MENU);
	}
	
	public void setActiveMenu(Function activeMenu) {
		setAttributeToSession(KEY_ACTIVE_MENU, activeMenu);
	}
	
	@SuppressWarnings("unchecked")
	public List<Function> getMenus() {
		return (List<Function>)getAttributeFromSession(KEY_MENUS);
	}
	
	public void setMenus(List<Function> menus) {
		setAttributeToSession(KEY_MENUS, menus);
	}
	
	public Manager getManager(){
		return (Manager)getAttributeFromSession(KEY_MANAGER) ;
	}
	public void setManager(Manager manager){
		setAttributeToSession(KEY_MANAGER, manager);
	}
	
	public User getUser() {
		return (User)getAttributeFromSession(KEY_USER);
	}

	public void setUser(User user) {
		setAttributeToSession(KEY_USER, user);
	}
	
	@SuppressWarnings("unchecked")
	public List<Function> getBreadcrumb() {
		return (List<Function>)getAttributeFromSession(KEY_BREADCRUMB);
	}
	
	public void setBreadcrumb(List<Function> breadcrumb) {
		setAttributeToSession(KEY_BREADCRUMB, breadcrumb);
	}

	private Object getAttributeFromSession(String name) {
		return getSeesion().getAttribute(name);
	}
	
	private void setAttributeToSession(String name, Object value) {
		getSeesion().setAttribute(name, value);
	}
	
	private HttpSession getSeesion() {
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		return session;
	}
}
