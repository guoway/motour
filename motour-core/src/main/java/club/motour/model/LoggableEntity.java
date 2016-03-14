package club.motour.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.sylksoft.generic.GenericEntity;

/**
 * 具建立時間，建立人，更新時間，更新人等四個欄位者可繼承此。
 * @author Ken Chen
 *
 * @param <ID>
 */
@MappedSuperclass
public abstract class LoggableEntity<ID extends Serializable> extends GenericEntity<ID> {

	private static final long serialVersionUID = 6011527727198869347L;

	protected Date createTime;
	
	protected String creator;
	
	protected Date updateTime;
	
	protected String updator;

	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name="update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name="updator")
	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}
	
	
}
