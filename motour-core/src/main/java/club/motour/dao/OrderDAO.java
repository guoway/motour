package club.motour.dao;

import java.math.BigDecimal;

import com.sylksoft.generic.GenericDAO;

import club.motour.model.Order;
import club.motour.model.User;
import club.motour.model.enums.OrderStatus;

public interface OrderDAO extends GenericDAO<Order, BigDecimal> {

	public int updateOrderBuySafeNo(String buySafeNo,String orderCode, OrderStatus status) ;
	public int cancelOrderById(BigDecimal orderId, User user) ;
}
