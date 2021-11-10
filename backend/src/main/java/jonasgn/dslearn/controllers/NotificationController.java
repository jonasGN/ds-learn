package jonasgn.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonasgn.dslearn.dto.NotificationDTO;
import jonasgn.dslearn.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

	@Autowired
	private NotificationService service;

	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> getNotificationOfCurrentUser(Pageable pageable) {
		final Page<NotificationDTO> result = service.getNotificationsOfCurrentUser(pageable);

		return ResponseEntity.ok(result);
	}
}
