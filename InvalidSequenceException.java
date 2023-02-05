
public class InvalidSequenceException extends Exception {

	public InvalidSequenceException() {
		this("The password cannot contain more than two of the same character in sequence.");
	}
	
	public InvalidSequenceException(String message) {
		super(message);
	}
}
