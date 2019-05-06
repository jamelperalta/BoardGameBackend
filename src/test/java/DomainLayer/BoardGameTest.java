package DomainLayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import DomainLayer.BoardGame;

/**
 * JUNIT for the class BoardGame.
 * @author jamelperaltacoss, jorgecruz
 *
 */
class BoardGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDescription() {
		String t = "Test Description";
		BoardGame bg = new BoardGame("Blood Rage", t, "test_url", "Area Control", "Test Description", 5, "Test Publisher", 90, 4, 1);
		assertTrue(bg.getDescription().equals(t));
	}

	@Test
	public void testSetDescription() {
		String t = "Test Description";
		BoardGame bg = new BoardGame("Blood Rage", "", "test_url", "Area Control", "Test Description", 5, "Test Publisher", 90, 4, 1);
		bg.setDescription(t);
		assertTrue(bg.getDescription().equals(t));
	}

	@Test
	public void testGetPhoto_url() {
		String t = "Test_url";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", t, "Area Control", "Test Description", 5, "Test Publisher", 90, 4, 1);
		assertTrue(bg.getPhoto_url().equals(t));
	}

	@Test
	public void testSetPhoto_url() {
		String t = "Test url";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "", "Area Control", "Test Description", 5, "Test Publisher", 90, 4, 1);
		bg.setPhoto_url(t);
		assertTrue(bg.getPhoto_url().equals(t));
	}

	@Test
	public void testGetCategory_name() {
		String t = "Test Category";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", t, "Test Description", 5, "Test Publisher", 90, 4, 1);
		assertTrue(bg.getCategory_name().equals(t));
	}

	@Test
	public void testSetCategory_name() {
		String t = "Test Cat";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "", "Test Description", 5, "Test Publisher", 90, 4, 1);
		bg.setCategory_name(t);
		assertTrue(bg.getCategory_name().equals(t));
	}

	@Test
	public void testGetCategory_desc() {
		String t = "Test Category";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", t, 5, "Test Publisher", 90, 4, 1);
		assertTrue(bg.getCategory_desc().equals(t));
	}

	@Test
	public void testSetCategory_desc() {
		String t = "Test Cat Des";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "", 5, "Test Publisher", 90, 4, 1);
		bg.setCategory_desc(t);
		assertTrue(bg.getCategory_desc().equals(t));
	}

	@Test
	public void testGetQuantity() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", t, "Test Publisher", 90, 4, 1);
		assertTrue(bg.getQuantity() == t);
	}

	@Test
	public void testSetQuantity() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 0, "Test Publisher", 90, 4, 1);
		bg.setQuantity(t);
		assertTrue(bg.getQuantity() == t);
	}

	@Test
	public void testGetPublisher() {
		String t = "Test Publisher";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 5, t, 90, 4, 1);
		assertTrue(bg.getPublisher().equals(t));
	}

	@Test
	public void testSetPublisher() {
		String t = "Test Publisher";
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "est Description", 5, "", 90, 4, 1);
		bg.setPublisher(t);
		assertTrue(bg.getPublisher().equals(t));
	}

	@Test
	public void testGetAverage_playtime() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 5, "Test Publisher", t, 4, 1);
		assertTrue(bg.getAverage_playtime() == t);
	}

	@Test
	public void testSetAverage_playtime() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 5, "Test Publisher", 0, 4, 1);
		bg.setAverage_playtime(t);
		assertTrue(bg.getAverage_playtime() == t);
	}

	@Test
	public void testGetMax_player() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 5, "Test Publisher", 90, t, 1);
		assertTrue(bg.getMax_player() == t);
	}

	@Test
	public void testSetMax_player() {
		int t = 5;
		BoardGame bg = new BoardGame("Blood Rage", "Test Description", "test_url", "Area Control", "Test Description", 5, "Test Publisher", 90, t, 1);
		bg.setMax_player(t);
		assertTrue(bg.getMax_player() == t);
	}

}
