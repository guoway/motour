package club.motour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_contact_us")
public class ContactUsMessage extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 3704139200520596952L;

	private String name;
	
	private String email;
	
	private String subject;
	
	private String content;
	
	private Date createTime;
	
	
	@Override
	@Id
	@Column(name="cu_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public BigDecimal getId() {
		return super.getId();
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
