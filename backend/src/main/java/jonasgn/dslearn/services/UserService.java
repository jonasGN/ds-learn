package jonasgn.dslearn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jonasgn.dslearn.dto.UserDTO;
import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.repositories.UserRepository;
import jonasgn.dslearn.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		final Optional<User> result = repository.findById(id);
		final User entity = result.orElseThrow(() -> new ResourceNotFoundException(id));

		return new UserDTO(entity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User result = repository.findByEmail(username);
		if (result == null) {
			throw new UsernameNotFoundException("Email not found: " + username);
		}

		return result;
	}

}
