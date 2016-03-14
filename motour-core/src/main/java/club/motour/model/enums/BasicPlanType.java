package club.motour.model.enums;

public enum BasicPlanType {

	FULL_DAY('F'),HALF_DAY('H');
	
	private final char type;
	
	private BasicPlanType(char type) {
		this.type = type;
	}
	
	public static BasicPlanType getBasicPlanTypeByType(char type) {
		for(BasicPlanType r: BasicPlanType.values()) {
			if(r.type == type) {
				return r;
			}
		}
		return null;
	}
	
	public char getType() {
		return type;
	}
}
