package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.enums.ResourceType;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Resource entity tests")
public class ResourceTests {

	private Resource resource = EntitiesFactory.createResource();
	private Resource expected = new Resource(0L, "foo", "bar", 0, "foo", ResourceType.EXTERNAL_LINK, new Offer());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Resource resource = new Resource();

		assertNull(resource.getId());
		assertNull(resource.getDescription());
		assertNull(resource.getImgUri());
		assertNull(resource.getOffer());
		assertNull(resource.getPosition());
		assertNull(resource.getTitle());
		assertNull(resource.getType());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final Resource r = expected;
		final Resource resource = new Resource(r.getId(), r.getTitle(), r.getDescription(), r.getPosition(),
				r.getImgUri(), r.getType(), r.getOffer());

		compareProperties(r, resource);
	}

	@Test
	public void resourcesShouldBeTheSameWhenIdIsEqual() {
		expected.setId(resource.getId());

		verifyEquality(expected, resource);
	}

	@Test
	public void resourcesShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, resource);
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		compareProperties(expected, expected);
	}

	@Test
	public void settersShouldSetProperties() {
		resource.setId(expected.getId());
		resource.setDescription(expected.getDescription());
		resource.setImgUri(expected.getImgUri());
		resource.setOffer(expected.getOffer());
		resource.setPosition(expected.getPosition());
		resource.setTitle(expected.getTitle());
		resource.setType(expected.getType());

		compareProperties(expected, resource);
	}

	private void compareProperties(Resource expected, Resource actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getImgUri(), actual.getImgUri());
		assertEquals(expected.getOffer(), actual.getOffer());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertIterableEquals(expected.getSections(), actual.getSections());
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getType(), actual.getType());
	}

	private void verifyEquality(Resource expected, Resource actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(Resource expected, Resource actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}

}
