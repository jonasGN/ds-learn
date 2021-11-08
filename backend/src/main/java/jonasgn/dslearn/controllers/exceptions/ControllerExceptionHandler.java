package jonasgn.dslearn.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jonasgn.dslearn.services.exceptions.ForbiddenException;
import jonasgn.dslearn.services.exceptions.ResourceNotFoundException;
import jonasgn.dslearn.services.exceptions.UnauthorizedException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> notFound(ResourceNotFoundException e, HttpServletRequest request) {
		final StandardError error = new StandardError(HttpStatus.NOT_FOUND, e, request);

		return error.toJsonResponse();
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<StandardError> forbidden(ForbiddenException e, HttpServletRequest request) {
		final AuthenticationError error = new AuthenticationError(HttpStatus.FORBIDDEN, e, request);

		return error.toJsonResponse();
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<StandardError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
		final AuthenticationError error = new AuthenticationError(HttpStatus.UNAUTHORIZED, e, request);

		return error.toJsonResponse();
	}

}
