package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.MotorcycleTypeDAO;
import club.motour.model.MotorcycleType;

@Repository
public class MotorcycleTypeDAOImpl extends SpringHibernateDAO<MotorcycleType, BigDecimal> implements MotorcycleTypeDAO {


}
