package club.motour.esafe.model;

import java.math.BigDecimal;

/**
 * 金流傳送參數
 * @author RyanChung
 *
 */
public class CashFlowRequest {

	/**
	 * 商店代號(*)
	 * 英數 
	 */
	private String web ;
	/**
	 * 交易金額 (*)
	 * 長度 (8)
	 * 不可有小數點和千位符號。(新台幣) 
	 */
	private int MN ;
	/**
	 * 交易內容(*) 
	 * 文字  (400)
	 * 不可有特殊字元。包含：*'<>[]” 
	 */
	private String OrderInfo ;
	/**
	 * 商家訂單編號 
	 * 英數 (20)
	 * 商家訂單編號：紅陽交易系統僅阻擋同 Td 在同瀏覽器上的未完成交易。 
	 */
	private String Td ;
	/**
	 * 消費者姓名 
	 * 文字 (30) 
	 * 不可有特殊字元。包含：*'<>[]” 
	 */
	private String sna ;
	/**
	 * 消費者電話 
	 * 數字 (20) 
	 * 空白 or 純數字。 
	 */
	private BigDecimal sdt ;
	/**
	 * 消費者 Email 
	 * 英數 (100)
	 * 空白 or 符合 Email 格式內容。  交易成功時會發送成功訊息給消費者。 
	 */
	private String email ;
	/**
	 * 備註 1 
	 * 文字(400)
	 * 不可有特殊字元。包含：*'<>[]” 
	 */
	private String note1 ;
	/**
	 * 備註 2 
	 * 文字 (400)
	 * 不可有特殊字元。包含：*'<>[]” 
	 */
	private String note2 ;
	/**
	 * 交易類別 
	 * 數字 (1) 
	 * 空白 or 0 信用卡交易、1 銀聯卡交易。 
	 */
	private int Card_Type ;
	/**
	 * 語言類別 
	 * 英  
	 * 空白 or EN(英文)、JIS(日文)。 
	 */
	private String Country_Type ;
	/**
	 * 分期期數 
	 * 數字
	 * 空白 or 3、6、12、24 (Card_Type 必須為 0) (非聯信收單不可帶值) 
	 */
	private int Term ;
	/**
	 * 交易檢查碼(*) 
	 * 英數  
	 * 交易檢查碼組合順序，並使用「SHA-1 雜湊函數」取得組合字串的雜湊值(轉大寫)。 
	 */
	private String ChkValue ;
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getMN() {
		return MN;
	}
	public void setMN(int mN) {
		MN = mN;
	}
	public String getOrderInfo() {
		return OrderInfo;
	}
	public void setOrderInfo(String orderInfo) {
		OrderInfo = orderInfo;
	}
	public String getTd() {
		return Td;
	}
	public void setTd(String td) {
		Td = td;
	}
	public String getSna() {
		return sna;
	}
	public void setSna(String sna) {
		this.sna = sna;
	}
	public BigDecimal getSdt() {
		return sdt;
	}
	public void setSdt(BigDecimal sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote1() {
		return note1;
	}
	public void setNote1(String note1) {
		this.note1 = note1;
	}
	public String getNote2() {
		return note2;
	}
	public void setNote2(String note2) {
		this.note2 = note2;
	}
	public int getCard_Type() {
		return Card_Type;
	}
	public void setCard_Type(int card_Type) {
		Card_Type = card_Type;
	}
	public String getCountry_Type() {
		return Country_Type;
	}
	public void setCountry_Type(String country_Type) {
		Country_Type = country_Type;
	}
	public int getTerm() {
		return Term;
	}
	public void setTerm(int term) {
		Term = term;
	}
	public String getChkValue() {
		return ChkValue;
	}
	public void setChkValue(String chkValue) {
		ChkValue = chkValue;
	}
	
	
}
