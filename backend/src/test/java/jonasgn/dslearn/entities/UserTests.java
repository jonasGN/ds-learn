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
	public void argsConstructorShouldSetAllProperties() {
		final long id = 3L;
		final String name = "Foo";
		final String email = "Bar";
		final String password = "pass";
		final User user = new User(id, name, email, password);

		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
	}

	@Test
	public void usersShouldBeTheSameWhenIdAndEmailIsEqual() {
		final User user = new User(1L, null, "email", null);

		assertTrue(user.equals(this.user) && this.user.equals(user));
		assertTrue(user.hashCode() == this.user.hashCode());
	}

	@Test
	public void usersShouldBeDifferentWhenIdOrEmailIsNotEqual() {
		final User user = new User(2L, null, "email", null);

		assertFalse(user.equals(this.user) && this.user.equals(user));
		assertTrue(user.hashCode() != this.user.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final long id = 3L;
		final String name = "Foo";
		final String email = "Bar";
		final String password = "pass";
		final User user = new User(id, name, email, password);

		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
		assertEquals(new HashSet<Role>(), user.getRoles());
	}

	@Test
	public void setterShouldSetProperties() {
		final long id = 3L;
		final String name = "Foo";
		final String email = "Bar";
		final String password = "pass";

		user.setId(id);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);

		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
	}
}
