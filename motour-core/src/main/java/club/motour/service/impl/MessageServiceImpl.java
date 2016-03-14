package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.motour.dao.MessageDAO;
import club.motour.model.Message;
import club.motour.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;
	
	@Override
	public Message createMessage(String content, BigDecimal type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> msgs = messageDAO.findAll();
		return msgs;
	}

	
}
