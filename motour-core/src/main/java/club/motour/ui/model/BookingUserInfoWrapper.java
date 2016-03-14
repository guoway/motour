package club.motour.ui.model;

import club.motour.model.enums.UniformInvoiceType;

public class BookingUserInfoWrapper {

	/**
	 * 租用人
	 */
	private String renterName;
	/**
	 * 識別id
	 */
	private String identity ;
	/**
	 * 聯絡人手機
	 */
	private String contactMobile ;
	
	/**
	 * 聯絡人 Email
	 */
	private String contactEmail ;
	
	/**
	 * 統編
	 */
	private String invBid ;
	/**
	 * 抬頭
	 */
	private String invTitle;
	/**
	 * 郵遞區號
	 */
	private String invZip ;
	/**
	 * 地址
	 */
	private String invAddress ; 
	/**
	 * 發票收件人
	 */
	private String invReceiver ;
	
	/**
	 * 發票類型
	 */
	private UniformInvoiceType invType ;
	
	public String getRenterName() {
		return renterName;
	}
	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getInvBid() {
		return invBid;
	}
	public void setInvBid(String invBid) {
		this.invBid = invBid;
	}
	public String getInvTitle() {
		return invTitle;
	}
	public void setInvTitle(String invTitle) {
		this.invTitle = invTitle;
	}
	public String getInvZip() {
		return invZip;
	}
	public void setInvZip(String invZip) {
		this.invZip = invZip;
	}
	public String getInvAddress() {
		return invAddress;
	}
	public void setInvAddress(String invAddress) {
		this.invAddress = invAddress;
	}
	public String getInvReceiver() {
		return invReceiver;
	}
	public void setInvReceiver(String invReceiver) {
		this.invReceiver = invReceiver;
	}
	public UniformInvoiceType getInvType() {
		return invType;
	}
	public void setInvType(UniformInvoiceType invType) {
		this.invType = invType;
	}
	
	
}
