package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.RentPlanDAO;
import club.motour.model.RentPlan;

@Repository
public class RentPlanDAOImpl extends SpringHibernateDAO<RentPlan, BigDecimal> implements RentPlanDAO {

}
