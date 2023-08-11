package healthyhair.validation.exception;

public class InvalidProductInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5956902958042216122L;

	public InvalidProductInputException(String msg) {
		super(msg);
	}

	public InvalidProductInputException(Throwable e) {
		super(e);
	}

	public InvalidProductInputException(String msg, Throwable e) {
		super(msg, e);
	}
}
