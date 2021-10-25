package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Course entity tests")
public class CourseTests {

	private Course course = EntitiesFactory.createCourse();

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Course course = new Course();

		assertNull(course.getId());
		assertNull(course.getImgGrayUri());
		assertNull(course.getImgUri());
		assertNull(course.getName());
	}

	@Test
	public void argsConstructorShouldSetAllProperties() {
		final long id = 3L;
		final String imgGrayUri = "gray_uri";
		final String imgUri = "uri";
		final String name = "foo";
		final Course course = new Course(id, name, imgUri, imgGrayUri);

		assertEquals(id, course.getId());
		assertEquals(imgGrayUri, course.getImgGrayUri());
		assertEquals(imgUri, course.getImgUri());
		assertEquals(name, course.getName());
	}

	@Test
	public void coursesShouldBeTheSameWhenIdIsEqual() {
		final Course course = new Course(1L, "foo", "foo", "foo");

		assertTrue(course.equals(this.course) && this.course.equals(course));
		assertTrue(course.hashCode() == this.course.hashCode());
	}

	@Test
	public void coursesShouldBeDifferentWhenIdIsNotEqual() {
		final Course course = new Course(2L, "foo", "foo", "foo");

		assertFalse(course.equals(this.course) && this.course.equals(course));
		assertTrue(course.hashCode() != this.course.hashCode());
	}

	@Test
	public void gettersShouldReturnPropertiesValues() {
		final long id = 3L;
		final String imgGrayUri = "gray_uri";
		final String imgUri = "uri";
		final String name = "foo";
		final Course course = new Course(id, name, imgUri, imgGrayUri);

		assertEquals(id, course.getId());
		assertEquals(imgGrayUri, course.getImgGrayUri());
		assertEquals(imgUri, course.getImgUri());
		assertEquals(name, course.getName());
	}

	@Test
	public void setterShouldSetProperties() {
		final long id = 3L;
		final String imgGrayUri = "gray_uri";
		final String imgUri = "uri";
		final String name = "foo";

		course.setId(id);
		course.setImgGrayUri(imgGrayUri);
		course.setImgUri(imgUri);
		course.setName(name);

		assertEquals(id, course.getId());
		assertEquals(imgGrayUri, course.getImgGrayUri());
		assertEquals(imgUri, course.getImgUri());
		assertEquals(name, course.getName());
	}
}
