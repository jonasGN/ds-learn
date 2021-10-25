package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.enums.ResourceType;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Resource entity tests")
public class ResourceTests {

	private Resource resource = EntitiesFactory.createResource();
	private Offer offer = EntitiesFactory.createOffer();

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
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";
		final ResourceType type = ResourceType.EXTERNAL_LINK;

		final Resource resource = new Resource(id, title, description, position, imgUri, type, offer);

		assertEquals(id, resource.getId());
		assertEquals(description, resource.getDescription());
		assertEquals(imgUri, resource.getImgUri());
		assertEquals(offer, resource.getOffer());
		assertEquals(position, resource.getPosition());
		assertEquals(title, resource.getTitle());
		assertEquals(type, resource.getType());
	}

	@Test
	public void resourcesShouldBeTheSameWhenIdIsEqual() {
		final Resource resource = new Resource(1L, "foo", null, null, null, null, offer);

		assertTrue(resource.equals(this.resource) && this.resource.equals(resource));
		assertTrue(resource.hashCode() == this.resource.hashCode());
	}

	@Test
	public void resourcesShouldBeDifferentWhenIdIsNotEqual() {
		final Resource resource = new Resource(2L, null, null, null, null, null, offer);

		assertFalse(resource.equals(this.resource) && this.resource.equals(resource));
		assertTrue(resource.hashCode() != this.resource.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";
		final ResourceType type = ResourceType.EXTERNAL_LINK;

		final Resource resource = new Resource(id, title, description, position, imgUri, type, offer);

		assertEquals(id, resource.getId());
		assertEquals(description, resource.getDescription());
		assertEquals(imgUri, resource.getImgUri());
		assertEquals(offer, resource.getOffer());
		assertEquals(position, resource.getPosition());
		assertEquals(title, resource.getTitle());
		assertEquals(type, resource.getType());
	}

	@Test
	public void settersShouldSetProperties() {
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";
		final ResourceType type = ResourceType.EXTERNAL_LINK;

		resource.setId(id);
		resource.setDescription(description);
		resource.setImgUri(imgUri);
		resource.setOffer(offer);
		resource.setPosition(position);
		resource.setTitle(title);
		resource.setType(type);

		assertEquals(id, resource.getId());
		assertEquals(description, resource.getDescription());
		assertEquals(imgUri, resource.getImgUri());
		assertEquals(offer, resource.getOffer());
		assertEquals(position, resource.getPosition());
		assertEquals(title, resource.getTitle());
		assertEquals(type, resource.getType());
	}

}
