package club.motour.adm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import club.motour.adm.controller.BaseController;
import club.motour.model.enums.MessageCode;
import club.motour.util.MessageUtils;

@Component
@Scope("prototype")
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod m = (HandlerMethod)handler;
		BaseController c = (BaseController)m.getBean();
		if(c.getUserSessionStorage().getManager() == null) {
			response.sendRedirect(request.getContextPath() + "/index");
			c.setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.USER_NOT_LOGIN_YET));
			return false;
		} else {
			return true;
		}
	}
}
