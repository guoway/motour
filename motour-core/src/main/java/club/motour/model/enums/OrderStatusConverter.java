package club.motour.model.enums;

import javax.persistence.AttributeConverter;

public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

	@Override
	public String convertToDatabaseColumn(OrderStatus status) {
		return status.getName();
	}

	@Override
	public OrderStatus convertToEntityAttribute(String dbData) {
		
		return OrderStatus.getOrderStatusByName(dbData);
	}

}
