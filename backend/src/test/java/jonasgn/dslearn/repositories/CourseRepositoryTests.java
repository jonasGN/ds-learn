package jonasgn.dslearn.repositories;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import jonasgn.dslearn.entities.Course;
import jonasgn.dslearn.repositories.generics.CrudTests;
import jonasgn.dslearn.repositories.generics.CrudTestsConfig;

@DisplayName("Course repository tests")
@DataJpaTest
public class CourseRepositoryTests extends CrudTests<CourseRepository, Course> {

	private static CrudTestsConfig config = new CrudTestsConfig(4L, 1000L, 2L);

	@Autowired
	public CourseRepositoryTests(CourseRepository repository) {
		super(repository, config);
	}

	@Test
	public void deleteShouldThrowDataIntegrityViolationExceptionWhenIdIsDependent() {
		assertThrows(DataIntegrityViolationException.class, () -> {
			super.getRepository().deleteById(config.getDependentId());
		});
	}

}
