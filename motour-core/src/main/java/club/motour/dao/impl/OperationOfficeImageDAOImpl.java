package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.OperationOfficeImageDAO;
import club.motour.model.OperationOfficeImage;

@Repository
public class OperationOfficeImageDAOImpl extends SpringHibernateDAO<OperationOfficeImage, BigDecimal>
		implements OperationOfficeImageDAO {

}
