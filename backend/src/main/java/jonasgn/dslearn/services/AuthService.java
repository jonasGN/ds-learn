package jonasgn.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jonasgn.dslearn.entities.User;
import jonasgn.dslearn.entities.enums.Authority;
import jonasgn.dslearn.repositories.UserRepository;
import jonasgn.dslearn.services.exceptions.ForbiddenException;
import jonasgn.dslearn.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User getAuthenticatedUser() {
		try {
			final SecurityContext context = SecurityContextHolder.getContext();
			final String userName = context.getAuthentication().getName();

			return userRepository.findByEmail(userName);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

	public void validateSelfOrAdmin(Long userId) {
		final User user = getAuthenticatedUser();

		if (!user.getId().equals(userId) && !user.hasRole(Authority.ADMIN)) {
			throw new ForbiddenException();
		}
	}
}
