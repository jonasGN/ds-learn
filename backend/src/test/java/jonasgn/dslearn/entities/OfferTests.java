package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Offer entity tests")
public class OfferTests {

	private Offer offer = EntitiesFactory.createOffer();
	private Offer expected = new Offer(0L, "foo", Instant.now(), Instant.now(), new Course());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Offer offer = new Offer();

		assertNull(offer.getId());
		assertNull(offer.getCourse());
		assertNull(offer.getEdition());
		assertNull(offer.getEndMoment());
		assertNull(offer.getStartMoment());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final Offer of = expected;
		final Offer offer = new Offer(of.getId(), of.getEdition(), of.getStartMoment(), of.getEndMoment(),
				of.getCourse());

		compareProperties(of, offer);
	}

	@Test
	public void offersShouldBeTheSameWhenIdIsEqual() {
		expected.setId(offer.getId());

		verifyEquality(expected, offer);
	}

	@Test
	public void offersShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, offer);
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		compareProperties(expected, expected);
	}

	@Test
	public void setterShouldSetProperties() {
		offer.setId(expected.getId());
		offer.setCourse(expected.getCourse());
		offer.setEdition(expected.getEdition());
		offer.setStartMoment(expected.getStartMoment());
		offer.setEndMoment(expected.getEndMoment());

		compareProperties(expected, offer);
	}

	private void compareProperties(Offer expected, Offer actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getCourse(), actual.getCourse());
		assertEquals(expected.getEdition(), actual.getEdition());
		assertEquals(expected.getEndMoment(), actual.getEndMoment());
		assertIterableEquals(expected.getResources(), actual.getResources());
		assertEquals(expected.getStartMoment(), actual.getStartMoment());
	}

	private void verifyEquality(Offer expected, Offer actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(Offer expected, Offer actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}
}
