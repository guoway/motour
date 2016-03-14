package com.sylksoft.ss3a;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sylksoft.ss3a.model.AccessLog;
import com.sylksoft.ss3a.model.Application;
import com.sylksoft.ss3a.model.Function;
import com.sylksoft.ss3a.model.Ss3aMember;
import com.sylksoft.ss3a.service.Ss3aAccessLogService;

import club.motour.test.TestTemplate;


public class Ss3aAccessLogTest extends TestTemplate {

	//@Autowired
	//@Qualifier("ss3aAccessLogDAO")
	//AccessLogDAO accessLogDAO;
	
	@Autowired
	@Qualifier("ss3aAccessLogService")
	Ss3aAccessLogService accessLogService;

	public Ss3aAccessLogTest() {
		BasicConfigurator.configure();
		LogManager.getRootLogger().setLevel(Level.INFO);
	}
	
	@Test
	public void insertAccessLog() {
		Application ap = new Application();
		ap.setId("tc-adm");
		
		Function fn = new Function();
		fn.setId("test");
		AccessLog log = new AccessLog();
		
		Ss3aMember m = new Ss3aMember();
		m.setId("ken");
		
		log.setApplication(ap);
		log.setFunction(fn);
		log.setMember(m);
		//accessLogDAO.makePersistent(log);
		accessLogService.createAccessLog(log);
	}
	
}
