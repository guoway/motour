package club.motour.dao;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import com.sylksoft.util.DateUtil;

public class Test {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("ken@sylksoft.com").append(DateUtil.formatDate(DateUtil.formatDate(new Date(), "yyyyMMddhhmmssSSS")));
		String code = DigestUtils.md5Hex(sb.toString());
		System.out.println(code);
	}

}
