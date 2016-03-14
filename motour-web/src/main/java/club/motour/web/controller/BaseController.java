package club.motour.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import club.motour.model.Message;
import club.motour.model.User;

public class BaseController {

	Logger log = Logger.getLogger(getClass());
	
	public void setUserInSession(User user) {
		getHttpSession().setAttribute("user", user);
	}
	
	public User getUserInSession() {
		User u = getHttpSession().getAttribute("user") == null ? null : (User)getHttpSession().getAttribute("user");
		return u;
	}
	
	public void setMessage(Message msg) {
		getHttpSession().setAttribute("mtMessage", msg.getContent());
	}
	
	public HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest();
	}
	
	public HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
}
