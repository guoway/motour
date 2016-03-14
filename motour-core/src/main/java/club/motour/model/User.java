package club.motour.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;
import com.sylksoft.ss3a.model.Ss3aMember;

@Entity
@Table(name="mt_user")
public class User extends GenericEntity<String> {

	private static final long serialVersionUID = 2158307491015721307L;

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 行動電話
	 */
	private String mobile;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * 識別ID(身份證、護照號碼、居留證號)
	 */
	private String identity;
	
	/**
	 * 發票地址
	 */
	private String invAddress;
	
	/**
	 * 發票抬頭
	 */
	private String invTitle;
	
	/**
	 * 發票統編
	 */
	private String invBid;
	
	/**
	 * 發票郵遞區號
	 */
	private String invZip;
		
	private Ss3aMember ss3aMember;
	
	/**
	 * fbId 
	 */
	private String fbId ;
	/**
	 * 所持有的折扣券
	 */
	private Set<Coupon> ownedCoupons = new TreeSet<>();
	
	@Override
	@Id
	@Column(name="user_id")
	public String getId() {
		return super.getId();
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="identity")
	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column(name="inv_address")
	public String getInvAddress() {
		return invAddress;
	}


	public void setInvAddress(String invAddress) {
		this.invAddress = invAddress;
	}

	@Column(name="inv_title")
	public String getInvTitle() {
		return invTitle;
	}


	public void setInvTitle(String invTitle) {
		this.invTitle = invTitle;
	}

	@Column(name="inv_bid")
	public String getInvBid() {
		return invBid;
	}


	public void setInvBid(String invBid) {
		this.invBid = invBid;
	}

	@Column(name="inv_zip")
	public String getInvZip() {
		return invZip;
	}


	public void setInvZip(String invZip) {
		this.invZip = invZip;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	public Ss3aMember getSs3aMember() {
		return ss3aMember;
	}


	public void setSs3aMember(Ss3aMember ss3aMember) {
		this.ss3aMember = ss3aMember;
	}

	@OneToMany(mappedBy="owner")
	public Set<Coupon> getOwnedCoupons() {
		return ownedCoupons;
	}

	public void setOwnedCoupons(Set<Coupon> ownedCoupons) {
		this.ownedCoupons = ownedCoupons;
	}

	
	@Column(name="fb_id")
	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
