package club.motour.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.OrderDAO;
import club.motour.model.Order;
import club.motour.model.User;
import club.motour.model.enums.OrderStatus;

@Repository
public class OrderDAOImpl extends SpringHibernateDAO<Order, BigDecimal> implements OrderDAO {

	@Override
	public int updateOrderBuySafeNo(String buySafeNo,String orderCode, OrderStatus status) {
		StringBuffer sb = new StringBuffer("update from Order set buySafeNo=?,status=? where orderCode=? ");
		return getTemplate().bulkUpdate(sb.toString(), buySafeNo, status ,orderCode);
	}

	@Override
	public int cancelOrderById(BigDecimal orderId, User user) {
		StringBuffer sb = new StringBuffer("update from Order set status=?, updator=?, updateTime=? where id=?") ;
		int a = getTemplate().bulkUpdate(sb.toString(), OrderStatus.CANCEL, user.getName() , new Date(), orderId) ;
		return a ;
	}

}
