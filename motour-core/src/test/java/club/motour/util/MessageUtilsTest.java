package club.motour.util;

import org.junit.Test;

import club.motour.model.Message;
import club.motour.model.enums.MessageCode;
import club.motour.test.TestTemplate;

public class MessageUtilsTest extends TestTemplate {

	MessageUtils util;
	
	@Test
	public void testgetMessageById() {
		Message m = MessageUtils.getInstance().getMessageById(MessageCode.DELETE_DATA_FAIL.toString(), new String[]{"Test"});
		System.out.println(m.getContent());
	}
}
