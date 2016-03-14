package club.motour.dao;

import com.sylksoft.generic.GenericDAO;

import club.motour.model.Message;

public interface MessageDAO extends GenericDAO<Message, String> {

	/**
	 * 取得一筆新的message id
	 * @return
	 */
	public String generateMsgId();
}
