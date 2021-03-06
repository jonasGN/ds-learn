package jonasgn.dslearn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jonasgn.dslearn.entities.Notification;
import jonasgn.dslearn.entities.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	Page<Notification> findByUser(User user, Pageable pageable);

}
