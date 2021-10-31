package jonasgn.dslearn.repositories;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jonasgn.dslearn.entities.Deliver;
import jonasgn.dslearn.repositories.generics.CrudTests;
import jonasgn.dslearn.repositories.generics.CrudTestsConfig;

@DisplayName("Deliver repository tests")
@DataJpaTest
public class DeliverRepositoryTests extends CrudTests<DeliverRepository, Deliver> {

	private static CrudTestsConfig config = new CrudTestsConfig(1L, 1000L, 3L);

	@Autowired
	public DeliverRepositoryTests(DeliverRepository repository) {
		super(repository, config);
	}

}
