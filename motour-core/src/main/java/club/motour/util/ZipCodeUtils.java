package club.motour.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import club.motour.model.ZipCode;

public class ZipCodeUtils {

	private static ZipCodeUtils instance;
	
	private Map<BigDecimal, ZipCode> map = new HashMap<>();
	
	private ZipCodeUtils() {
		
	}
	
	public List<ZipCode> getAllZipCode() {
		List<ZipCode> list = new ArrayList<>();
		for(ZipCode z : map.values()) {
			try {
				list.add(z.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static ZipCodeUtils getInstance() {
		if(null == instance) {
			instance = new ZipCodeUtils();
		}
		return instance;
	}
	
	
	public void reloadZipCodeMap(List<ZipCode> zipList) {
		
		Map<BigDecimal, ZipCode> newMap = new HashMap<>();
		for(ZipCode z : zipList) {
			newMap.put(z.getId(), z);
		}
		
		synchronized(map) {
			map = newMap;			
		}
	}
}
