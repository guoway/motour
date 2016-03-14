package club.motour.ui.model;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeOnUI {

	/**
	 * 郵遞區號
	 */
	private String zip;
	
	/**
	 * Show在hint box上的值
	 */
	private String value;
	
	/**
	 * Autocomplete查詢時的token
	 */
	private List<String> tokens = new ArrayList<>();

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getTokens() {
		return tokens;
	}

	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	
	public String getTokenStr() {
		StringBuilder sb = new StringBuilder();
		for(String t : tokens) {
			sb.append(t).append(" ");
		}
		return sb.toString();
	}
	
}
