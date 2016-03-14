package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.OperationOfficeDAO;
import club.motour.model.OperationOffice;

@Repository
public class OperationOfficeDAOImpl extends SpringHibernateDAO<OperationOffice, BigDecimal>
		implements OperationOfficeDAO {


}
