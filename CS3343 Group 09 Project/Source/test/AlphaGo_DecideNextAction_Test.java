import static org.junit.Assert.*;

import org.junit.Test;

public class AlphaGo_DecideNextAction_Test {

	@Test
	public void testDecideNextActionV1() {
		// BlockPlayerWinByOneAction
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("C", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV2() {
		// BlockPlayerWinByOneAction
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("F", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV3() {
		// BlockPlayerWinByOneAction
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("F", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV4() {
		// BlockPlayerWinByOneAction
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("C", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV5() {
		// MakeOneActionToHaveTwoDifferentWinningWays
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("E", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV6() {
		// BlockPlayerMakeOneActionToHaveTwoDifferentWinningWays
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("E", alphaGo.decideNextAction());
	}
	
	@Test
	public void testDecideNextActionV7() {
		// MakeOneActionToHaveOneWinningWay
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		
		AlphaGo alphaGo = new AlphaGo(gameBoard);
		assertEquals("C", alphaGo.decideNextAction());
	}
}
