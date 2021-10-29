package jonasgn.dslearn.entities.enums;

import java.util.stream.Stream;

public enum DeliverStatus {

	PENDING(1), ACCEPTED(2), REJECTED(3);

	private Integer value;

	private DeliverStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static DeliverStatus of(Integer value) {
		return Stream.of(DeliverStatus.values()).filter(d -> d.getValue().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
