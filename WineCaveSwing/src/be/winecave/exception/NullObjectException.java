package be.winecave.exception;

@SuppressWarnings("serial")
public class NullObjectException extends RuntimeException {

	public NullObjectException(String message) {
		super(message);
	}
}
