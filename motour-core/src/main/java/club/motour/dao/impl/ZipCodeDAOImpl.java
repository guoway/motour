package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.ZipCodeDAO;
import club.motour.model.ZipCode;

@Repository
public class ZipCodeDAOImpl extends SpringHibernateDAO<ZipCode, BigDecimal> implements ZipCodeDAO {


}
