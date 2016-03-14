package club.motour.web.controller;


import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import club.motour.esafe.model.CashFlowRequest;
import club.motour.esafe.model.CashFlowResponse;
import club.motour.model.CashFlow;
import club.motour.model.Order;
import club.motour.model.OrderDetail;
import club.motour.model.RentPlan;
import club.motour.model.User;
import club.motour.model.enums.BasicPlanType;
import club.motour.model.enums.MessageCode;
import club.motour.model.enums.OrderStatus;
import club.motour.model.enums.UniformInvoiceType;
import club.motour.service.MotorcycleService;
import club.motour.service.OperationOfficeService;
import club.motour.service.OrderService;
import club.motour.service.RentPlanService;
import club.motour.service.UserService;
import club.motour.ui.model.BookingFormWrapper;
import club.motour.ui.model.BookingUserInfoWrapper;
import club.motour.ui.model.MotorType;
import club.motour.util.MessageUtils;
import club.motour.web.annotation.FormToken;

@Controller
@Scope("prototype")
public class BookingController extends BaseController{

	Logger log = Logger.getLogger(BookingController.class) ;
	
	@Autowired
	OperationOfficeService operationOfficeService;
	@Autowired
	RentPlanService rentPlanService ;
	@Autowired
	MotorcycleService motorcycleService;
	@Autowired
	OrderService orderService ;
	@Autowired
	UserService userService ;
	
	
	private static String BOOKINGFORM_IN_SESSION = "bookingFormInSession" ;

	/**
	 * 預訂表單
	 * @param mtId
	 * @param numberOfMotor
	 * @param oId
	 * @param startDatetime
	 * @param endDatetime
	 * @param model
	 * @return
	 */
	@FormToken(save=true)
	@RequestMapping(value="/booking", method={RequestMethod.POST})
	public String booking(BookingFormWrapper bookingWrapper, ModelMap model){
		//Gson gson = new Gson();
		BookingFormWrapper sessionWrapper =(BookingFormWrapper) getHttpSession().getAttribute(BOOKINGFORM_IN_SESSION) ;
		
		if(sessionWrapper !=null){
			bookingWrapper = sessionWrapper ;
			model.addAttribute("wrapper", bookingWrapper) ;
		}else{
			RentPlan rp =null ;
			try {
				int subTotal = 0 ;
				int total = 0 ;
				for(MotorType mt : bookingWrapper.getMotorTypesList()){
					rp = rentPlanService.findRentPlanByMtIdAndBasicPlanType(mt.getMotorTypeCode(), String.valueOf(bookingWrapper.getRentPlan())) ;
					mt.setRentPlan(rp);
					//rentDate 0 , 即可表示半日
					if(rp.getBasicPlanType()==BasicPlanType.getBasicPlanTypeByType('H')){
						subTotal = (rp.getPrice().intValue() * mt.getMotorQuantity());
					}else{
						subTotal = (rp.getPrice().intValue() * mt.getMotorQuantity())*bookingWrapper.getRentDay() ;
					}
					
					mt.setSubTotal(subTotal);
					total +=subTotal;
				}
				bookingWrapper.setTotalMoney(total);
				//還車日 = 開始日+rentDate
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd") ;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
				Date startD = df.parse(bookingWrapper.getStartDatetime()) ;
				Calendar calendar = Calendar.getInstance() ;
				calendar.setTime(startD);
				calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(bookingWrapper.getStartTime().split(":")[0]));
				calendar.set(Calendar.MINUTE, Integer.parseInt(bookingWrapper.getStartTime().split(":")[1]));
				bookingWrapper.setStartDatetime(sdf.format(calendar.getTime()));
				calendar.add(Calendar.DATE, bookingWrapper.getRentDay());
				bookingWrapper.setEndDatetime(sdf.format(calendar.getTime()));
				model.addAttribute("wrapper", bookingWrapper) ;
				getHttpSession().setAttribute(BOOKINGFORM_IN_SESSION, bookingWrapper);
				//getHttpSession().setAttribute("bookingJSON", gson.toJson(bookingWrapper));
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		}
		
		if(getUserInSession()==null){
			model.addAttribute("forwardAction", "booking") ;
			return "user/forwardLogin";
		}else{
			model.addAttribute("user", getUserInSession()) ;
		}
			
		model.addAttribute("invoiceTypes",UniformInvoiceType.values());
		return "booking/booking_step1";
		
	}
	
	@FormToken(remove=true)
	@RequestMapping(value="/bookingStep1", method={RequestMethod.POST})
	public @ResponseBody String bookingStep1(BookingUserInfoWrapper infoWrapper, ModelMap model){
	
		BookingFormWrapper w =(BookingFormWrapper) getHttpSession().getAttribute(BOOKINGFORM_IN_SESSION);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
		StringBuffer sb = new StringBuffer() ;
		try {
			if(w==null){
				setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_ORDER_ERROR));
				return genRediectForm(null);
			}
			User user = getUserInSession() ;
			Order order = new Order() ;
			order.setUser(user);
			order.setRenter(infoWrapper.getRenterName());
			order.setOrderTime(new Date());
			order.setRentTime(df.parse(w.getStartDatetime()));
			order.setPredictReturnTime(df.parse(w.getEndDatetime()));
			//取、還車點暫為同一個
			order.setGetMotorLocation(operationOfficeService.findMotorLocationById(w.getMotorLocation()));
			order.setReturnMotorLocation(operationOfficeService.findMotorLocationById(w.getMotorLocation()));
			order.setAmount(new BigDecimal(w.getTotalMoney()));
			order.setPhone(infoWrapper.getContactMobile());
			order.setEmail(user.getId());
			order.setIdentity(infoWrapper.getIdentity());
			order.setInvBid(infoWrapper.getInvBid());
			order.setInvAddress(infoWrapper.getInvAddress());
			order.setInvZip(infoWrapper.getInvZip());
			order.setInvTitle(infoWrapper.getInvTitle());
			order.setInvReceiver(infoWrapper.getInvReceiver());
			order.setInvType(infoWrapper.getInvType());
			//少收件人
			order.setCreateTime(new Date());
			order.setCreator(user.getName());
			
			//建立orderDetail
			Set<OrderDetail> oSet = new TreeSet<>();
			for(MotorType mt : w.getMotorTypesList()){
				OrderDetail od = new OrderDetail() ;
				od.setOrder(order);
				od.setMotorcycleType(motorcycleService.getMotorTypeById(mt.getMotorTypeCode()));
				od.setQuantity(new BigDecimal(mt.getMotorQuantity()));
				od.setRentPlan(mt.getRentPlan());
				od.setUnitPrice(mt.getRentPlan().getPrice());
				od.setTotalPrice(new BigDecimal(mt.getSubTotal()));
				od.setCreateTime(new Date());
				od.setCreator(user.getName());
				//此筆明細所租用車輛 , 未定義
				oSet.add(od) ;
			}
			order.setDetails(oSet);
			//產生訂單號碼
			String orderCode ;
			synchronized (orderService) {
				orderCode = orderService.createSequenceNumber() ;
			}
			order.setOrderCode(orderCode);
			order.setStatus(OrderStatus.BEGIN);
			order = orderService.createOrder(order) ;
			//更新user 資料
			user.setInvBid(infoWrapper.getInvBid());
			user.setInvTitle(infoWrapper.getInvTitle());
			user.setInvZip(infoWrapper.getInvZip());
			user.setInvAddress(infoWrapper.getInvAddress());
			//少收件人欄位
			user = userService.updateUserProfile(user) ;
			
			
			String pswSalt = "S16012290141qaz2wsx"+order.getAmount().toString();
			String chkValue = DigestUtils.shaHex(pswSalt).toUpperCase();
			String enc = "UTF-8" ;
			CashFlowRequest cReq = new CashFlowRequest() ;
			cReq.setWeb(URLEncoder.encode("S1601229014", enc));
			cReq.setMN(order.getAmount().intValue());
			cReq.setOrderInfo(URLEncoder.encode("預訂", enc)); 
			cReq.setTd(orderCode);
			cReq.setSna(URLEncoder.encode(order.getRenter(), enc));
			cReq.setSdt(new BigDecimal(order.getPhone()));
			cReq.setEmail(order.getEmail());
			cReq.setNote1("");
			cReq.setNote2("");
			cReq.setCard_Type(0);
			cReq.setCountry_Type("TW");
			cReq.setTerm(0);
			cReq.setChkValue(chkValue);
			
			
			sb = new StringBuffer() ;
			sb.append("<html><body>");
			sb.append("<form name=\"form1\" action=\" https://test.esafe.com.tw/Service/Etopm.aspx\" method=\"POST\">");
			sb.append("<input type=\"hidden\" name=\"web\" value=\""+cReq.getWeb()+"\" />");
			sb.append("<input type=\"hidden\" name=\"MN\" value=\""+cReq.getMN()+"\" />");
			sb.append("<input type=\"hidden\" name=\"OrderInfo\" value=\""+cReq.getOrderInfo()+"\" />");
			sb.append("<input type=\"hidden\" name=\"Td\" value=\""+cReq.getTd()+"\" />");
			sb.append("<input type=\"hidden\" name=\"sna\" value=\""+cReq.getSna()+"\" />");
			sb.append("<input type=\"hidden\" name=\"sdt\" value=\""+cReq.getSdt()+"\" />");
			sb.append("<input type=\"hidden\" name=\"email\" value=\""+cReq.getEmail() +"\" />");
			sb.append("<input type=\"hidden\" name=\"note1\" value=\""+cReq.getNote1() +"\" />");
			sb.append("<input type=\"hidden\" name=\"note2\" value=\""+cReq.getNote2() +"\" />");
			sb.append("<input type=\"hidden\" name=\"Card_Type\" value=\""+cReq.getCard_Type()+"\" />");
			sb.append("<input type=\"hidden\" name=\"Country_Type\" value=\""+cReq.getCountry_Type()+"\" />");
			sb.append("<input type=\"hidden\" name=\"Term \" value=\""+cReq.getTerm()+"\" />");
			sb.append("<input type=\"hidden\" name=\"ChkValue\" value=\""+cReq.getChkValue()+"\" />");
			sb.append("</form>");
			sb.append("<script language='Javascript'>");
			sb.append("document.form1.submit();");
			sb.append("</script>");
			sb.append("</body></html>");
						
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_ORDER_ERROR));
			return genRediectForm(w.getMotorOffice());
		} finally {
			//於紅陽回傳刷卡資訊後清除session
			//getHttpSession().removeAttribute(BOOKINGFORM_IN_SESSION);
		}
		
		return sb.toString() ;	
	}
	
	@RequestMapping(value="receiverBookingResp", method={RequestMethod.POST})
	public String receiveResp(CashFlowResponse cashRes, ModelMap model){
		try {
			String enc = "UTF-8" ;
			CashFlow c = new CashFlow() ;
			c.setId(cashRes.getBuysafeno());
			c.setWeb(URLDecoder.decode(cashRes.getWeb(),enc));
			c.setMN(new BigDecimal(cashRes.getMN()));
			c.setOrderCode(cashRes.getTd());
			c.setWebName(URLDecoder.decode(cashRes.getWebname(),enc));
			c.setName(URLDecoder.decode(cashRes.getName(),enc));
			c.setNote1(URLDecoder.decode(cashRes.getNote1(),enc));
			c.setNote2(URLDecoder.decode(cashRes.getNote2(),enc));
			c.setApproveCode(cashRes.getApproveCode());
			c.setCardNo(cashRes.getCard_NO());
			c.setSendType(cashRes.getSendType());
			c.setErrCode(cashRes.getErrcode());
			c.setErrMsg(URLDecoder.decode(cashRes.getErrmsg(),enc));
			c.setCardType(cashRes.getCard_Type());
			c.setChkValue(cashRes.getChkValue());
			c = orderService.createCashFlow(c) ;
		
			if(StringUtils.equals(cashRes.getErrcode(), "00")){
				orderService.updateOrderBuySafeNo(cashRes.getBuysafeno(), cashRes.getTd(), OrderStatus.CLOSE);
				setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.CREATE_ORDER_SUCCESS));
				//TODO:send email 
			}else{
				orderService.updateOrderBuySafeNo(cashRes.getBuysafeno(), cashRes.getTd(), OrderStatus.FAIL);
				setMessage(MessageUtils.getInstance().getMessageByMessageCode(MessageCode.TRANSACTION_FAIL, c.getErrMsg()));
				return "redircet:/booking" ;
			}
			
			model.addAttribute("res", cashRes) ;
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		} finally {
			getHttpSession().removeAttribute(BOOKINGFORM_IN_SESSION);
		}
		
		return "booking/booking_result" ;
	}
	
	
	private String genRediectForm(BigDecimal oid){
		StringBuffer sb = new StringBuffer() ;
		sb.append("<html><body>");
		sb.append("<form name=\"form1\" id='form1' action='/operationOffices'>");
		sb.append("</form>");
		sb.append("<script language='Javascript'>");
		if(oid==null){
			sb.append("location.href ='"+getHttpServletRequest().getContextPath()+"/operationOffice';") ;
		}else{
			sb.append("location.href ='"+getHttpServletRequest().getContextPath()+"/operationOffice?operationOfficeId="+oid+"';") ;
		}
		sb.append("</script>");
		sb.append("</body></html>");
		return sb.toString(); 
	}
}
