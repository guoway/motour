package club.motour.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.model.Role;
import com.sylksoft.ss3a.service.Ss3aFunctionService;

import club.motour.test.TestTemplate;

public class Ss3aFunctionServiceTest extends TestTemplate {

	@Autowired
	private Ss3aFunctionService service;
	
	@Test
	public void testgetMenuTree() {
		List<Role> roleList = new ArrayList<>();
		roleList.add(new Role("administrator"));
		roleList.add(new Role("adm_user"));
		List<Function> list = service.getMenuTree(roleList);
		for(Function f : list) {
			System.out.println(f.getName());
		}
	}
}
