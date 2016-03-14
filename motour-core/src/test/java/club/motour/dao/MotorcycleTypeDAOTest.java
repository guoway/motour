package club.motour.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import club.motour.model.MotorcycleType;
import club.motour.test.TestTemplate;

public class MotorcycleTypeDAOTest extends TestTemplate {

	@Autowired
	MotorcycleTypeDAO dao;
	
	@Test
	public void testFindAll() {
		List<MotorcycleType> list = dao.findAll();
		for(MotorcycleType m : list) {
			System.out.println(m.getMandatoryImage().getImage().getImage());
		}
	}
}
