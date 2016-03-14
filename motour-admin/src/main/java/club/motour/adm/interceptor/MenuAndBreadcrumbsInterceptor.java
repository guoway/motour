package club.motour.adm.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.util.FunctionUtils;

import club.motour.adm.controller.BaseController;

@Component
@Scope("session")
public class MenuAndBreadcrumbsInterceptor extends HandlerInterceptorAdapter {


	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		String urlPath = request.getServletPath();
		
		Function f = FunctionUtils.getInstance().getFunctionByUrl(urlPath);
		
		if(null != f) {
			HandlerMethod m = (HandlerMethod)handler;
			BaseController c = (BaseController)m.getBean();
			c.getUserSessionStorage().setActiveMenu(f);
			
			List<Function> breadcrumbs = new ArrayList<>();
			recursiveGenerateBreadcrumbs(breadcrumbs, f);
			Collections.reverse(breadcrumbs);
			c.getUserSessionStorage().setBreadcrumb(breadcrumbs);
		}
	}
	
	private void recursiveGenerateBreadcrumbs(List<Function> breadcrumbs, Function leafFunction) {
		breadcrumbs.add(leafFunction);
		if(null != leafFunction.getParent()) {
			recursiveGenerateBreadcrumbs(breadcrumbs, leafFunction.getParent());
		} 		
	}
}
