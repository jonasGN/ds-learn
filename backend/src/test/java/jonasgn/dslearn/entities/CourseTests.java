package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Course entity tests")
public class CourseTests implements EntityTests<Course> {

	private Course course = EntitiesFactory.createCourse();
	private Course expected = new Course(0L, "foo", "bar", "bar");

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Course course = new Course();

		assertNull(course.getId());
		assertNull(course.getImgGrayUri());
		assertNull(course.getImgUri());
		assertNull(course.getName());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Course c = expected;
		final Course course = new Course(c.getId(), c.getName(), c.getImgUri(), c.getImgGrayUri());

		compareProperties(c, course);
	}

	@Test
	public void coursesShouldBeTheSameWhenIdIsEqual() {
		expected.setId(course.getId());

		verifyEquality(expected, course);
	}

	@Test
	public void coursesShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, course);
	}

	@Test
	public void setterShouldSetProperties() {
		course.setId(expected.getId());
		course.setImgGrayUri(expected.getImgGrayUri());
		course.setImgUri(expected.getImgUri());
		course.setName(expected.getName());

		compareProperties(expected, course);
	}

	private void compareProperties(Course expected, Course actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getImgGrayUri(), actual.getImgGrayUri());
		assertEquals(expected.getImgUri(), actual.getImgUri());
		assertEquals(expected.getName(), actual.getName());
		assertIterableEquals(expected.getOffers(), actual.getOffers());
	}

}
