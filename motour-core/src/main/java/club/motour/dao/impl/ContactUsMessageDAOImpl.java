package club.motour.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.ContactUsMessageDAO;
import club.motour.model.ContactUsMessage;

@Repository
public class ContactUsMessageDAOImpl extends SpringHibernateDAO<ContactUsMessage, BigDecimal>
		implements ContactUsMessageDAO {


}
