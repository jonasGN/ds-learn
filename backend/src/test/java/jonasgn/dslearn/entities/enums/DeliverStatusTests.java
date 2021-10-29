package jonasgn.dslearn.entities.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DeliverStatus enum tests")
public class DeliverStatusTests {

	@Test
	public void getValueShouldReturnValue() {
		final DeliverStatus status = DeliverStatus.PENDING;
		final int value = status.getValue();

		assertEquals(1, value);
	}

	@Test
	public void ofShouldReturnDeliverStatusWhenValueExists() {
		final DeliverStatus status = DeliverStatus.of(1);

		assertEquals(DeliverStatus.PENDING, status);
	}

	@Test
	public void ofShouldThrowIllegalArgumentExceptionWhenValueDoesNotExist() {
		assertThrows(IllegalArgumentException.class, () -> {
			DeliverStatus.of(0);
		});
	}
}
