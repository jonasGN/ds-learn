package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jonasgn.dslearn.factories.EntitiesFactory;

public class LessonTests {

	private Lesson task = EntitiesFactory.createTask();
	private Lesson content = EntitiesFactory.createContent();

	@Test
	public void setterShouldSetProperties() {
		content.setId(task.getId());
		content.setPosition(task.getPosition());
		content.setSection(task.getSection());
		content.setTitle(task.getTitle());

		compareProperties(content, task);
	}

	private void compareProperties(Lesson expected, Lesson actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertEquals(expected.getSection(), actual.getSection());
		assertEquals(expected.getTitle(), actual.getTitle());
	}

}
