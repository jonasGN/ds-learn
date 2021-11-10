package jonasgn.dslearn.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jonasgn.dslearn.dto.DeliverRevisionDTO;
import jonasgn.dslearn.entities.Deliver;
import jonasgn.dslearn.repositories.DeliverRepository;
import jonasgn.dslearn.services.exceptions.ResourceNotFoundException;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;

	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
	@Transactional
	public void saveRevision(Long deliverId, DeliverRevisionDTO dto) {
		try {
			Deliver deliver = repository.getById(deliverId);
			deliver.setStatus(dto.getStatus());
			deliver.setCorrectCount(dto.getCorrectCount());
			deliver.setFeedback(dto.getFeedback());
			repository.save(deliver);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(deliverId);
		}
	}

}
