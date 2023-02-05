import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for the Password GUI.
 * @author Daniel Xu
 * @version 2/4/2023
 */

public class PasswordCheckerUtility {

	/**
	 * Compare equality of two passwords.
	 * @param password string to be checked for 				
	 * @param passwordConfirm string to be checked against password for
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

		if(password.equals(passwordConfirm)) { // if passwords aren't the same length
			//
		}
		else {
			throw new UnmatchedException("Passwords do not match");
		}


	}



	/**
	 * Compare equality of two passwords.
	 * @param password string to be checked for
	 * @param passwordConfirm string to be checked against password for
	 * @return true if the passwords are the same, false if they are not.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(!password.equals(passwordConfirm)) // if passwords aren't the same size 
			return false;
		for(int i = 0; i < password.length(); i++) {
			int pass1 = (int)password.charAt(i);
			int pass2 = (int)passwordConfirm.charAt(i);

			if(pass1 != pass2) // if the corresponding characters between the two strings are not the same.
				return false;
		}
		return true; // if the passwords are the same
	}

	/**
	 * Checks the password length requirement - The password must be at least 6 characters long.
	 * @param password string to be checked for length
	 * @return true if the password is valid length, false if it is not
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {

		if(password.length() >= 6)
			return true;
		else 
			throw new LengthException("The password must be at least 6 characters long");
	}

	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password string to be checked for upperCase requirement
	 * @return true if meets upperCase requirement, false if not.
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		boolean hasUpperAlpha = false;
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isUpperCase(c)) 
				hasUpperAlpha = true;
		}
		if (hasUpperAlpha == true)
			return true;
		else
			throw new NoUpperAlphaException();
	}

	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password string to be checked for lowerCase requirement
	 * @return true if meets lowerCase requirement, false if not.
	 * @throws NoLowerAlphaException
	 */

	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException {
		boolean hasLowerAlpha = false;
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isLowerCase(c)) 
				hasLowerAlpha = true;
		}
		if (hasLowerAlpha == true)
			return true;
		else
			throw new NoLowerAlphaException();
	}

	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException
	 */
	public static boolean hasDigit​(String password) throws NoDigitException {
		boolean hasDigit = false;
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if(Character.isDigit(c))
				hasDigit = true;
		}
		if (hasDigit == true)
			return true;
		else
			throw new NoDigitException();
	}
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password string to be checked for SpecialCharacter requirement
	 * @return true if meets SpecialCharacter requirement, false if it does not.
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;



	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {

		for(int i = 0; i < password.length()-2; i++) {
			char c1 = password.charAt(i);
			char c2 = password.charAt(i+1);
			char c3 = password.charAt(i+2);
			if(c1 == c2 && c1 == c3)
				throw new InvalidSequenceException();
		}
		return true;
	}

	/**
	 * Return true if valid password (follows all the following rules), returns false if an invalid password.
	 * 1. At least 6 characters long.
	 * 2. At least 1 numeric character.
	 * 3. At least 1 uppercase alphabetic character.
	 * 4. At least 1 lowercase alphabetic character.
	 * 5. At least 1 special character.
	 * 6. No more than 2 of the same character in a sequence.
	 * @param password string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	public static boolean isValidPassword(String password) throws 
	LengthException, 
	NoUpperAlphaException, 
	NoLowerAlphaException, 
	NoDigitException, 
	NoSpecialCharacterException, 
	InvalidSequenceException 
	{

		if ((isValidLength(password)) && (hasDigit​(password)) && (hasUpperAlpha(password)) && (hasLowerAlpha​(password))
				&& (hasSpecialChar(password)) && (NoSameCharInSequence(password)))
			return true;
		else
			return false;
	}

	/**
	 * Checks if the password contains 6 to 9 characters
	 * @param password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(String password) {	

		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param string to be checked if weak password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	NoDigitException, NoSpecialCharacterException, InvalidSequenceException{

		if(isValidPassword(password) && hasBetweenSixAndNineChars​(password)) {
			throw new WeakPasswordException();
		}
		return false;
	}

	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList 
	 * with the status of any invalid passwords (weak passwords are not considered invalid).
	 * @param list of passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){

		// create new ArrayList
		ArrayList<String> invalidPasswords = new ArrayList<String>();

		for(int i = 0; i < passwords.size(); i++) {
			String currentPassword = passwords.get(i); // get the next password 
			try {
				if(isValidPassword(currentPassword));	// checks if the password is valid
				
			} catch	(LengthException a) {
				invalidPasswords.add(currentPassword + " " + a.getMessage());
			} catch	(NoUpperAlphaException b) {
				invalidPasswords.add(currentPassword + " " + b.getMessage());
			} catch	(NoLowerAlphaException c) {
				invalidPasswords.add(currentPassword + " " + c.getMessage());
			} catch	(NoDigitException d) {
				invalidPasswords.add(currentPassword + " " + d.getMessage());
			} catch	(NoSpecialCharacterException e) {
				invalidPasswords.add(currentPassword + " " + e.getMessage());
			} catch	(InvalidSequenceException f) {
				invalidPasswords.add(currentPassword + " " + f.getMessage());
			}	
		}
		return invalidPasswords;
	}
	
}
