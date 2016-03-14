package com.sylksoft.spring.util;

import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

@Component("objectMapper")
public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -4287660997536769622L;

	public HibernateAwareObjectMapper() {
		Hibernate4Module hm = new Hibernate4Module();
		hm.disable(Feature.USE_TRANSIENT_ANNOTATION);
		registerModule(hm);
		
		//registerModule(new Hibernate4Module());
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);	
		configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		setTimeZone(TimeZone.getDefault());	
	}
}
