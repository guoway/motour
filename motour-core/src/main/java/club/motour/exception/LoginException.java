package club.motour.exception;

import club.motour.model.enums.MessageCode;

public class LoginException extends MotourException {

	private static final long serialVersionUID = -8153133589588559753L;
	
	private String userId;
	
	public LoginException(String message, MessageCode msgCode, String userId) {
		super(message, msgCode);
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
