package club.motour.exception;

import club.motour.model.enums.MessageCode;

public class VerificationCodeException extends MotourException {

	private static final long serialVersionUID = 5503380170719590356L;

	
	public VerificationCodeException(String message, MessageCode code) {
		super(message, code);
	}

}
