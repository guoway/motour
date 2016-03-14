package club.motour.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import club.motour.search.obj.OrderNativeSearch;

public class OrderRowMapper implements RowMapper<OrderNativeSearch> {

	@Override
	public OrderNativeSearch mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderNativeSearch o = new OrderNativeSearch() ;
		o.setOrderCode(rs.getString(1));
		o.setOrderDate(rs.getTimestamp(2));
		o.setRentDate(rs.getTimestamp(3));
		o.setRenter(rs.getString(4));
		o.setMobile(rs.getString(5));
		o.setIdentity(rs.getString(6));
		return o;
	}



}
