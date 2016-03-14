package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.GetMotorLocationDAO;
import club.motour.model.GetMotorLocation;

@Repository
public class GetMotorLocationDAOImpl extends SpringHibernateDAO<GetMotorLocation, BigDecimal>
		implements GetMotorLocationDAO {


}
