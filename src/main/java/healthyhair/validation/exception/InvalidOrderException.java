package healthyhair.validation.exception;

public class InvalidOrderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public InvalidOrderException(String msg) {
		super(msg);
	}

	public InvalidOrderException(Throwable e) {
		super(e);
	}

	public InvalidOrderException(String msg, Throwable e) {
		super(msg, e);
	}
}
