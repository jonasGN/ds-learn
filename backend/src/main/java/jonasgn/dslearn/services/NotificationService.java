package jonasgn.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jonasgn.dslearn.dto.NotificationDTO;
import jonasgn.dslearn.entities.Notification;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public Page<NotificationDTO> getNotificationsOfCurrentUser(Pageable pageable) {
		final User user = authService.getAuthenticatedUser();
		final Page<Notification> page = repository.findByUser(user, pageable);

		return page.map(n -> new NotificationDTO(n));
	}

}
