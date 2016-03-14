package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.CouponDAO;
import club.motour.model.Coupon;

@Repository
public class CouponDAOImpl extends SpringHibernateDAO<Coupon, BigDecimal> implements CouponDAO {


}
