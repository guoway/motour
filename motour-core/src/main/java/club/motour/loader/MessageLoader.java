package club.motour.loader;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sylksoft.ss3a.loader.PreLoader;

import club.motour.model.Message;
import club.motour.service.MessageService;
import club.motour.util.MessageUtils;

@Component
@Qualifier("messageLoader")
public class MessageLoader implements PreLoader {

	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	MessageService msgService;
	
	@Override
	public void load() {
		log.info("start message loader");
		List<Message> list = msgService.getAllMessages();
		MessageUtils.getInstance().reloadMessageList(list);
		log.info("end message loader");
	}

}
