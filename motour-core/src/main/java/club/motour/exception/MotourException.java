package club.motour.exception;

import club.motour.model.enums.MessageCode;

public class MotourException extends Exception {

	private static final long serialVersionUID = 6474576189836116758L;

	protected MessageCode msgCode;

	public MotourException(String message, MessageCode msgCode) {
		super(message);
		this.msgCode = msgCode;
	}
	
	
	public MessageCode getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(MessageCode msgCode) {
		this.msgCode = msgCode;
	}
}
