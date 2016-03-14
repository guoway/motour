package club.motour.esafe.model;

/**
 * 金流回傳參數
 *
 */
public class CashFlowResponse {

	/**
	 * 紅陽訂單編號 
	 * 英數 
	 */
	private String buysafeno ;
	/**
	 * 商店代號 
	 * 英數 
	 */
	private String web ;

	/**
	 * 交易金額 
	 * 數字 
	 */
	private int MN ;
	/**
	 * 商家訂單編號
	 * 英數  
	 */
	private String Td ;
	/**
	 * 商家網站名稱 
	 * 文字 
	 */
	private String webname ;
	/**
	 * 消費者姓名 
	 * 文字 
	 * 因個資法會轉換為隱藏。例：王○明 
	 */
	private String Name ;
	/**
	 * 備註 1 
	 * 文字 
	 */
	private String note1 ;
	/**
	 * 備註 2 
	 * 文字 
	 */
	private String note2 ;
	/**
	 * 交易授權碼 
	 * 英數
	 * 非信用卡交易則空白。 
	 */
	private String ApproveCode ;
	/**
	 * 授權卡號後 4 碼 
	 * 數字 
	 * 非信用卡交易則空白。 
	 */
	private int Card_NO ;
	/**
	 * 傳送方式 
	 * 數字
	 * 1：背景傳送；2：網頁傳送。商家需可接受 1-2 次 的回傳(非重複交易)。 
	 */
	private int SendType ;
	/**
	 * 回覆代碼 
	 * 英數
	 * 00(數字)表交易成功。其餘交易失敗！ 請搭配交易檢查碼進行交易驗證。 
	 */
	private String errcode ;
	/**
	 * 回覆代碼解釋 
	 * 文字 
	 */
	private String errmsg ;
	/**
	 * 交易類別 
	 * 數字 
	 * 0 信用卡交易、1 銀聯卡交易。 
	 */
	private int Card_Type ;
	/**
	 * 交易檢查碼 
	 * 英數 
	 * 交易檢查碼組合順序，並使用「SHA-1 雜湊函數」取得組合字串的雜湊值(轉大寫)。 
	 */
	private String ChkValue ;
	
	private String UserNo ;
	private String BarcodeA;
	private String BarcodeB;
	private String BarcodeC ;
	private String PostBarcodeA ;
	private String PostBarcodeB ;
	private String PostBarcodeC ;
	private String EntityATM ;
	private String paycode ;
	private String PayType ;
	private String CargoNo ;
	
	
	public String getBuysafeno() {
		return buysafeno;
	}
	public void setBuysafeno(String buysafeno) {
		this.buysafeno = buysafeno;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getTd() {
		return Td;
	}
	public void setTd(String td) {
		Td = td;
	}
	public int getMN() {
		return MN;
	}
	public void setMN(int mN) {
		MN = mN;
	}
	public String getWebname() {
		return webname;
	}
	public void setWebname(String webname) {
		this.webname = webname;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getApproveCode() {
		return ApproveCode;
	}
	public void setApproveCode(String approveCode) {
		ApproveCode = approveCode;
	}
	public int getCard_NO() {
		return Card_NO;
	}
	public void setCard_NO(int card_NO) {
		Card_NO = card_NO;
	}
	public int getSendType() {
		return SendType;
	}
	public void setSendType(int sendType) {
		SendType = sendType;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getCard_Type() {
		return Card_Type;
	}
	public void setCard_Type(int card_Type) {
		Card_Type = card_Type;
	}
	public String getChkValue() {
		return ChkValue;
	}
	public void setChkValue(String chkValue) {
		ChkValue = chkValue;
	}
	public String getUserNo() {
		return UserNo;
	}
	public void setUserNo(String userNo) {
		UserNo = userNo;
	}
	public String getBarcodeA() {
		return BarcodeA;
	}
	public void setBarcodeA(String barcodeA) {
		BarcodeA = barcodeA;
	}
	public String getBarcodeB() {
		return BarcodeB;
	}
	public void setBarcodeB(String barcodeB) {
		BarcodeB = barcodeB;
	}
	public String getBarcodeC() {
		return BarcodeC;
	}
	public void setBarcodeC(String barcodeC) {
		BarcodeC = barcodeC;
	}
	public String getPostBarcodeA() {
		return PostBarcodeA;
	}
	public void setPostBarcodeA(String postBarcodeA) {
		PostBarcodeA = postBarcodeA;
	}
	public String getPostBarcodeB() {
		return PostBarcodeB;
	}
	public void setPostBarcodeB(String postBarcodeB) {
		PostBarcodeB = postBarcodeB;
	}
	public String getPostBarcodeC() {
		return PostBarcodeC;
	}
	public void setPostBarcodeC(String postBarcodeC) {
		PostBarcodeC = postBarcodeC;
	}
	public String getEntityATM() {
		return EntityATM;
	}
	public void setEntityATM(String entityATM) {
		EntityATM = entityATM;
	}
	public String getPaycode() {
		return paycode;
	}
	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public String getCargoNo() {
		return CargoNo;
	}
	public void setCargoNo(String cargoNo) {
		CargoNo = cargoNo;
	}
	
	
}
