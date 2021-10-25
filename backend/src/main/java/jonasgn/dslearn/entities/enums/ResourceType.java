package jonasgn.dslearn.entities.enums;

import java.util.stream.Stream;

public enum ResourceType {

	LESSON_ONLY(1), LESSON_TASK(2), FORUM(3), EXTERNAL_LINK(4);

	private Integer value;

	private ResourceType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static ResourceType of(Integer value) {
		return Stream.of(ResourceType.values()).filter(r -> r.getValue().equals(value)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
