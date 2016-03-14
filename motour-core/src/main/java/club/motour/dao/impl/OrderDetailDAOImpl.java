package club.motour.dao.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.OrderDetailDAO;
import club.motour.model.OrderDetail;

@Repository
public class OrderDetailDAOImpl extends SpringHibernateDAO<OrderDetail, BigDecimal> implements OrderDetailDAO {



}
