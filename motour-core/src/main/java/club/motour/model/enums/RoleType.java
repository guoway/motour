package club.motour.model.enums;

/**
 * Role Type
 * @author Ken Chen
 *
 */
public enum RoleType {

	ADM_USER("adm_user"),
	GUEST("guest"),
	VIP_1("vip_1"),
	VIP_2("vip_2"),
	WEB_USER("web_user");
	
	private final String name;
	
	private RoleType(String name) {
		this.name = name;
	}
	
	public static RoleType getRoleTypeByName(String name) {
		for(RoleType r: RoleType.values()) {
			if(r.name.equals(name)) {
				return r;
			}
		}
		return null;
	}
	
	public String getName() {
		return name;
	}
}
