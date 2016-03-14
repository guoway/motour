package club.motour.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import club.motour.model.Manager;
import club.motour.test.TestTemplate;

public class ManagerServiceTest extends TestTemplate {

	@Autowired
	ManagerService service;
	
	@Test
	public void testgetAllManagers() {
		List<Manager> list = service.getAllManagers();
		list.forEach((Manager m)-> System.out.println(m.getId()));
	}
}
