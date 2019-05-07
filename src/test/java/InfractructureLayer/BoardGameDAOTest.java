package InfractructureLayer;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import DomainLayer.BoardGame;
import InfrastructureLayer.BoardGameDAO;

/**
 * JUNIT for the class BoardGameDAOTest.
 * @author jamelperaltacoss, jorgecruz
 *
 */
class BoardGameDAOTest {

	/*
	 * This test class assumes that the following
	 * are free of defect:
	 * + getInSaleBoardgame
	 * + equalTo from BoardGame Class
	 * 
	 */
	
	/*
	 * A integration test to check if you edit a boardgame
	 * it should not be the same as the previous iteration.
	 */
	@Test
	void testEditBoardGame() {
		
		// Prepare Dao
		BoardGameDAO dao = new BoardGameDAO();
		boolean same = true;
		
		try {
			// Get a boardgame from database
			BoardGame originalBG = dao.getInSaleBoardgame(1);
			
			// Change value from database
			dao.modifyBoardGameByid(originalBG.getBg_id(), "TestDesc", "TestDesc", 2.2f, 15);
			
			// Get the modify boardgame from database
			BoardGame modifyBG = dao.getInSaleBoardgame(originalBG.getBg_id());
			
			// Compare old and new
			same = originalBG.equals(modifyBG);
			
			// Change back to original
			dao.modifyBoardGameByid(originalBG.getBg_id(), originalBG.getDescription(),
					originalBG.getPublisher(), originalBG.getAverage_playtime(),
					originalBG.getMax_player());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Must be different
		assertFalse(same);
	}
	
	
	
	
	

}
