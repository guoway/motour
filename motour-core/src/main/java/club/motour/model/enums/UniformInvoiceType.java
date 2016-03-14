package club.motour.model.enums;

public enum UniformInvoiceType {
	DUPLICATE("二聯"),
	TRIPLICATE("三聯");
	
	private final String name;
	
	private UniformInvoiceType(String name) {
		this.name = name;
	}
	
	public static UniformInvoiceType getUniformInvoiceTypeByName(String name) {
		for(UniformInvoiceType uType: UniformInvoiceType.values()) {
			if(uType.name.equals(name)) {
				return uType;
			}
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
}
