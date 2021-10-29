package jonasgn.dslearn.factories;

import java.time.Instant;

import jonasgn.dslearn.entities.Content;
import jonasgn.dslearn.entities.Course;
import jonasgn.dslearn.entities.Deliver;
import jonasgn.dslearn.entities.Enrollment;
import jonasgn.dslearn.entities.Notification;
import jonasgn.dslearn.entities.Offer;
import jonasgn.dslearn.entities.Reply;
import jonasgn.dslearn.entities.Resource;
import jonasgn.dslearn.entities.Role;
import jonasgn.dslearn.entities.Section;
import jonasgn.dslearn.entities.Task;
import jonasgn.dslearn.entities.Topic;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.entities.enums.Authority;
import jonasgn.dslearn.entities.enums.DeliverStatus;
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

	public static Content createContent() {
		return new Content(1L, "title", 1, createSection(), "text_content", "video_uri");
	}

	public static Deliver createDeliver() {
		return new Deliver(1L, "uri", Instant.now(), DeliverStatus.ACCEPTED, "feedback", 1, createEnrollment(),
				createTask());
	}

	public static Task createTask() {
		return new Task(1L, "title", 1, createSection(), "description", 1, 1, 1.0, Instant.now());
	}

	public static Notification createNotification() {
		return new Notification(1L, "text", Instant.now(), false, "route", createUser());
	}

	public static Reply createReply() {
		return new Reply(1L, "body", Instant.now(), createTopic(), createUser());
	}

	public static Topic createTopic() {
		return new Topic(1L, "title", "body", Instant.now(), createUser(), createOffer(), createTask());
	}
}
