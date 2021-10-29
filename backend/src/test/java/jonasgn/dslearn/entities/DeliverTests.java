package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.enums.DeliverStatus;
import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Deliver entity tests")
public class DeliverTests implements EntityTests<Deliver> {

	private Deliver deliver = EntitiesFactory.createDeliver();
	private Deliver expected = new Deliver(0L, "foo", Instant.now(), DeliverStatus.ACCEPTED, "foo", 0, new Enrollment(),
			new Task());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Deliver deliver = new Deliver();

		assertNull(deliver.getId());
		assertNull(deliver.getCorrectCount());
		assertNull(deliver.getEnrollment());
		assertNull(deliver.getFeedback());
		assertNull(deliver.getLesson());
		assertNull(deliver.getMoment());
		assertNull(deliver.getStatus());
		assertNull(deliver.getUri());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Deliver d = expected;
		final Deliver deliver = new Deliver(d.getId(), d.getUri(), d.getMoment(), d.getStatus(), d.getFeedback(),
				d.getCorrectCount(), d.getEnrollment(), d.getLesson());

		compareProperties(d, deliver);
	}

	@Test
	public void deliveriesShouldBeTheSameWhenIdIsEqual() {
		expected.setId(deliver.getId());

		verifyEquality(expected, deliver);
	}

	@Test
	public void deliveriesShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, deliver);
	}

	@Test
	public void setterShouldSetProperties() {
		deliver.setId(expected.getId());
		deliver.setCorrectCount(expected.getCorrectCount());
		deliver.setEnrollment(expected.getEnrollment());
		deliver.setFeedback(expected.getFeedback());
		deliver.setLesson(expected.getLesson());
		deliver.setMoment(expected.getMoment());
		deliver.setStatus(expected.getStatus());
		deliver.setUri(expected.getUri());

		compareProperties(expected, deliver);
	}

	private void compareProperties(Deliver expected, Deliver actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getCorrectCount(), actual.getCorrectCount());
		assertEquals(expected.getEnrollment(), actual.getEnrollment());
		assertEquals(expected.getFeedback(), actual.getFeedback());
		assertEquals(expected.getLesson(), actual.getLesson());
		assertEquals(expected.getMoment(), actual.getMoment());
		assertEquals(expected.getStatus(), actual.getStatus());
		assertEquals(expected.getUri(), actual.getUri());
	}
}
