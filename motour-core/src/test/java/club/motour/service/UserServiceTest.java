package club.motour.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sylksoft.ss3a.model.Ss3aMember;

import club.motour.exception.VerificationCodeException;
import club.motour.model.User;
import club.motour.test.TestTemplate;


public class UserServiceTest extends TestTemplate {

	@Autowired
	UserService userService;
	
	//@Test
	public void testCreateUser() throws Exception {
		User u = new User();
		u.setId("ken12@sylksoft.com");
		u.setName("陳國瑋");
		
		Ss3aMember m = new Ss3aMember();
		m.setId(u.getId());
		m.setEnabled(false);
		m.setPassword("1234");
		u.setSs3aMember(m);
		
		userService.createWebUser(u);
	}
	
	//@Test
	public void testEnableWebUser() throws VerificationCodeException {
		String userId = "ken12@sylksoft.com";
		String vCode = "48554f5e58d3c4f131bd426c22987d6b";
		userService.enableWebUser(userId, vCode);
	}
}
