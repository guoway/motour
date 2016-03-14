package club.motour.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_message")
public class Message extends GenericEntity<String> implements Cloneable {

	private static final long serialVersionUID = 2602232417511726956L;

	/**
	 * 內容
	 */
	public String content;
	
	/**
	 * 類型
	 */
	private BigDecimal type;
	
	
	@Override
	@Id
	@Column(name="msg_id")
	public String getId() {
		return super.getId();
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Column(name="type")
	public BigDecimal getType() {
		return type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}



	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Message clone() throws CloneNotSupportedException {
		return (Message) super.clone();
	}

}
