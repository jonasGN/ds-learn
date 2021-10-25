package jonasgn.dslearn.entities.pk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.Course;
import jonasgn.dslearn.entities.Offer;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Enrollment PK tests")
public class EnrollmentPkTests {

	private User user = new User(0L, "foo", "bar", "foo");
	private Offer offer = new Offer(0L, "foo", Instant.now(), Instant.now().plusSeconds(1), new Course());

	private EnrollmentPK pk = new EnrollmentPK(EntitiesFactory.createUser(), EntitiesFactory.createOffer());
	private EnrollmentPK expected = new EnrollmentPK(user, offer);

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final EnrollmentPK pk = new EnrollmentPK();

		assertNull(pk.getOffer());
		assertNull(pk.getStudent());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final EnrollmentPK e = expected;
		final EnrollmentPK pk = new EnrollmentPK(e.getStudent(), e.getOffer());

		compareProperties(e, pk);
	}

	@Test
	public void enrollmentsPkShouldBeTheSameWhenUserAndOfferIsEqual() {
		expected.setOffer(pk.getOffer());
		expected.setStudent(pk.getStudent());

		verifyEquality(expected, pk);
	}

	@Test
	public void enrollmentsPkShouldBeDifferentWhenIdAndOfferIsNotEqual() {
		verifyDifference(expected, pk);
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		compareProperties(expected, expected);
	}

	@Test
	public void setterShouldSetProperties() {
		pk.setOffer(expected.getOffer());
		pk.setStudent(expected.getStudent());

		compareProperties(expected, pk);
	}

	private void compareProperties(EnrollmentPK expected, EnrollmentPK actual) {
		assertEquals(expected.getOffer(), actual.getOffer());
		assertEquals(expected.getStudent(), actual.getStudent());
	}

	private void verifyEquality(EnrollmentPK expected, EnrollmentPK actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(EnrollmentPK expected, EnrollmentPK actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}
}
