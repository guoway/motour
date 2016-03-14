package club.motour.web.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.motour.model.ContactUsMessage;
import club.motour.model.Message;
import club.motour.model.Order;
import club.motour.model.User;
import club.motour.model.enums.MessageCode;
import club.motour.model.enums.OrderStatus;
import club.motour.service.CustomerService;
import club.motour.service.OrderService;
import club.motour.service.UserService;
import club.motour.util.MessageUtils;

@Controller
@Scope("prototype")
public class CustomerServiceController extends BaseController {
	
	Logger log = Logger.getLogger(CustomerServiceController.class) ;
	
	@Autowired
	UserService userService;
	@Autowired
	OrderService orderService ;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customerservice", method={RequestMethod.GET})
	public String customerService(){
		return "customer_service/customer_index"; 
	}
	
	@RequestMapping(value="/discount", method={RequestMethod.GET})
	public String discount(){
		return "customer_service/discount" ;
	}
	
	@RequestMapping(value="/faq", method={RequestMethod.GET})
	public String faq(){
		return "customer_service/faq" ;
	}
	
	@RequestMapping(value="/joinus", method={RequestMethod.GET})
	public String joinUs(){
		return "customer_service/join_us" ;
	}
	
	@RequestMapping(value="/memberprofile", method={RequestMethod.GET, RequestMethod.POST})
	public String profile(ModelMap model){
		
		if(null==getUser()){
			model.addAttribute("forwardAction", "memberprofile") ;
			return "user/forwardLogin";
		}
		
		model.addAttribute("userInReq", getUserInSession());
		return "customer_service/member_profile" ;
	}
	
	@ModelAttribute("userInReq")
	public User getUser() {
		return getUserInSession();
	}
	
	@RequestMapping(value="/updateMemberProfile", method={RequestMethod.GET})
	public String updateProfile(@ModelAttribute("userInReq") User userInReq) {
		User u = userService.updateUserProfile(userInReq);
		
		setUserInSession(u);
		setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.USER_PROFILE_UPDATE_SUCCESS));
		
		return "redirect:memberprofile";
	}
	
	@RequestMapping(value="/orderlist", method={RequestMethod.GET})
	public String orderList(ModelMap model){
		
		if(null==getUser()){
			model.addAttribute("forwardAction", "orderlist") ;
			return "user/forwardLogin";
		}
		
		User user = getUser() ;
		List<Order> orders = orderService.findOrdersByUserId(user, Arrays.asList(OrderStatus.CLOSE, OrderStatus.CANCEL)) ;
		model.addAttribute("orders", orders) ;
		
		return "customer_service/order_list" ;
	}
	
	@RequestMapping(value="/contactUs", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Message contactUs(ContactUsMessage cu, ModelMap model) {
		customerService.createContactUsMessage(cu);
		return MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CONTACT_US_DONE);
	}
	
	@RequestMapping(value="/cancelOrder", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean cancelOrder(BigDecimal oId){
		try {
			orderService.cancelOrderById(oId, getUser());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return false; 
		}
		
		return true ;
	}
	
	@RequestMapping(value="/printDetail", method={RequestMethod.GET})
	public String printDetail(@RequestParam("code") String orderCode, ModelMap model){
		try {
			//未登入導登入頁
			if(null == getUser()){
				model.addAttribute("forwardAction", "orderlist") ;
				return "user/forwardLogin";
			}
			Order order = orderService.findOrderByOrderCode(orderCode, getUser().getName()) ;
			model.addAttribute("order", order) ;
		} catch (Exception e) {
			log.error(e.getMessage()); 
			return "redirect:orderlist";
		}

		return "customer_service/orderDetail" ;
	}
	
}
