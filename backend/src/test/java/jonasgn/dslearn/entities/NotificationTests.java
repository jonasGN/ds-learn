package jonasgn.dslearn.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jonasgn.dslearn.entities.generics.EntityTests;
import jonasgn.dslearn.factories.EntitiesFactory;

@DisplayName("Notification entity tests")
public class NotificationTests implements EntityTests<Notification> {

	private Notification notification = EntitiesFactory.createNotification();
	private Notification expected = new Notification(0L, "foo", Instant.now(), true, "foo", new User());

	@Test
	public void emptyConstructorShouldSetAllWrapperPropertiesToNull() {
		final Notification notification = new Notification();

		assertNull(notification.getId());
		assertNull(notification.getMoment());
		assertNull(notification.getRoute());
		assertNull(notification.getText());
		assertNull(notification.getUser());
	}

	@Test
	public void argsConstructorShouldSetAndGetterShouldRetriveAllProperties() {
		final Notification n = expected;
		final Notification notification = new Notification(n.getId(), n.getText(), n.getMoment(), n.isRead(),
				n.getRoute(), n.getUser());

		compareProperties(n, notification);
	}

	@Test
	public void notificationsShouldBeTheSameWhenIdIsEqual() {
		expected.setId(notification.getId());

		verifyEquality(expected, notification);
	}

	@Test
	public void notificationsShouldBeDifferentWhenIdIsNotEqual() {
		verifyDifference(expected, notification);
	}

	@Test
	public void setterShouldSetProperties() {
		notification.setId(expected.getId());
		notification.setMoment(expected.getMoment());
		notification.setRead(expected.isRead());
		notification.setRoute(expected.getRoute());
		notification.setText(expected.getText());
		notification.setUser(expected.getUser());

		compareProperties(expected, notification);
	}

	private void compareProperties(Notification expected, Notification actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getMoment(), actual.getMoment());
		assertEquals(expected.getRoute(), actual.getRoute());
		assertEquals(expected.getText(), actual.getText());
		assertEquals(expected.getUser(), actual.getUser());
	}

}
