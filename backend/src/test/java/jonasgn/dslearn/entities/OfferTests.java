package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Offer entity tests")
public class OfferTests {

	private Offer offer = EntitiesFactory.createOffer();

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
		final long id = 3L;
		final Course course = EntitiesFactory.createCourse();
		final String edition = "foo";
		final Instant start = Instant.now();
		final Instant end = Instant.now().plusSeconds(3600);
		final Offer offer = new Offer(id, edition, start, end, course);

		assertEquals(id, offer.getId());
		assertEquals(course, offer.getCourse());
		assertEquals(edition, offer.getEdition());
		assertEquals(start, offer.getStartMoment());
		assertEquals(end, offer.getEndMoment());
	}

	@Test
	public void offersShouldBeTheSameWhenIdIsEqual() {
		final Offer offer = new Offer(1L, null, null, null, null);

		assertTrue(offer.equals(this.offer) && this.offer.equals(offer));
		assertTrue(offer.hashCode() == this.offer.hashCode());
	}

	@Test
	public void offersShouldBeDifferentWhenIdIsNotEqual() {
		final Offer offer = new Offer(2L, null, null, null, null);

		assertFalse(offer.equals(this.offer) && this.offer.equals(offer));
		assertTrue(offer.hashCode() != this.offer.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final long id = 3L;
		final Course course = EntitiesFactory.createCourse();
		final String edition = "foo";
		final Instant start = Instant.now();
		final Instant end = Instant.now().plusSeconds(3600);
		final Offer offer = new Offer(id, edition, start, end, course);

		assertEquals(id, offer.getId());
		assertEquals(course, offer.getCourse());
		assertEquals(edition, offer.getEdition());
		assertEquals(start, offer.getStartMoment());
		assertEquals(end, offer.getEndMoment());
	}

	@Test
	public void setterShouldSetProperties() {
		final long id = 3L;
		final Course course = EntitiesFactory.createCourse();
		final String edition = "foo";
		final Instant start = Instant.now().plusSeconds(1);
		final Instant end = Instant.now().plusSeconds(2);

		offer.setId(id);
		offer.setCourse(course);
		offer.setEdition(edition);
		offer.setStartMoment(start);
		offer.setEndMoment(end);

		assertEquals(id, offer.getId());
		assertEquals(course, offer.getCourse());
		assertEquals(edition, offer.getEdition());
		assertEquals(start, offer.getStartMoment());
		assertEquals(end, offer.getEndMoment());
	}
}
