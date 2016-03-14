package club.motour.model.enums;

import org.apache.commons.lang.StringUtils;

public enum OrderStatus {
	BEGIN("訂單確認中"),
	CANCEL("退訂"),
	CLOSE("訂單完成"),
	FAIL("訂單失敗");
	
	private final String name ;
	
	private OrderStatus(String name){
		this.name = name ;
	}

	public static OrderStatus getOrderStatusByName(String name){
		for(OrderStatus status : OrderStatus.values()){
			if(StringUtils.equals(status.name, name)){
				return status ;
			}
		}
		return null ;
	}

	public String getName() {
		return name;
	}
}
