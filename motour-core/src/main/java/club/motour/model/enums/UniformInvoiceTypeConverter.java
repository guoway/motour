package club.motour.model.enums;

import javax.persistence.AttributeConverter;

public class UniformInvoiceTypeConverter implements AttributeConverter<UniformInvoiceType, String> {

	@Override
	public String convertToDatabaseColumn(UniformInvoiceType uType) {
		return uType.getName();
	}

	@Override
	public UniformInvoiceType convertToEntityAttribute(String dbData) {
		
		return UniformInvoiceType.getUniformInvoiceTypeByName(dbData) ;
	}

}
