package be.winecave.exception;

@SuppressWarnings("serial")
public class NonImplementedException extends RuntimeException {
	
	public NonImplementedException() {
		this("");
	}
	
	public NonImplementedException(String feature) {
		super("this feature " + feature + " is non implemented yet");
	}

}
