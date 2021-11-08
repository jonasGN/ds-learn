package jonasgn.dslearn.services.exceptions;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String defaultMsg = "Invalid user";

	public UnauthorizedException() {
		super(defaultMsg);
	}

	public UnauthorizedException(String msg) {
		super(msg);
	}

}
