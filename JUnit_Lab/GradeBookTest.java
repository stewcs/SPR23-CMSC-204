import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook GB1, GB2;
	

	@BeforeEach
	void setUp() throws Exception {
		
		GB1 = new GradeBook(5);
		GB1.addScore(1);
		GB1.addScore(2);
		GB1.addScore(3);
		
		GB2 = new GradeBook(5);
		GB2.addScore(5);
		GB2.addScore(6);
		GB2.addScore(7);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		GB1 = null;
		GB2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(GB1.toString().equals("1.0 2.0 3.0"));
		assertTrue(GB2.toString().equals("5.0 6.0 7.0"));
		assertEquals(3, GB1.getScoreSize());
		assertEquals(3, GB2.getScoreSize());
		
	}

	@Test
	void testSum() {
		assertEquals(6.0, GB1.sum());
		assertEquals(18.0, GB2.sum());
		
	}

	@Test
	void testMinimum() {
		assertEquals(1.0, GB1.minimum());
		assertEquals(5.0, GB2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(5.0, GB1.finalScore());
		assertEquals(13.0, GB2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3, GB1.getScoreSize());
		assertEquals(3, GB2.getScoreSize());
	}

	@Test
	void testToString() {
		assertEquals("1.0 2.0 3.0", GB1.toString());
		assertEquals("5.0 6.0 7.0", GB2.toString());
	}

}
