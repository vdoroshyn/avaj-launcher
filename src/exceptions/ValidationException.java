package src.exceptions;

public class ValidationException extends Exception {

	// @Override
	// public String getMessage() {
	// 	return "testing the exception";
	// }
	public ValidationException(String message) {
		super(message);
	}
}