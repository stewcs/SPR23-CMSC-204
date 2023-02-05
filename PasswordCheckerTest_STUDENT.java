
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Daniel Xu
 * @version 2/4/2023
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords = new ArrayList<String>();
	String password1, password2;


	@Before
	public void setUp() throws Exception {
		String[] p = {"gIOdwa83", "SSiw84mmm1", "ha$NatIR", "MCDONALDS%149", "october5$", "xyp9xAST*", 
				"Stew2$", "egBEST@aRT", "Undertaking2%", "Aab22k$a23"};
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("hNt$1"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}


	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("october5$"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("MCDONALDS149"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Stew2$"));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException",false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("SSiw84mmm1$"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
	}

	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("egBEST@aRT$"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}

	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("xyp9xAST$"));
		}
		catch(Exception e)
		{
			assertTrue("Threw an exception",false);
		}
	}

	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.get(0), "gIOdwa83 The password must contain at least one special character");
		assertEquals(results.get(1), "SSiw84mmm1 The password must contain at least one special character");
		assertEquals(results.get(2), "ha$NatIR The password must contain at least one digit");
		assertEquals(results.get(3), "MCDONALDS%149 The password must contain at least one lowercase alphabetic character");
		assertEquals(results.get(4), "october5$ The password must contain at least one uppercase alphabetic character");

	}
}
