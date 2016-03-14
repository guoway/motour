package club.motour.exception ;

import club.motour.model.enums.MessageCode;

public class SequenceNumberException extends MotourException {
	private static final long serialVersionUID = 3894670260329714432L;
	
	public SequenceNumberException(String message, MessageCode msgCode) {
		super(message, msgCode);
	}

	


}
