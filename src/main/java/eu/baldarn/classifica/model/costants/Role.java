package eu.baldarn.classifica.model.costants;

public enum Role {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");
	
	private String value;
 
	private Role(String s) {
		value = s;
	}
 
	public String getValue() {
		return value;
	}
	
}
