package club.motour.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import club.motour.test.TestTemplate;

public class MotorcycleServiceTest extends TestTemplate {

	@Autowired
	MotorcycleService service;
	
	@Test
	public void testgetAvailableMotors() {
		Date orderTime = new Date();
		BigDecimal officeId = new BigDecimal(2);
		int rentDay = 2;
		List<Map<String, Object>> list = service.getAvailableMotors(orderTime, officeId, rentDay);
		for(Map<String, Object> m : list) {
			for(String key : m.keySet()) {
				System.out.println(key + ":" + m.get(key));
			}
 		}
	}
}
