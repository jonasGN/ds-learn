package jonasgn.dslearn.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public class AuthenticationError extends StandardError {

	private static final long serialVersionUID = 1L;

	public AuthenticationError(HttpStatus status, Exception error, HttpServletRequest request) {
		super(status, error, request);
	}

}
