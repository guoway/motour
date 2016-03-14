package club.motour.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import club.motour.model.RentPlan;
import club.motour.test.TestTemplate;

public class RentPlanDAOTest extends TestTemplate {

	@Autowired
	RentPlanDAO rentPlanDAO;
	
	@Test
	public void testGetAll() {
		
		List<RentPlan> list = rentPlanDAO.findAll();
		
		for(RentPlan r : list) {
			System.out.println(r.getBasicPlanType().getType());
		}
	}
	
}
