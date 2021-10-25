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

	private Resource resource = EntitiesFactory.createResource();
	private Section section = EntitiesFactory.createSection();
	private Section expected = new Section(0L, "foo", "bar", 0, "foo", new Section(), resource);

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
		final Section s = expected;
		final Section section = new Section(s.getId(), s.getTitle(), s.getDescription(), s.getPosition(), s.getImgUri(),
				s.getPrerequisite(), s.getResource());

		compareProperties(s, section);
	}

	@Test
	public void sectionsShouldBeTheSameWhenIdIsEqual() {
		expected.setId(section.getId());

		verifyEquality(expected, section);
	}

	@Test
	public void sectionsShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, section);
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		compareProperties(expected, expected);
	}

	@Test
	public void settersShouldSetProperties() {
		section.setId(expected.getId());
		section.setDescription(expected.getDescription());
		section.setImgUri(expected.getImgUri());
		section.setPosition(expected.getPosition());
		section.setPrerequisite(expected.getPrerequisite());
		section.setResource(expected.getResource());
		section.setTitle(expected.getTitle());

		compareProperties(expected, section);
	}

	private void compareProperties(Section expected, Section actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getImgUri(), actual.getImgUri());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertEquals(expected.getPrerequisite(), actual.getPrerequisite());
		assertEquals(expected.getResource(), actual.getResource());
		assertEquals(expected.getTitle(), actual.getTitle());
	}

	private void verifyEquality(Section expected, Section actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	private void verifyDifference(Section expected, Section actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}

}
