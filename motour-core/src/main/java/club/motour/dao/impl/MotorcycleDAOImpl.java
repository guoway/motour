package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.MotorcycleDAO;
import club.motour.model.Motorcycle;

@Repository
public class MotorcycleDAOImpl extends SpringHibernateDAO<Motorcycle, BigDecimal> implements MotorcycleDAO {


}
