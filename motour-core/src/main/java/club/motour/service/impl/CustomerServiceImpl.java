package club.motour.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.motour.dao.ContactUsMessageDAO;
import club.motour.model.ContactUsMessage;
import club.motour.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ContactUsMessageDAO contactUsMessageDAO;

	@Override
	@Transactional
	public void createContactUsMessage(ContactUsMessage cum) {
		if(cum.getCreateTime() == null) {
			cum.setCreateTime(new Date());
		}
		contactUsMessageDAO.makePersistent(cum);
	}
}
