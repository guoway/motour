package club.motour.web.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import club.motour.esafe.model.CashFlowRequest;
import club.motour.esafe.model.CashFlowResponse;

@Controller
@Scope("prototype")
public class CashFlowTestController extends BaseController {

	Logger log = Logger.getLogger(CashFlowTestController.class) ;
	
	@RequestMapping(value="bookingtest", method={RequestMethod.GET})
	public String booking(ModelMap model){
		try {
			String pswSalt = "S16012290141qaz2wsx1000";
			String chkValue = DigestUtils.shaHex(pswSalt).toUpperCase();
			String enc = "UTF-8" ;
			CashFlowRequest cr = new CashFlowRequest() ;
			cr.setWeb(URLEncoder.encode("S1601229014", enc));
			cr.setMN(1000);
			cr.setOrderInfo(URLEncoder.encode("測試訂購", enc)); 
			cr.setTd("201601220001");
			cr.setSna(URLEncoder.encode("ryanchung", enc));
			cr.setSdt(new BigDecimal("0919319846"));
			cr.setEmail("ryan119@sylksoft.com");
			cr.setNote1("備註test");
			cr.setNote2("備註test2");
			cr.setCard_Type(0);
			cr.setCountry_Type("TW");
			cr.setTerm(0);
			cr.setChkValue(chkValue);
			
			model.addAttribute("req", cr) ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "booking_test";
	}
	
	@RequestMapping(value="sendReqToCashFlow", method={RequestMethod.POST})
	public String sendReqToCashFlow(){
		
		return "booking_send" ;
	}
	
	@RequestMapping(value="receiverResp", method={RequestMethod.POST})
	public String receiveResp(CashFlowResponse cashRes, ModelMap model){
		try {
			log.info(cashRes.getApproveCode());
			log.info(cashRes.getBuysafeno());
			log.info(cashRes.getCard_NO());
			log.info(cashRes.getChkValue());
			
			model.addAttribute("res", cashRes) ;
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return "booking_test result" ;
	}
	
}
