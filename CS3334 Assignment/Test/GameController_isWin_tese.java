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
		boolean actualResult = this._controller.isWin();
		
		assertEquals(false, actualResult);
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
		boolean actualResult = this._controller.isWin();
		
		assertEquals(true, actualResult);
	}
	
	

}
