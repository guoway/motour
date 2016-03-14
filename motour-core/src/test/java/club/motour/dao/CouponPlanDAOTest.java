package club.motour.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import club.motour.model.CouponPlan;
import club.motour.test.TestTemplate;

public class CouponPlanDAOTest extends TestTemplate {

	@Autowired
	CouponPlanDAO dao;
	
	//@org.junit.Test
	public void testFindById() {
		CouponPlan c = dao.findById(new BigDecimal(1));
		System.out.println(c.getName());
	}
	
	@org.junit.Test
	@Transactional
	@Commit
	public void testMakePersistence() {
		CouponPlan cp = new CouponPlan();
		cp.setName("Teeeeest");
		dao.makePersistent(cp);
	}
}
