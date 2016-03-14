package club.motour.model.enums;

import javax.persistence.AttributeConverter;

public class BasicPlanTypeConverter implements AttributeConverter<BasicPlanType, Character> {

	@Override
	public Character convertToDatabaseColumn(BasicPlanType type) {		
		return type.getType();
	}

	@Override
	public BasicPlanType convertToEntityAttribute(Character dbData) {
		return BasicPlanType.getBasicPlanTypeByType(dbData);
	}

}
