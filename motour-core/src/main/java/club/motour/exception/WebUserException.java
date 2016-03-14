package club.motour.exception;

import club.motour.model.enums.MessageCode;

public class WebUserException extends MotourException {

	private static final long serialVersionUID = -6748600357369151613L;

	public WebUserException(String message, MessageCode msgCode) {
		super(message, msgCode);
	}

}
