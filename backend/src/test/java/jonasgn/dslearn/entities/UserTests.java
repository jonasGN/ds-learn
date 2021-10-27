package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("User entity tests")
public class UserTests {

	private User user = EntitiesFactory.createUser();
	private User expected = new User(0L, "foo", "bar", "foo");

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNullAndRolesEmpty() {
		final User user = new User();

		assertNull(user.getEmail());
		assertNull(user.getId());
		assertNull(user.getName());
		assertNull(user.getPassword());
		assertIterableEquals(new HashSet<>(), user.getRoles());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final User u = expected;
		final User user = new User(u.getId(), u.getName(), u.getEmail(), u.getPassword());

		compareProperties(u, user);
	}

	@Test
	public void usersShouldBeTheSameWhenIdAndEmailIsEqual() {
		expected.setId(user.getId());
		expected.setEmail(user.getEmail());

		verifyEquality(expected, user);
	}

	@Test
	public void usersShouldBeDifferentWhenIdOrEmailIsNotEqual() {
		verifyDifference(expected, user);
	}

	@Test
	public void setterShouldSetProperties() {
		user.setId(expected.getId());
		user.setEmail(expected.getEmail());
		user.setName(expected.getName());
		user.setPassword(expected.getPassword());

		compareProperties(expected, user);
	}

	private void compareProperties(User expected, User actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertIterableEquals(expected.getRoles(), actual.getRoles());
	}

	private void verifyEquality(User expected, User actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(User expected, User actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}
}
