package club.motour.dao.tool;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import club.motour.model.LoggableEntity;

/**
 * 尚未啟用
 * @author Ken Chen
 *
 */
public class LoggableEntityListener extends DefaultSaveOrUpdateEventListener {

	private static final long serialVersionUID = 5956732139220625317L;
	
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) {
		if(event.getObject() instanceof LoggableEntity<?>) {
			LoggableEntity<?> e = (LoggableEntity<?>)event.getObject();
			if(e.getCreateTime() == null) {
				e.setCreateTime(new Date());
			}
			if(StringUtils.isEmpty(e.getCreator())) {
				e.setCreator("system");
			}
		}
		super.onSaveOrUpdate(event);
	}
}
