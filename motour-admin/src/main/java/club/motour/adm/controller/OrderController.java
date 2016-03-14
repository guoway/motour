package club.motour.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.sylksoft.generic.PageResponse;
import club.motour.search.obj.OrderNativeSearch;
import club.motour.service.OrderService;

@Controller
@SessionAttributes("order")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService ;
	
	@RequestMapping(value="/orderList")
	public String list(){
		return "business_mgmt/order/list" ;
	}
	
	@RequestMapping(value="/orderSearch", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageResponse getOrderList(OrderNativeSearch orderSearch){
		
//		Set<OperationOffice> oos = getUserSessionStorage().getManager().getOffices() ;
//		List<BigDecimal> oIds = new ArrayList<>() ;
//		if(null == orderSearch || orderSearch.getOfficeIds().length == 0){
//			for(OperationOffice oo :oos ){
//				oIds.add(oo.getId()) ;
//			}
//		} 
//		orderSearch.setOfficeIds((BigDecimal[])oIds.toArray());
		PageResponse res = orderService.getOrderListSearch(orderSearch) ; 
		
		return res ;
	}
}
