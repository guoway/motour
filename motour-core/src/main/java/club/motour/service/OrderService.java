package club.motour.service;

import java.math.BigDecimal;
import java.util.List;

import com.sylksoft.generic.PageResponse;

import club.motour.exception.SequenceNumberException;
import club.motour.model.CashFlow;
import club.motour.model.Order;
import club.motour.model.User;
import club.motour.model.enums.OrderStatus;
import club.motour.search.obj.OrderNativeSearch;

public interface OrderService {

	/**
	 * 新增訂單
	 * @param order
	 * @return order
	 */
	public Order createOrder(Order order) ;
	/**
	 * 產生訂單號碼
	 * @return String
	 * @throws SequenceNumberException
	 */
	public String createSequenceNumber() throws SequenceNumberException ;
	/**
	 * 新增紅陽回傳的資訊
	 * @return
	 */
	public CashFlow createCashFlow(CashFlow cashFlow) ;
	
	/**
	 * 回寫紅陽訂單
	 * @param buySafeNo
	 */
	public void updateOrderBuySafeNo(String buySafeNo, String orderCode, OrderStatus status) ;
	
	/**
	 * 取出User的有效訂單
	 * @param user, orderStatus
	 * @return List<Order>
	 */
	public List<Order> findOrdersByUserId(User user, List<OrderStatus> statusList);
	/**
	 * 退訂，取消訂單更改orderStatus 狀態為 cancel(取消訂單)
	 * @param id
	 * @param user
	 */
	public void cancelOrderById(BigDecimal id , User user );
	
	/**
	 * 取出User的訂單詳細資料by orderCode For列印
	 * @param orderCode
	 * @param user
	 * @return
	 */
	public Order findOrderByOrderCode(String orderCode, String user) ;
	
	/**
	 * 依條件取出訂單列表
	 * @param orderSearch
	 * @return
	 */
	public PageResponse getOrderListSearch(OrderNativeSearch orderSearch) ;
}
