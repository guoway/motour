package club.motour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_user_verification_code")
public class UserVerificationCode extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = -7087439503134749340L;

	private User user;
	
	/**
	 * 驗證類型，意指驗證何事，如註冊驗證。REFERENCE MT_CODE_META
	 * parent_cid = 12
	 */
	private CodeMeta vType;
	
	/**
	 * 驗證碼
	 */
	private String code;
	
	/**
	 * 建立時間
	 * default = CURRENT_TIMESTAMP()
	 */
	private Date createTime;
	
	/**
	 * 驗證時間，驗證成功方填入。
	 */
	private Date verifyTime;
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vc_id")
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@ManyToOne
	@JoinColumn(name="v_type")
	public CodeMeta getvType() {
		return vType;
	}
	
	public void setvType(CodeMeta vType) {
		this.vType = vType;
	}


	@Column(name="code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Column(name="verify_time")
	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
