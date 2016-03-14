package club.motour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_cash_flow")
public class CashFlow extends GenericEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2402424148923967048L;
	
	/**
	 * 商店代號  
	 */
	private String web ;

	/**
	 * 交易金額 
	 */
	private BigDecimal MN ;
	/**
	 * 訂單編號
	 */
	private String orderCode ;
	/**
	 * 商家名稱 
	 * 文字 
	 */
	private String webName ;
	/**
	 * 消費者姓名 
	 * 文字 
	 * 因個資法會轉換為隱藏。例：王○明 
	 */
	private String name ;
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
	private String approveCode ;
	/**
	 * 授權卡號後 4 碼 
	 * 數字 
	 * 非信用卡交易則空白。 
	 */
	private int cardNo ;
	/**
	 * 傳送方式 
	 * 數字
	 * 1：背景傳送；2：網頁傳送。商家需可接受 1-2 次 的回傳(非重複交易)。 
	 */
	private int sendType ;
	/**
	 * 回覆代碼 
	 * 英數
	 * 00(數字)表交易成功。其餘交易失敗！ 請搭配交易檢查碼進行交易驗證。 
	 */
	private String errCode ;
	/**
	 * 回覆代碼解釋 
	 * 文字 
	 */
	private String errMsg ;
	/**
	 * 交易類別 
	 * 數字 
	 * 0 信用卡交易、1 銀聯卡交易。 
	 */
	private int cardType ;
	/**
	 * 交易檢查碼 
	 * 英數 
	 * 交易檢查碼組合順序，並使用「SHA-1 雜湊函數」取得組合字串的雜湊值(轉大寫)。 
	 */
	private String chkValue ;
	
	/**
	 * 新增時間
	 */
	private Date creatDatetime ;
	
	@Override
	@Id
	@Column(name="buy_safe_no")
	public String getId() {
		return super.getId();
	}

	@Column(name="web")
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Column(name="mn")
	public BigDecimal getMN() {
		return MN;
	}

	public void setMN(BigDecimal mN) {
		MN = mN;
	}

	@Column(name="order_code")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name="web_name")
	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}


	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="note1")
	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}


	@Column(name="note2")
	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}


	@Column(name="approve_code")
	public String getApproveCode() {
		return approveCode;
	}

	public void setApproveCode(String approveCode) {
		this.approveCode = approveCode;
	}


	@Column(name="card_no")
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}


	@Column(name="send_type")
	public int getSendType() {
		return sendType;
	}

	public void setSendType(int sendType) {
		this.sendType = sendType;
	}


	@Column(name="err_code")
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}


	@Column(name="err_msg")
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	@Column(name="card_type")
	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}


	@Column(name="chk_value")
	public String getChkValue() {
		return chkValue;
	}

	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

	
	@Column(name="create_datetime")
	public Date getCreatDatetime() {
		return creatDatetime;
	}

	public void setCreatDatetime(Date creatDatetime) {
		this.creatDatetime = creatDatetime;
	}

	@Transient
	@Override
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
