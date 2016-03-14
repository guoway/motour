package club.motour.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmailWrapper {

	private String from;
	
	private String to;
	
	private String subject;
	
	private List<String> ccList = new ArrayList<String>();
	
	private List<String> vars = new LinkedList<>();

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public List<String> getVars() {
		return vars;
	}

	public void setVars(List<String> vars) {
		this.vars = vars;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
