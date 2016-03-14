package club.motour.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.MotorcycleTypeImageDAO;
import club.motour.model.MotorcycleTypeImage;

@Repository
public class MotorcycleTypeImageDAOImpl extends SpringHibernateDAO<MotorcycleTypeImage, BigDecimal>
		implements MotorcycleTypeImageDAO {

}
