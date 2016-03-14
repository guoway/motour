package club.motour.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import club.motour.test.TestTemplate;

public class UserVerificationCodeDAOTest extends TestTemplate {

	@Autowired
	UserVerificationCodeDAO dao;
	
	//@org.junit.Test
	@Transactional
	public void testdeleteByUserIdAndVType() {
		System.out.println(dao.deleteByUserIdAndVType("ken@sylksoft.com", new BigDecimal(13)));
	}
	
	@org.junit.Test
	@Transactional
	@Commit
	public void testDeleteById() {
		System.out.println(dao.deleteById(new BigDecimal(20)));
	}
}
