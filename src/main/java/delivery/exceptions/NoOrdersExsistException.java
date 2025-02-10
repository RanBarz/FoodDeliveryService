package delivery.exceptions;

public class NoOrdersExsistException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoOrdersExsistException(String msg) {
		super(msg);		
	}
}
