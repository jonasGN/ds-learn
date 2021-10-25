package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Section entity tests")
public class SectionTests {

	private Section section = EntitiesFactory.createSection();
	private Resource resource = EntitiesFactory.createResource();

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Section section = new Section();

		assertNull(section.getId());
		assertNull(section.getDescription());
		assertNull(section.getImgUri());
		assertNull(section.getPosition());
		assertNull(section.getPrerequisite());
		assertNull(section.getResource());
		assertNull(section.getTitle());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";

		final Section section = new Section(id, title, description, position, imgUri, this.section, resource);

		assertEquals(id, section.getId());
		assertEquals(description, section.getDescription());
		assertEquals(imgUri, section.getImgUri());
		assertEquals(position, section.getPosition());
		assertEquals(this.section, section.getPrerequisite());
		assertEquals(resource, section.getResource());
		assertEquals(title, section.getTitle());
	}

	@Test
	public void sectionsShouldBeTheSameWhenIdIsEqual() {
		final Section section = new Section(1L, null, null, null, null, this.section, resource);

		assertTrue(section.equals(this.section) && this.section.equals(section));
		assertTrue(section.hashCode() == this.section.hashCode());
	}

	@Test
	public void sectionsShouldBeDifferentWhenIdIsNotEqual() {
		final Section section = new Section(2L, null, null, null, null, this.section, resource);

		assertFalse(section.equals(this.section) && this.section.equals(section));
		assertTrue(section.hashCode() != this.section.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";

		final Section section = new Section(id, title, description, position, imgUri, this.section, resource);

		assertEquals(id, section.getId());
		assertEquals(description, section.getDescription());
		assertEquals(imgUri, section.getImgUri());
		assertEquals(position, section.getPosition());
		assertEquals(this.section, section.getPrerequisite());
		assertEquals(resource, section.getResource());
		assertEquals(title, section.getTitle());
	}

	@Test
	public void settersShouldSetProperties() {
		final long id = 3L;
		final String title = "foo";
		final String description = "bar";
		final int position = 2;
		final String imgUri = "uri";

		section.setId(id);
		section.setDescription(description);
		section.setImgUri(imgUri);
		section.setPosition(position);
		section.setPrerequisite(this.section);
		section.setResource(resource);
		section.setTitle(title);

		assertEquals(id, section.getId());
		assertEquals(description, section.getDescription());
		assertEquals(imgUri, section.getImgUri());
		assertEquals(position, section.getPosition());
		assertEquals(this.section, section.getPrerequisite());
		assertEquals(resource, section.getResource());
		assertEquals(title, section.getTitle());
	}

}
