package club.motour.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import club.motour.model.CodeMeta;

public class CodeMetaUtils {

	private static CodeMetaUtils instance;
	
	private Map<BigDecimal, CodeMeta> map = new HashMap<>();
	
	private CodeMetaUtils() {
		
	}
	
	public static CodeMetaUtils getInstance() {
		if(null == instance) {
			instance = new CodeMetaUtils();			
		}
		return instance;
	}
	
	public void reloadCodeMetaMap(List<CodeMeta> list) {
		Map<BigDecimal, CodeMeta> m = new HashMap<>();
		for(CodeMeta c : list) {
			m.put(c.getId(), c);
		}
		
		synchronized(map) {
			map = m;
		}		
	}
	
	public CodeMeta getCodeMetaById(BigDecimal id) {			
		return map.get(id);
	}
	
	/**
	 * 依Parent ID取得所有sub CodeMeta
	 * @param parentId
	 * @return
	 */
	public List<CodeMeta> getCodeMetaByParentId(BigDecimal parentId) {
		List<CodeMeta> list = new ArrayList<>();
		
		for(CodeMeta c : map.values()) {
			if(c.getParent() != null && c.getParent().getId().equals(parentId)) {
				list.add(c);
			}
		}
		
		return list;
		
	}
}
