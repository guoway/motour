package club.motour.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sylksoft.ss3a.loader.PreLoader;

import club.motour.model.ZipCode;
import club.motour.service.ZipCodeService;
import club.motour.util.ZipCodeUtils;

@Component("zipCodeLoader")
public class ZipCodeLoader implements PreLoader {
	
	@Autowired
	ZipCodeService zipCodeService;

	@Override
	public void load() {

		List<ZipCode> list = zipCodeService.getAllZipCodes();
		
		ZipCodeUtils.getInstance().reloadZipCodeMap(list);

	}

}
