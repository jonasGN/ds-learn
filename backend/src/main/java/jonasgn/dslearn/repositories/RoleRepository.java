package jonasgn.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jonasgn.dslearn.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
