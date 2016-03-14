package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Service;

import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;

import club.motour.dao.GetMotorLocationDAO;
import club.motour.dao.OperationOfficeDAO;
import club.motour.model.GetMotorLocation;
import club.motour.model.OperationOffice;
import club.motour.service.OperationOfficeService;

@Service
public class OperationOfficeServiceImpl implements OperationOfficeService {

	@Autowired
	OperationOfficeDAO operationOfficeDAO;
	@Autowired
	GetMotorLocationDAO getMotorLocationDAO ;
	
	@Override
	public OperationOffice getOperationOfficeById(BigDecimal officeId, boolean withFetch) {
		if(withFetch){
			List<OperationOffice> list = new ArrayList<>() ;
			DetachedCriteria crit = DetachedCriteria.forClass(OperationOffice.class) ;
			crit.setFetchMode("getMotorLocations", FetchMode.JOIN) ;
			crit.add(Restrictions.eq("id", officeId));
			list = operationOfficeDAO.findByCriteria(crit) ;
			if(list.size()==0){
				return null ;
			}else{
				return list.get(0) ;
			}
		}else{
			return operationOfficeDAO.findById(officeId);
		}
	}

	@Override
	public List<OperationOffice> getShowInIndexOperationOffices() {
		DetachedCriteria crit = DetachedCriteria.forClass(OperationOffice.class);
		crit.add(Restrictions.eq("showInIndex", true));
		crit.addOrder(Order.asc("id"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return operationOfficeDAO.findByCriteria(crit);
	}

	@Override
	public List<Map<String, Object>> getSimpleDataEnabledOperationOffices() {
		SqlParameter<Map<String, Object>> sql = new SqlParameter<>();
		sql.setStatement("select o.name, o.oid from mt_operation_office o where o.enabled=1 order by o.sort_order asc");
		sql.setMapper(new ColumnMapRowMapper());
		return SqlDAOFactory.getInstance().getSqlDAO().queryAsListOfMap(sql);
	}

	@Override
	public List<Map<String, Object>> getPageableOperationOffices() {
		
		SqlParameter<Map<String, Object>> sql = new SqlParameter<>();
		sql.setStatement("select o.oid, o.name, o.address, im.image  from mt_operation_office o "
				+ "left join mt_operation_office_to_image oim on oim.oid = o.oid and oim.use_of = 'mandatory' "
				+ "left join mt_image im on oim.im_id = im.im_id "
				+ "where o.enabled=1 order by o.sort_order asc ");
		sql.setMapper(new ColumnMapRowMapper());
		return SqlDAOFactory.getInstance().getSqlDAO().queryAsListOfMap(sql);
	}

	@Override
	public GetMotorLocation findMotorLocationById(BigDecimal gmId) {
		
		return getMotorLocationDAO.findById(gmId);
	}

	@Override
	public List<OperationOffice> findAll() {
		return operationOfficeDAO.findAll();
	}	
}
