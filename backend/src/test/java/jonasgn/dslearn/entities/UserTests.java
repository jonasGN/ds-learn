package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("User entity tests")
public class UserTests implements EntityTests<User> {

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
	public void usersShouldBeTheSameWhenIdIsEqual() {
		expected.setId(user.getId());

		verifyEquality(expected, user);
	}

	@Test
	public void usersShouldBeDifferentWhenIdIsNotEqual() {
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

	@Test
	public void setEmailShouldReturnEmailInLowerCase() {
		final String input = " EMail.mesSY_123@email.com 	  ";
		final String output = "email.messy_123@email.com";

		user.setEmail(input);

		assertEquals(output, user.getEmail());
	}

	@Test
	public void setNameShouldRemoveNonAlphabeticalCharsAndFormatName() {
		final String input = " ()))     jùlIA GonÇalves *777-=.;/,  maRAnhÃo  Águamânsa  **??   â^[[]}{`'\"";
		final String output = "Júlia Gonçalves Maranhão Águamânsa";

		user.setName(input);

		assertEquals(output, user.getName());
	}

	private void compareProperties(User expected, User actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPassword(), actual.getPassword());
		assertIterableEquals(expected.getRoles(), actual.getRoles());
	}

}
