package tp;

public class IllegalParamException extends RuntimeException {
//public class IllegalParamException extends Exception {

	public IllegalParamException(String message) {
		super(message);
	}


	public IllegalParamException(String message, Throwable cause) {
		super(message, cause);
	}

}
