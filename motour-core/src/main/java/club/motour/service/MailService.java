package club.motour.service;

import club.motour.model.EmailWrapper;

public interface MailService {

	public void sendMail(EmailWrapper email);
}
