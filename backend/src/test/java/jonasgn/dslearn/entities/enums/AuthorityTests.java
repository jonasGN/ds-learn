package jonasgn.dslearn.entities.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Authority enum tests")
public class AuthorityTests {

	@Test
	public void getRoleShouldReturnRole() {
		final Authority authority = Authority.ADMIN;
		final String role = authority.getRole();

		assertEquals("ADMIN", role);
	}

	@Test
	public void ofShouldReturnAuthorityWhenRoleExistsIgnoringCase() {
		final Authority authority = Authority.of("admin");

		assertEquals(Authority.ADMIN, authority);
	}

	@Test
	public void ofShouldThrowIllegalArgumentExceptionWhenRoleDoesNotExist() {
		assertThrows(IllegalArgumentException.class, () -> {
			Authority.of("nothing");
		});
	}

}
