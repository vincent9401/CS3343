import static org.junit.Assert.*;

import org.junit.Test;

public class AlphaGo_WinByOneAction_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public AlphaGo_WinByOneAction_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}

	@Test
	public void test_1() {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		boolean result = gameBoard.putTokenIntoGameBoard("A", true);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", true);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", false);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", true);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", false);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", true);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(true, result);
		
		result = gameBoard.putTokenIntoGameBoard("A", false);
		this._outputController.printGameBoard(gameBoard);
		assertEquals(false, result);
	}

	@Test
	public void test_2() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.WinByOneAction();
		System.out.println(nextAction);
		assertEquals("B", nextAction);
	}
	
	
	@Test
	public void test_3() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.WinByOneAction();
		System.out.println(nextAction);
		assertEquals("G", nextAction);
	}
	
	@Test
	public void test_4() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.WinByOneAction();
		System.out.println(nextAction);
		assertEquals(null, nextAction);
	}
	
	
	@Test
	public void test_5() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.WinByOneAction();
		System.out.println(nextAction);
		assertEquals("C", nextAction);
	}
	
	
}
