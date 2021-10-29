package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Reply entity tests")
public class ReplyTests implements EntityTests<Reply> {

	private Reply reply = EntitiesFactory.createReply();
	private Reply expected = new Reply(0L, "foo", Instant.now(), new Topic(), new User());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Reply reply = new Reply();

		assertNull(reply.getId());
		assertNull(reply.getAuthor());
		assertNull(reply.getBody());
		assertNull(reply.getMoment());
		assertNull(reply.getTopic());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Reply r = expected;
		final Reply reply = new Reply(r.getId(), r.getBody(), r.getMoment(), r.getTopic(), r.getAuthor());

		compareProperties(r, reply);
	}

	@Test
	public void repliesShouldBeTheSameWhenIdIsEqual() {
		expected.setId(reply.getId());

		verifyEquality(expected, reply);
	}

	@Test
	public void repliesShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, reply);
	}

	@Test
	public void setterShouldSetProperties() {
		reply.setId(expected.getId());
		reply.setAuthor(expected.getAuthor());
		reply.setBody(expected.getBody());
		reply.setMoment(expected.getMoment());
		reply.setTopic(expected.getTopic());

		compareProperties(expected, reply);
	}

	private void compareProperties(Reply expected, Reply actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAuthor(), actual.getAuthor());
		assertEquals(expected.getBody(), actual.getBody());
		assertEquals(expected.getMoment(), actual.getMoment());
		assertEquals(expected.getTopic(), actual.getTopic());
	}

}
