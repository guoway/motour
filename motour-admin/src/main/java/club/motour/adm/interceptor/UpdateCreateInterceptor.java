package club.motour.adm.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * UpdateCreateInterceptor主要的功能用於取得使用者當前功能是屬於update或create，
 * 並依此於request中增加一個變數(actionType)來提供jsp識別當前動作是update或create，
 * 因此請盡量將新增與修改功能頁面合併為一頁，以減少維運負擔。
 * 也因此，故新增、修改功能之url請務必符合Pattern。Pattern如下：
 * Create: ".*Create.*" 不包含quote字元，如"roleCreateShow", "roleCreate", "somethingCreatesomething"
 * Update: ".*Update.*" 同Create
 * 
 * 
 * @author Ken Chen
 */
@Component
@Scope("prototype")
public class UpdateCreateInterceptor extends HandlerInterceptorAdapter {


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerMethod m = (HandlerMethod)handler;
		RequestMapping rm = m.getMethodAnnotation(RequestMapping.class);
		
		Pattern updatePattern = Pattern.compile(".*Update.*");
		Pattern createPattern = Pattern.compile(".*Create.*");
		for(String url : rm.value()) {
			if(updatePattern.matcher(url).matches()) {
				request.setAttribute("actionType", "update");
			}
			if(createPattern.matcher(url).matches()) {
				request.setAttribute("actionType", "create");
			}
		}
	}
}
