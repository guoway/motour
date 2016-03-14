package club.motour.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import club.motour.model.Message;
import club.motour.model.enums.MessageCode;

public class MessageUtils {

	private static MessageUtils instance;
	
	private Map<String, Message> msgs = new HashMap<>();
	
	private MessageUtils() {
		
	}
	
	public static MessageUtils getInstance() {
		if(null == instance) {
			instance = new MessageUtils();			
		}
		return instance;
	}
	
	public void reloadMessageList(List<Message> messages) {
		
		Map<String, Message> map = new HashMap<>();
		for(Message msg : messages) {
			map.put(msg.getId(), msg);
		}
		
		synchronized(msgs) {
			msgs = map;			
		}
	}
	
	public Message getMessageByMessageCode(MessageCode code, String... strings) {
		return getMessageById(code.toString(), strings);
	}
	
	public Message getMessageById(String id, String... strings) {

		Message message = null;

		if(strings == null) {
			strings = new String[0];
		}
		
		try {
			message = msgs.get(id).clone();

			String content = message.getContent();
			
			
			if (content.indexOf("{0}") > -1) {
				for (int i = 0; i < strings.length; i++) {
					content = content.replace("{" + Integer.toString(i) + "}",
							strings[i]);
				}
			} else {
				for (String str : strings) {
					content += " - " + str;
				}
			}
			
			Pattern p = Pattern.compile("\\{[0-9]\\}");
			Matcher m = p.matcher(content);
			if(m.find()) {
				content = content.replaceAll("\\{[0-9]\\}", "");
			}

			message.setContent(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
