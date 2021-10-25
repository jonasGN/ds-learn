package jonasgn.dslearn.factories;

import jonasgn.dslearn.entities.Course;
import jonasgn.dslearn.entities.Role;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.entities.enums.Authority;

public class EntitiesFactory {

	public static Role createRole() {
		return new Role(1L, Authority.ADMIN);
	}

	public static User createUser() {
		return new User(1L, "Fulano", "email", "password");
	}

	public static Course createCourse() {
		return new Course(1L, "Course", "image_uri", "image_gray_uri");
	}
}
