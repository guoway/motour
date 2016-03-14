package club.motour.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.sylksoft.support.message.MailSender;

import club.motour.model.EmailWrapper;
import club.motour.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	Logger log = Logger.getLogger(getClass());

	@Autowired
	@Qualifier("ssMailSender")
	MailSender mailSender;
	
	public void sendMail(EmailWrapper email) {
		MimeMessageHelper h = mailSender.getMimeMessageHelper();
		try {
			
			h.setFrom(StringUtils.isEmpty(email.getFrom()) ? "Motour Club 系統通知 <notify@motour.club>" : email.getFrom());
			if(StringUtils.isEmpty(email.getTo())) {
				throw new NullPointerException("EmailWrapper.to cannot be null");
			}
			h.setTo(email.getTo());
			
			for(String cc : email.getCcList()) {
				h.addCc(cc);
			}
			
			h.setSubject(email.getSubject());
			
			File f = ResourceUtils.getFile("classpath:conf/mail_template/email.html");	
			String content = FileUtils.readFileToString(f, "utf-8");
			
			for(int i=0; i<email.getVars().size(); i++) {
				content = content.replace("${" + i + "}", email.getVars().get(i));
			}
			
			h.setText(content, true);
			new Thread() {
				@Override
				public void run() {
					log.info("MailService Mail Sending Thread start a new one, id:" + getId());
					mailSender.sendMimeMail(h.getMimeMessage());
					log.info("MailService Mail Sending Thread(" + getId() + ") is end");
				}
			}.run();
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
