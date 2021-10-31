package jonasgn.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jonasgn.dslearn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
