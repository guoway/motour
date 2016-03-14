package club.motour.converter;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import club.motour.model.OperationOffice;

public class OperationOfficeConverter implements Converter<String, OperationOffice> {

	@Override
	public OperationOffice convert(String source) {
		if(StringUtils.isNotEmpty(source)) {
			OperationOffice o = new OperationOffice();
			try {
				o.setId(new BigDecimal(source));
				return o;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
