package club.motour.dao;

import org.springframework.beans.factory.annotation.Autowired;

import club.motour.test.TestTemplate;

public class MessageDAOTest extends TestTemplate {

	@Autowired
	MessageDAO dao;
	
	@org.junit.Test
	public void testgenerateMsgId() {
		
		String id = dao.generateMsgId();
		System.out.println(id);
	}
}
