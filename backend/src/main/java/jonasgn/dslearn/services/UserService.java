package jonasgn.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User result = repository.findByEmail(username);
		if (result == null) {
			throw new UsernameNotFoundException("Email not found: " + username);
		}

		return result;
	}

}
