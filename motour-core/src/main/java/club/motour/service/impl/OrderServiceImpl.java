package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sylksoft.generic.PageResponse;
import com.sylksoft.sql.SqlSpecification;
import com.sylksoft.sql.SqlConditionFactory;
import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;
import com.sylksoft.sql.annotation.NativeQuery;
import com.sylksoft.util.DateUtil;

import club.motour.dao.CashFlowDAO;
import club.motour.dao.OrderDAO;
import club.motour.exception.SequenceNumberException;
import club.motour.mapper.OrderRowMapper;
import club.motour.model.CashFlow;
import club.motour.model.Order;
import club.motour.model.User;
import club.motour.model.enums.OrderStatus;
import club.motour.search.obj.OrderNativeSearch;
import club.motour.service.OrderService;
import club.motour.util.SequenceNumber;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	@Autowired
	CashFlowDAO cashFlowDAO ;
	
	@Override
	@Transactional
	public Order createOrder(Order order) {
		return orderDAO.makePersistent(order);
	}

	@Override
	public String createSequenceNumber() throws SequenceNumberException {
		
		return SequenceNumber.getInstance().getSequenceNumber_date("mt_order_master", "order_code", null, 4) ;
	}

	@Override
	@Transactional
	public CashFlow createCashFlow(CashFlow cashFlow) {
		cashFlow.setCreatDatetime(new Date());
		return cashFlowDAO.makePersistent(cashFlow);
	}

	@Override
	@Transactional
	public void updateOrderBuySafeNo(String buySafeNo, String orderCode, OrderStatus status) {
		orderDAO.updateOrderBuySafeNo(buySafeNo, orderCode, status) ;
	}

	@Override
	public List<Order> findOrdersByUserId(User user, List<OrderStatus> statusList) {
		DetachedCriteria crit = DetachedCriteria.forClass(Order.class);
		crit.setFetchMode("details", FetchMode.JOIN);
		crit.add(Restrictions.eq("user", user)) ;
		crit.add(Restrictions.in("status", statusList));
		//crit.add(Restrictions.eq("status", status)) ;
		crit.addOrder(org.hibernate.criterion.Order.desc("id")) ;
		return orderDAO.findByCriteria(crit);
	}

	@Override
	public void cancelOrderById(BigDecimal id, User user) {
		
		 orderDAO.cancelOrderById(id, user) ;
	}

	@Override
	public Order findOrderByOrderCode(String orderCode, String user) {
		List<Order> orders = new ArrayList<>() ;
		DetachedCriteria crit = DetachedCriteria.forClass(Order.class) ;
		crit.setFetchMode("details", FetchMode.JOIN);
		crit.add(Restrictions.eq("orderCode", orderCode)) ;
		crit.add(Restrictions.eq("creator", user));
		orders = orderDAO.findByCriteria(crit) ;
		if(orders.size()==0){
			return null ;
		}
		return orders.get(0);
	}

	@Override
	public PageResponse getOrderListSearch(OrderNativeSearch orderSearch) {
		SqlParameter<OrderNativeSearch> sql = new SqlParameter<>();
		SqlConditionFactory<OrderNativeSearch> f = new SqlConditionFactory<>(OrderNativeSearch.class) ;
		NativeQuery nq = f.getClassType().getAnnotation(NativeQuery.class)  ;
		String statement = nq.query() ;
		SqlSpecification spec = SqlSpecification.where(f.like("renter",orderSearch.getRenter()))
												 	.and(f.equals("orderCode", orderSearch.getOrderCode()))
												 	.and(f.equals("mobile", orderSearch.getMobile()))
												 	.and(f.equals("identity", orderSearch.getIdentity()))
													.and(f.betweenDate("orderDate"
																		,null!=orderSearch.getOrderDate()?DateUtil.getStartOfDay(orderSearch.getOrderDate()):null 
																		,null!=orderSearch.getOrderDate()?DateUtil.getEndOfDay(orderSearch.getOrderDate()):null))
													.and(f.betweenDate("rentDate"
																		,null!=orderSearch.getRentDate()?DateUtil.getStartOfDay(orderSearch.getRentDate()):null
																		,null!=orderSearch.getRentDate()?DateUtil.getEndOfDay(orderSearch.getRentDate()):null));
		StringBuffer sb = orderSearch.composeNativeSql(statement, spec) ;
		
		if(StringUtils.isNotBlank(orderSearch.getPageRequest().getSidx())){
			sb.append(" ORDER BY " + f.getColumnName(orderSearch.getPageRequest().getSidx())) ;
			sb.append(" "+orderSearch.getPageRequest().getSord()) ;
		}else{
			sb.append(nq.orderBy()) ;
		}
		
		sql.setStatement(sb.toString());
		sql.setMapper(new OrderRowMapper());
		return SqlDAOFactory.getInstance().getSqlDAO().queryAsPageResponse(sql, orderSearch.getPageRequest());
		
		//DetachedCriteria crit = DetachedCriteria.forClass(Order.class) ;
		//PageResponse res = orderDAO.findByCriteria(orderSearch.composeDetachedCriteria(crit) ,orderSearch.getPageRequest()) ;
		//return orderDAO.findByCriteria(orderSearch.composeDetachedCriteria(crit) ,orderSearch.getPageRequest());

	}
	
}
