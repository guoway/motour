package club.motour.converter;

import java.util.Date;

import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.sylksoft.util.DateFormatPattern;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if(StringUtils.isEmpty(source)) {
			return null;
		}
		
		DateTimeConverter dtConverter = new org.apache.commons.beanutils.converters.DateConverter();
		dtConverter.setPatterns(new String[] {
				DateFormatPattern.DATETIME_NOSECOND_PATTERN,
				DateFormatPattern.DATETIME_PATTERN, 
				DateFormatPattern.DATE_PATTERN,
				DateFormatPattern.DATE_PATTERN_SLASH,
				DateFormatPattern.DATETIME_PATTERN_SLASH,
				DateFormatPattern.DATETIME_NOSECOND_PATTERN_SLASH});
		return dtConverter.convert(Date.class, source);
	}

}
