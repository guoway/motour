package club.motour.adm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import club.motour.adm.UserSessionStorage;
import club.motour.model.Message;

public class BaseController {

	Logger log = Logger.getLogger(getClass());
	
	protected UserSessionStorage userSessionStorage = new UserSessionStorage();
	
	public void setMessage(Message msg) {
		getHttpSession().setAttribute("mtMessage", msg.getContent());
	}
	
	public void setMessage(String content) {
		getHttpSession().setAttribute("mtMessage", content);
	}
	
	public HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest();
	}
	
	public HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}
	
	public UserSessionStorage getUserSessionStorage() {
		return userSessionStorage;
	}
}
