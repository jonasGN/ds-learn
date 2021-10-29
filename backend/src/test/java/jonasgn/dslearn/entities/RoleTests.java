package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.enums.Authority;
import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Role entity tests")
public class RoleTests implements EntityTests<Role> {

	private Role role = EntitiesFactory.createRole();
	private Role expected = new Role(0L, Authority.STUDENT);

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Role role = new Role();

		assertNull(role.getId());
		assertNull(role.getAuthority());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Role role = new Role(expected.getId(), Authority.of(expected.getAuthority()));

		compareProperties(expected, role);
	}

	@Test
	public void rolesShouldBeTheSameWhenIdIsEqual() {
		expected.setId(role.getId());

		verifyEquality(expected, role);
	}

	@Test
	public void rolesShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, role);
	}

	@Test
	public void setterShouldSetProperties() {
		role.setId(expected.getId());
		role.setAuthority(Authority.of(expected.getAuthority()));

		compareProperties(expected, role);
	}

	private void compareProperties(Role expected, Role actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAuthority(), actual.getAuthority());
	}

}
