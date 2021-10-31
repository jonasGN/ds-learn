package jonasgn.dslearn.repositories.generics;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudTests<R extends JpaRepository<T, Long>, T> {

	private R repository;
	private CrudTestsConfig config;

	public CrudTests(R repository, CrudTestsConfig config) {
		this.repository = repository;
		this.config = config;
	}

	@Test
	public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
		fail("Not implemented yet");
	}

	@Test
	public void saveShouldUpdateWhenIdExists() {
		fail("Not implemented yet");
	}

	@Test
	public void findByIdShouldReturnEntityWhenIdExists() {
		final Optional<T> entity = repository.findById(config.getExistingId());

		assertTrue(entity.isPresent());
	}

	@Test
	public void findByIdShouldBeEmptyWhenIdDoesNotExist() {
		final Optional<T> entity = repository.findById(config.getNonExistingId());

		assertTrue(entity.isEmpty());
	}

	@Test
	public void deleteByIdShouldDeleteWhenIdExists() {
		final long id = config.getExistingId();

		repository.deleteById(id);
		final Optional<T> entity = repository.findById(id);

		assertTrue(entity.isEmpty());
	}

	@Test
	public void deleteByIdShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
		assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(config.getNonExistingId());
		});
	}

	public R getRepository() {
		return repository;
	}

	public CrudTestsConfig getConfig() {
		return config;
	}

}
