package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Content entity tests")
public class ContentTests implements EntityTests<Content> {

	private Content content = EntitiesFactory.createContent();
	private Content expected = new Content(0L, "foo", 0, new Section(), "foo", "foo");

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Content content = new Content();

		assertNull(content.getId());
		assertNull(content.getTextContent());
		assertNull(content.getVideoUri());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Content c = expected;
		final Content content = new Content(c.getId(), c.getTitle(), c.getPosition(), c.getSection(),
				c.getTextContent(), c.getVideoUri());

		compareProperties(c, content);
	}

	@Test
	public void contentsShouldBeTheSameWhenIdIsEqual() {
		expected.setId(content.getId());

		verifyEquality(expected, content);
	}

	@Test
	public void contentsShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, content);
	}

	@Test
	public void setterShouldSetProperties() {
		content.setId(expected.getId());
		content.setTextContent(expected.getTextContent());
		content.setVideoUri(expected.getVideoUri());

		compareProperties(expected, content);
	}

	private void compareProperties(Content expected, Content actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getTextContent(), actual.getTextContent());
		assertEquals(expected.getVideoUri(), actual.getVideoUri());
	}
}
