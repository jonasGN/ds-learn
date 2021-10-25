package jonasgn.dslearn.entities.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ResourceType enum tests")
public class ResourceTypeTests {

	@Test
	public void getValueShouldReturnValue() {
		final ResourceType type = ResourceType.FORUM;
		final int value = type.getValue();

		assertEquals(3, value);
	}

	@Test
	public void ofShouldReturnResourceTypeWhenValueExists() {
		final ResourceType type = ResourceType.of(1);

		assertEquals(ResourceType.LESSON_ONLY, type);
	}

	@Test
	public void ofShouldThrowIllegalArgumentExceptionWhenValueDoesNotExist() {
		assertThrows(IllegalArgumentException.class, () -> {
			ResourceType.of(0);
		});
	}

}
