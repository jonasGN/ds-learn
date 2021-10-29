package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Topic entity tests")
public class TopicTests implements EntityTests<Topic> {

	private Topic topic = EntitiesFactory.createTopic();
	private Topic expected = new Topic(0L, "foo", "foo", Instant.now(), new User(), new Offer(), new Task());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Topic topic = new Topic();

		assertNull(topic.getId());
		assertNull(topic.getAnswer());
		assertNull(topic.getAuthor());
		assertNull(topic.getBody());
		assertNull(topic.getLesson());
		assertNull(topic.getMoment());
		assertNull(topic.getOffer());
		assertNull(topic.getTitle());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Topic t = expected;
		final Topic topic = new Topic(t.getId(), t.getTitle(), t.getBody(), t.getMoment(), t.getAuthor(), t.getOffer(),
				t.getLesson());

		compareProperties(t, topic);
	}

	@Test
	public void topicsShouldBeTheSameWhenIdIsEqual() {
		expected.setId(topic.getId());

		verifyEquality(expected, topic);
	}

	@Test
	public void topicsShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, topic);
	}

	@Test
	public void setterShouldSetProperties() {
		topic.setId(expected.getId());
		topic.setAnswer(expected.getAnswer());
		topic.setAuthor(expected.getAuthor());
		topic.setBody(expected.getBody());
		topic.setLesson(expected.getLesson());
		topic.setMoment(expected.getMoment());
		topic.setOffer(expected.getOffer());
		topic.setTitle(expected.getTitle());

		compareProperties(expected, topic);
	}

	private void compareProperties(Topic expected, Topic actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAnswer(), actual.getAnswer());
		assertEquals(expected.getAuthor(), actual.getAuthor());
		assertEquals(expected.getBody(), actual.getBody());
		assertEquals(expected.getLesson(), actual.getLesson());
		assertEquals(expected.getMoment(), actual.getMoment());
		assertEquals(expected.getOffer(), actual.getOffer());
		assertEquals(expected.getTitle(), actual.getTitle());
	}

}
