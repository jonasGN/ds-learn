package jonasgn.dslearn.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public abstract class StringExtension {

	public static String toFormalName(String name) {
		final List<String> collection = new ArrayList<>();
		final StringJoiner joiner = new StringJoiner(" ");

		name = removeExcessiveWhiteSpaces(clean(name));

		for (String n : name.split(" ")) {
			final Character first = Character.toUpperCase(n.charAt(0));
			final String subsequential = n.substring(1).toLowerCase();

			final String formated = first.toString() + subsequential;

			collection.add(formated);
			joiner.add(formated);
		}

		return joiner.toString();
	}

	// TODO: Avoid to remove non ASCII chars and upper case letters
	public static String clean(String value) {
		final int flags = Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
		final Pattern regex = Pattern.compile("[^a-z\s]+", flags);

		return value.replaceAll(regex.pattern(), "");
	}

	public static String removeExcessiveWhiteSpaces(String value) {
		final var regex = Pattern.compile("[\s]{2,}");

		return value.replaceAll(regex.pattern(), " ").trim();
	}

}
