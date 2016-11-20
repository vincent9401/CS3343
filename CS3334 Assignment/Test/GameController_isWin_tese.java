import static org.junit.Assert.*;

import org.junit.Test;

public class GameController_isWin_tese {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	private GameController _controller;
	
	public GameController_isWin_tese(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
		this._controller = new GameController();
	}

	@Test
	public void test_1() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);		
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(0, actualResult);
	}
	
	@Test
	public void test_2() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", true);	
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(1, actualResult);
	}

	@Test
	public void test_3() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(1, actualResult);
	}
	
	@Test
	public void test_4() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();

		assertEquals(0, actualResult);
	}
	
	@Test
	public void test_5() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(1, actualResult);
	}
	
	@Test
	public void test_6() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(1, actualResult);
	}
	
	@Test
	public void test_7() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);	
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		
		outputController.printGameBoard(gameBoard);
		
		this._controller.setGameBoard(gameBoard);
		int actualResult = this._controller.isWin();
		
		assertEquals(1, actualResult);
	}

}
