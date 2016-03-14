package club.motour.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.stereotype.Service;

import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;

import club.motour.model.RentPlan;
import club.motour.model.enums.BasicPlanType;
import club.motour.service.RentPlanService;

@Service
public class RentPlanServiceImpl implements RentPlanService {

	@Override
	public RentPlan findRentPlanByMtIdAndBasicPlanType(BigDecimal mtId, String basicPlanType) {
		SqlParameter<Map<String, Object>> sql = new SqlParameter<>();
		sql.setStatement("select rp_id, rp_name,price, basic_plan_type from mt_rent_plan where rp_id in (select mp.rp_id from mt_motorcycle_type_to_rent_plan mp where mp.mt_id=?) and basic_plan_type=?");
		sql.setArguments(new Object[]{mtId,basicPlanType});
		sql.setMapper(new ColumnMapRowMapper());
		List<Map<String, Object>> list =SqlDAOFactory.getInstance().getSqlDAO().queryAsListOfMap(sql);
		RentPlan rp = null ;
		if(list.size()>0){
			rp = new RentPlan();
			rp.setId(new BigDecimal(list.get(0).get("rp_id").toString()));
			rp.setName(list.get(0).get("rp_name").toString());
			rp.setPrice(new BigDecimal(list.get(0).get("price").toString()));
			rp.setBasicPlanType(BasicPlanType.getBasicPlanTypeByType(list.get(0).get("basic_plan_type").toString().charAt(0)));
		}
		
		return rp ;
	}

}
