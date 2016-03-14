package club.motour.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.MessageDAO;
import club.motour.model.Message;

@Repository
public class MessageDAOImpl extends SpringHibernateDAO<Message, String> implements MessageDAO {

	@Override
	public String generateMsgId() {
		String hql = "select coalesce(max(m.id), 0) from Message m";
		List<?> resultList = (List<?>)getTemplate().find(hql);
		int max = Integer.parseInt((String)resultList.get(0));
		String latestId = StringUtils.leftPad(String.valueOf(max+1), 4, "0");
		return latestId;
	}


}
