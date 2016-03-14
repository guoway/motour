package club.motour.web.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import club.motour.exception.VerificationCodeException;
import club.motour.model.User;
import club.motour.service.UserService;
import club.motour.util.MessageUtils;

@Controller
@Scope("prototype")
public class RegisterController extends BaseController{

	Logger log = Logger.getLogger(RegisterController.class) ;
	
	@Autowired
	UserService userService;
	
	/**
	 * 註冊
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register", method={RequestMethod.POST})
	public String register(User user, ModelMap model) {
		log.info("Registering User:" + user.getId());
		
		
		try {
			user = userService.createWebUser(user);
			log.info("User:" + user.getId() + " is registered");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("registererId", user.getId());

		return "user/reg_confirm";
	}

	/**
	 * ajax 註冊
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registerAjax", method={RequestMethod.POST})
	public @ResponseBody User registerAjax(User user, ModelMap model) {
		log.info("Registering User:" + user.getId());
		try {
			user = userService.createWebUser(user);
			log.info("User:" + user.getId() + " is registered");			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
		return user ;
	}
	
	@RequestMapping(value="/registerFromFB", method={RequestMethod.POST})
	public @ResponseBody boolean registerFromFB(User user, ModelMap model){
		log.info("Registering User From FB :" +user.getId());
		try {
			User u = userService.findUserByUserId(user.getId()) ;
			if(null==u){
				log.info("User : " + user.getId()+ "is registered");
				user.setEmail(user.getId());
				user = userService.createFBWebUser(user) ;
				setUserInSession(user);
				return true ;
			}else{
				if(StringUtils.isEmpty(u.getFbId())){
					//更新fbid
					u.setFbId(user.getFbId());
					userService.updateUserProfile(user) ;
				}
				setUserInSession(u);
				return true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return false ;
		}
	}
	
	/**
	 * 使用者開通
	 * @param userId
	 * @param vCode
	 * @return
	 */
	@RequestMapping(value="/enableUser/{userId}/{vCode}", method={RequestMethod.GET})
	public String enableUser(@PathVariable String userId, @PathVariable String vCode) {
		try {
			userService.enableWebUser(userId, vCode);
			return "redirect:/registerDone";
		} catch (VerificationCodeException e) {
			e.printStackTrace();
			return "redirect:/registerFailed";
		}
	}
	
	@RequestMapping(value="/registerDone", method={RequestMethod.GET})
	public String regDone() {
		return "user/reg_done";
	}
	
	@RequestMapping(value="/registerFailed", method={RequestMethod.GET})
	public String regFailed() {
		return "user/reg_failed";
	}
	
	/**
	 * 重送驗證碼
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/resendVcode", method={RequestMethod.GET})
	public String resendVcode(String userId, ModelMap model) {
		try {
			userService.resendVerificationCode(userId);
			model.addAttribute("registererId", userId);
		} catch (VerificationCodeException e) {
			model.addAttribute("returnMessage", MessageUtils.getInstance().getMessageByMessageCode(e.getMsgCode()));
			model.addAttribute("registererId", userId);
		}
		return "user/reg_confirm";
				
	}
	
	/**
	 * 驗證欲註冊的Email是否已被人註冊
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/validUser", method={RequestMethod.POST})
	public @ResponseBody boolean validUser(@RequestBody String email){
		try {
			User user = userService.findUserByUserId(email) ;
			return (user!=null)?false:true ;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return false ;
		}
	}
	
	@RequestMapping(value="/deleteUser", method={RequestMethod.GET})
	public @ResponseBody boolean deleteUser(String userId) {
		try {
			userService.deleteUser(userId);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 驗證欲註冊的Email是否已被人註冊
	 * @param email
	 * @return "N" 未註冊，"S"已開通，"F"未開通
	 */
	@RequestMapping(value="/checkEnableUser", method={RequestMethod.POST})
	public @ResponseBody String checkEnableUser(@RequestBody String email){
		try {
			User user = userService.findUserByUserId(email) ;
			if(null==user){
				return "N" ;
			}else{
				if(user.getSs3aMember().isEnabled()){
					return "S" ;
				}else{
					return "F" ;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return "N" ;
		}
	}
}
