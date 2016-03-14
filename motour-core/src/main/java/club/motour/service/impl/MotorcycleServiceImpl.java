package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Service;

import com.sylksoft.sql.GenericRowMapper;
import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;

import club.motour.dao.MotorcycleDAO;
import club.motour.dao.MotorcycleTypeDAO;
import club.motour.model.MotorcycleType;
import club.motour.service.MotorcycleService;
import club.motour.ui.model.MotorTypeListOfOffice;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

	@Autowired
	MotorcycleDAO motorcycleDAO;
	@Autowired
	MotorcycleTypeDAO motorcycleTypeDAO ;
		
	@Value("${code.motor.available}")
	BigDecimal MOTOR_STATUS_AVAILABLE;

	@Override
	public List<MotorTypeListOfOffice> getMotorTypeListOfOffice(BigDecimal officeId) {

		SqlParameter<MotorTypeListOfOffice> sp = new SqlParameter<>();
		sp.setStatement(
				"select sm.* from "
					+ "(select distinct mt.*, "
					+ "(select count(*) from mt_motorcycle m2 where m2.mt_id=mt.mt_id and m2.status = ?) as numberOfMotor, "
					+ "(select group_concat(r.rp_name SEPARATOR '/') as namsses from mt_rent_plan r left join (select * from mt_motorcycle_type_to_rent_plan order by rp_id) as mr on r.rp_id = mr.rp_id  left join mt_motorcycle_type mt2 on mt2.mt_id=mr.mt_id where mt2.mt_id=mt.mt_id group by mt2.mt_id) as rentFee, "
					+ "g.image "
					+ "from mt_motorcycle_type mt "
					+ "left join mt_code_meta c on mt.brand = c.cid "
					+ "left join mt_motorcycle m on m.mt_id = mt.mt_id "
					+ "left join mt_motorcycle_type_to_image mim on mim.mt_id=mt.mt_id and mim.use_of='mandatory' "
					+ "left join mt_image g on g.im_id=mim.im_id "
					+ "where m.operation_office_id = ?) as sm "
				+ "where sm.numberOfMotor > 0 ");

		sp.setArguments(MOTOR_STATUS_AVAILABLE, officeId);
		sp.setMapper(new GenericRowMapper<>(MotorTypeListOfOffice.class));
		
		List<MotorTypeListOfOffice> list = SqlDAOFactory.getInstance().getSqlDAO().queryAsList(sp);
		
		return list;
	}

	@Override
	public MotorcycleType getMotorTypeById(BigDecimal mtId) {		
		return motorcycleTypeDAO.findById(mtId);
	}

	@Override
	public List<Map<String, Object>> getAvailableMotors(Date orderTime, BigDecimal officeId,
			Integer rentDay) {

		Date predictReturnDate = DateUtils.addDays(orderTime, rentDay);
		
		SqlParameter<Map<String, Object>> sp = new SqlParameter<>();
		sp.setStatement("select a.mt_id as mtId, a.name, a.cnt - ifnull(b.cnt, 0) as count from ("
				+ "select m.mt_id, mt.name, count(m.mt_id) as cnt "
				+ "from mt_motorcycle m "
				+ "left join mt_motorcycle_type mt on m.mt_id = mt.mt_id "
				+ "where 1=1 "
				+ "and m.status=7 "
				+ "and m.operation_office_id = ? "
				+ "group by m.mt_id) a "
				+ "left join ( "
				+ "select mt_id, sum(quantity) as cnt "
				+ "from mt_order_detail od "
				+ "left join mt_order_master om on om.order_id = od.order_id "
				+ "left join mt_get_motor_location gm on om.get_gm_id = gm.gm_id "
				+ "left join mt_operation_office oo on oo.oid = gm.oid "
				+ "where 1=1 "
				+ "and ((? between om.rent_time and om.predict_return_time) or (? between om.rent_time and om.predict_return_time)) "
				+ "and oo.oid = ? "
				+ "group by oo.oid, od.mt_id) b "
				+ "on a.mt_id = b.mt_id");
		
		sp.setArguments(officeId, orderTime, predictReturnDate, officeId);
		sp.setMapper(new ColumnMapRowMapper());
		
		List<Map<String, Object>> list = SqlDAOFactory.getInstance().getSqlDAO().queryAsList(sp);
		return list;
	}
}
