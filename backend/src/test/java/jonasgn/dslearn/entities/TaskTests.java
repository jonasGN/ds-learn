package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Task entity tests")
public class TaskTests implements EntityTests<Task> {

	private Task task = EntitiesFactory.createTask();
	private Task expected = new Task(0L, "foo", 0, new Section(), "foo", 0, 0, 0.0, Instant.now());

	@Test
	public void emptyConstructorShouldSetAllPropertiesToNull() {
		final Task task = new Task();

		assertNull(task.getId());
		assertNull(task.getApprovalCount());
		assertNull(task.getDescription());
		assertNull(task.getDueDate());
		assertNull(task.getQuestionCount());
		assertNull(task.getWeight());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Task t = expected;
		final Task task = new Task(t.getId(), t.getTitle(), t.getPosition(), t.getSection(), t.getDescription(),
				t.getQuestionCount(), t.getApprovalCount(), t.getWeight(), t.getDueDate());

		compareProperties(t, task);
	}

	@Test
	public void tasksShouldBeTheSameWhenIdIsEqual() {
		expected.setId(task.getId());

		verifyEquality(expected, task);
	}

	@Test
	public void tasksShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, task);
	}

	@Test
	public void setterShouldSetProperties() {

		task.setId(expected.getId());
		task.setApprovalCount(expected.getApprovalCount());
		task.setDescription(expected.getDescription());
		task.setDueDate(expected.getDueDate());
		task.setQuestionCount(expected.getQuestionCount());
		task.setWeight(expected.getWeight());

		compareProperties(expected, task);
	}

	private void compareProperties(Task expected, Task actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getApprovalCount(), actual.getApprovalCount());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getDueDate(), actual.getDueDate());
		assertEquals(expected.getQuestionCount(), actual.getQuestionCount());
		assertEquals(expected.getWeight(), actual.getWeight());
	}

}
