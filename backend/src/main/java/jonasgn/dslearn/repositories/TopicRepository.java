package jonasgn.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jonasgn.dslearn.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
