package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Offer entity tests")
public class OfferTests implements EntityTests<Offer> {

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
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
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

}
