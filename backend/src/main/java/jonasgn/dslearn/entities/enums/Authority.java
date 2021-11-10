package jonasgn.dslearn.entities.enums;

import java.util.stream.Stream;

public enum Authority {

	ADMIN("ROLE_ADMIN"), INSTRUCTOR("ROLE_INSTRUCTOR"), STUDENT("ROLE_STUDENT");

	private String role;

	private Authority(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public static Authority of(String role) {
		return Stream.of(Authority.values()).filter(a -> a.getRole().equalsIgnoreCase(role)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
