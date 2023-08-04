package healthyhair.validation.exception;

public class InvalidProductException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -684733230564824295L;

	public InvalidProductException(String msg) {
		super(msg);
	}

	public InvalidProductException(Throwable e) {
		super(e);
	}
	public InvalidProductException(String msg,Throwable e) {
		super(msg,e);
	}
}
