package club.motour.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sylksoft.generic.PageResponse;

import club.motour.dao.OrderDAO;
import club.motour.model.Order;
import club.motour.search.obj.DispatchMotorSearch;
import club.motour.service.DispatchMotorService;

@Service
public class DispatchMotorServiceImpl implements DispatchMotorService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public PageResponse searchForDispatch(DispatchMotorSearch search) {

		DetachedCriteria crit = DetachedCriteria.forClass(Order.class);
		crit = search.composeDetachedCriteria(crit);
		PageResponse response = orderDAO.findByCriteria(crit, search.getPageRequest());
		
		return response;
	}

}
