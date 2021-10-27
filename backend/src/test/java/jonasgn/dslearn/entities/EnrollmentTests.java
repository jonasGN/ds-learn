package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Enrollment entity tests")
public class EnrollmentTests {

	private User user = new User(0L, "foo", "bar", "foo");
	private Offer offer = new Offer(0L, "foo", Instant.now(), Instant.now().plusSeconds(1), new Course());

	private Enrollment enrollment = EntitiesFactory.createEnrollment();
	private Enrollment expected = new Enrollment(user, offer, Instant.now(), Instant.now(), false, false);

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Enrollment enrollment = new Enrollment();

		assertNull(enrollment.getEnrollMoment());
		assertNull(enrollment.getOffer());
		assertNull(enrollment.getRefundMoment());
		assertNull(enrollment.getStudent());
		assertFalse(enrollment.isAvailable());
		assertFalse(enrollment.hasOnlyUpdates());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Enrollment e = expected;
		final Enrollment enrollment = new Enrollment(e.getStudent(), e.getOffer(), e.getEnrollMoment(),
				e.getRefundMoment(), e.isAvailable(), e.hasOnlyUpdates());

		compareProperties(e, enrollment);
	}

	@Test
	public void enrollmentsShouldBeTheSameWhenStudentAndOfferIsEqual() {
		expected.setOffer(enrollment.getOffer());
		expected.setStudent(enrollment.getStudent());

		verifyEquality(expected, enrollment);
	}

	@Test
	public void enrollmentsShouldBeDifferentWhenStudentAndOfferIsNotEqual() {
		verifyDifference(expected, enrollment);
	}

	@Test
	public void setterShouldSetProperties() {
		enrollment.setOffer(expected.getOffer());
		enrollment.setStudent(expected.getStudent());
		enrollment.setAvailable(expected.isAvailable());
		enrollment.setEnrollMoment(expected.getEnrollMoment());
		enrollment.setOnlyUpdate(expected.hasOnlyUpdates());
		enrollment.setRefundMoment(expected.getRefundMoment());

		compareProperties(expected, enrollment);
	}

	private void compareProperties(Enrollment expected, Enrollment actual) {
		assertEquals(expected.getStudent(), actual.getStudent());
		assertEquals(expected.getOffer(), actual.getOffer());
		assertEquals(expected.getEnrollMoment(), actual.getEnrollMoment());
		assertEquals(expected.getRefundMoment(), actual.getRefundMoment());
		assertEquals(expected.isAvailable(), actual.isAvailable());
		assertEquals(expected.hasOnlyUpdates(), actual.hasOnlyUpdates());
	}

	private void verifyEquality(Enrollment expected, Enrollment actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(Enrollment expected, Enrollment actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}

}
