package com.sylksoft.ss3a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringValueResolver;

import com.sylksoft.support.message.MailSender;

import club.motour.test.TestTemplate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class SsMailSenderTest extends TestTemplate {

	@Autowired
	@Qualifier("ssMailSender")
	MailSender mailSender;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	//@Test
	public void testSendSimpleMail() {
		SimpleMailMessage sm = mailSender.getSimpleMailTemplate();
		sm.setFrom("notify@motour.club");
		sm.setTo("guoway0716@gmail.com");
		sm.setSubject("測試motour郵件收發");
		sm.setText("wow，這是motour的郵件收發測試啦");
		mailSender.sendSimpleMail(sm);
	}
	
	@Test
	public void testSendMimeMail() {
		MimeMessageHelper h = mailSender.getMimeMessageHelper();
		MimeMessage m = h.getMimeMessage();
		try {
			h.setFrom("notify@motour.club");
			h.setTo("guoway0716@gmail.com");
			h.setSubject("測試motour郵件收發");
			
			File f = ResourceUtils.getFile("classpath:conf/mail_template/email.html");	
			String content = FileUtils.readFileToString(f, "utf-8");
			content = content.replace("${0}", "測試用途");
			content = content.replace("${1}", "<p>測試用途<b>測試用途</b><a href='http://tw.yahoo.com'>測試用途</a>測試用途測試用途測試用途測試用途測試用途測試用途測試用途</p>");
			h.setText(content, true);
			mailSender.sendMimeMail(h.getMimeMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
