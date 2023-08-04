package healthyhair.DAO.exception;

public class DAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7992770616479275262L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable e) {
		super(e);
	}

	public DAOException(String msg, Throwable e) {
		super(msg, e);
	}

}
