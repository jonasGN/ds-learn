package jonasgn.dslearn.services.exceptions;

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String defaultMsg = "You are not allowed to access this resource";

	public ForbiddenException() {
		super(defaultMsg);
	}

	public ForbiddenException(String msg) {
		super(msg);
	}

}
