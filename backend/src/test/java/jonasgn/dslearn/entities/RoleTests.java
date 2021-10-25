package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.enums.Authority;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Role entity tests")
public class RoleTests {

	private Role role = EntitiesFactory.createRole();

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Role role = new Role();

		assertNull(role.getId());
		assertNull(role.getAuthority());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final long id = 3L;
		final Authority authority = Authority.ADMIN;
		final Role role = new Role(id, authority);

		assertEquals(id, role.getId());
		assertEquals(authority, Authority.of(role.getAuthority()));
	}

	@Test
	public void rolesShouldBeTheSameWhenIdIsEqual() {
		final Role role = new Role(1L, Authority.STUDENT);

		assertTrue(role.equals(this.role) && this.role.equals(role));
		assertTrue(role.hashCode() == this.role.hashCode());
	}

	@Test
	public void rolesShouldBeDifferentWhenIdIsNotEqual() {
		final Role role = new Role(2L, Authority.ADMIN);

		assertFalse(role.equals(this.role) && this.role.equals(role));
		assertTrue(role.hashCode() != this.role.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final String expected = "ADMIN";

		assertEquals(1L, role.getId());
		assertEquals(expected, role.getAuthority());
	}

	@Test
	public void setterShouldSetProperties() {
		final long id = 3L;
		final Authority authority = Authority.ADMIN;

		role.setId(id);
		role.setAuthority(authority);

		assertEquals(id, role.getId());
		assertEquals(authority, Authority.of(role.getAuthority()));
	}

}
