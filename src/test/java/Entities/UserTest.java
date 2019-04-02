package Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * JUNIT for the class BoardGame.
 * @author jamelperaltacoss, jorgecruz
 *
 */
class UserTest {
	
	// Testing Constructor.
	
	/* Two clones should be equals */
	@Test
	public void testTwoClonesEqual() {
		User user1 = new User("1", "1", "1");
		User user2 = new User("1", "1", "1");
		assertTrue(user1.equals(user2));
	}
	
	/* A user and an object are not equal */
	@Test
	public void testNonUserEquals() {
		Object obj = new Object();
		User user = new User("1", "1", "1");
		assertFalse(user.equals(obj));
	}
	
	/* equals is reflexive */
	@Test
	public void testReflexiveness() {
		User user1 = new User("1", "1", "1");
		assertTrue(user1.equals(user1));
	}
	
	/* Two objects with at least one different property are not equals */
	@Test
	public void testNotEqualWhenOneAttrDiff() {
		User user1 = new User("1", "1", "1");
		User user2 = new User("0", "0", "0");
		assertFalse(user1.equals(user2));
	}
	
}
