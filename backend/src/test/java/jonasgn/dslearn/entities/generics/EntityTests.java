package jonasgn.dslearn.entities.generics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface EntityTests<T> {

	default void verifyEquality(T expected, T actual) {
		assertTrue(expected.equals(actual) && actual.equals(expected));
		assertTrue(expected.hashCode() == actual.hashCode());
	}

	default void verifyDifference(T expected, T actual) {
		assertFalse(expected.equals(actual) && actual.equals(expected));
		assertFalse(expected.hashCode() == actual.hashCode());
	}

}
