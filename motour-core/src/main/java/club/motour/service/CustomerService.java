package club.motour.service;

import club.motour.model.ContactUsMessage;

public interface CustomerService {

	
	/**
	 * 儲存連絡我們的資訊
	 * @param cum
	 */
	public void createContactUsMessage(ContactUsMessage cum);
}
