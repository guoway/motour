package club.motour.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.CouponPlanDAO;
import club.motour.model.CouponPlan;

@Repository
public class CouponPlanDAOImpl extends SpringHibernateDAO<CouponPlan, BigDecimal> implements CouponPlanDAO {


}
