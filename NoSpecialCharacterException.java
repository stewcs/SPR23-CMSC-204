
public class NoSpecialCharacterException extends Exception {

	public NoSpecialCharacterException() {
		this("The password must contain at least one special character");
	}
	
	public NoSpecialCharacterException(String message) {
		super(message);
	}
	
}
