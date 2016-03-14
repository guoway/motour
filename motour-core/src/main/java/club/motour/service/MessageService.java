package club.motour.service;

import java.math.BigDecimal;
import java.util.List;

import club.motour.model.Message;

public interface MessageService {

	/**
	 * 建立Message
	 * @param content
	 * @param type reference to CodeMeta
	 * @return Message
	 */
	public Message createMessage(String content, BigDecimal type);
	
	/**
	 * 取得所有Messages
	 * @return
	 */
	public List<Message> getAllMessages();
}
