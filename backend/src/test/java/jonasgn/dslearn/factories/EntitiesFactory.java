package jonasgn.dslearn.factories;

import java.time.Instant;

import jonasgn.dslearn.entities.Course;
import jonasgn.dslearn.entities.Enrollment;
import jonasgn.dslearn.entities.Offer;
import jonasgn.dslearn.entities.Resource;
import jonasgn.dslearn.entities.Role;
import jonasgn.dslearn.entities.Section;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.entities.enums.Authority;
import jonasgn.dslearn.entities.enums.ResourceType;

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

	public static Offer createOffer() {
		return new Offer(1L, "edition", Instant.now(), Instant.now().plusSeconds(3600), createCourse());
	}

	public static Resource createResource() {
		return new Resource(1L, "title", "description", 1, "img_uri", ResourceType.LESSON_ONLY, createOffer());
	}

	public static Section createSection() {
		return new Section(1L, "title", "description", 1, "igm_uri", new Section(), createResource());
	}

	public static Enrollment createEnrollment() {
		return new Enrollment(createUser(), createOffer(), Instant.now(), Instant.now().plusSeconds(3600), true, false);
	}
}
