package jonasgn.dslearn.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String defaultMsg = "Couldn't find this resource";

	public ResourceNotFoundException() {
		super(defaultMsg);
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	public ResourceNotFoundException(Long id) {
		super(defaultMsg + ", by the given ID: " + id);
	}

}
