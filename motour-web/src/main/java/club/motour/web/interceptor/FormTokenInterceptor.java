package club.motour.web.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import club.motour.model.enums.MessageCode;
import club.motour.ui.model.BookingFormWrapper;
import club.motour.util.MessageUtils;
import club.motour.web.annotation.FormToken;

public class FormTokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			if(handler instanceof HandlerMethod){
				HandlerMethod handlerMethod = (HandlerMethod) handler ;
				Method method = handlerMethod.getMethod() ;
				FormToken annotation = method.getAnnotation(FormToken.class);

				if(annotation!=null){
					boolean needSaveSession = annotation.save() ;
					if(needSaveSession){
						request.getSession(false).setAttribute("formToken", UUID.randomUUID().toString());
					}
					boolean needRemoveSession = annotation.remove() ;
					if(needRemoveSession){
						if (isRepeatSubmit(request)) {
							 BookingFormWrapper w = (BookingFormWrapper) request.getSession(false).getAttribute("bookingFormInSession") ;
							 if(null==w){
								 response.sendRedirect(request.getContextPath() + "/operationOffices");
							 }else{
								 response.sendRedirect(request.getContextPath() + "/operationOffice?operationOfficeId="+w.getMotorOffice());
							 }
							 
							 request.getSession(false).setAttribute("mtMessage", MessageUtils.getInstance().getMessageByMessageCode(MessageCode.REPEAT_SUBMIT_ERROR).getContent());
							 
		                     return false;
		                }
						
		                request.getSession(false).removeAttribute("formToken");
					}
				}
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/operationOffices");
			request.getSession().setAttribute("mtMessage", MessageUtils.getInstance().getMessageByMessageCode(MessageCode.SESSION_TIME_OUT).getContent());
		}
		
		return super.preHandle(request, response, handler);
	}
	
	 private boolean isRepeatSubmit(HttpServletRequest request) {
	        String serverToken = (String) request.getSession(false).getAttribute("formToken");
	        
	        if (serverToken == null) {
	            return true;
	        }
	        
	        String clinetToken = request.getParameter("formToken");
	        if (clinetToken == null) {
	            return true;
	        }
	        
	        if (!serverToken.equals(clinetToken)) {
	            return true;
	        }
	        
	        return false;
	    }
}
