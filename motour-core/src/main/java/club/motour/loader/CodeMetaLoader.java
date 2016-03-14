package club.motour.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sylksoft.ss3a.loader.PreLoader;

import club.motour.model.CodeMeta;
import club.motour.service.CodeMetaService;
import club.motour.util.CodeMetaUtils;

@Component("codeMetaLoader")
public class CodeMetaLoader implements PreLoader {

	@Autowired
	CodeMetaService codeMetaService;
	
	@Override
	public void load() {
		List<CodeMeta> list = codeMetaService.getAllCodeMeta();
		
		CodeMetaUtils.getInstance().reloadCodeMetaMap(list);
	}

}
