package club.motour.dao;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import club.motour.model.User;
import club.motour.test.TestTemplate;

public class UserDAOTest extends TestTemplate {

	@Autowired
	UserDAO userDAO;
	
	@Test
	@Transactional
	public void testFindById() {
		User u = userDAO.findById("ken@sylksoft.com");
		System.out.println(u.getId());
	}

	//@Test
	@Transactional
	@Commit
	public void testMakePersistent() {
		User u = new User();
		u.setId("ken123@sylksoft.com");
		u.setIdentity("U121188365");
		u.setInvAddress("ttt");
		u.setMobile("0919319847");
		u.setName("陳國瑋");
		userDAO.makePersistent(u);
	}
}
