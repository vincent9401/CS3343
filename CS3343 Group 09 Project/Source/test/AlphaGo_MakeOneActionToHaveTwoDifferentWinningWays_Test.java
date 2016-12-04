import static org.junit.Assert.*;

import org.junit.Test;

public class AlphaGo_MakeOneActionToHaveTwoDifferentWinningWays_Test {
	
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public AlphaGo_MakeOneActionToHaveTwoDifferentWinningWays_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}

	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV1() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("C", nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV2() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",true );
		gameBoard.putTokenIntoGameBoard("E",true );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("F",false );
		gameBoard.putTokenIntoGameBoard("F",true );
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("D", nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV3() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("B",true );
		gameBoard.putTokenIntoGameBoard("C",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",true );
		gameBoard.putTokenIntoGameBoard("F",false );
		gameBoard.putTokenIntoGameBoard("F",true );
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("B", nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV4() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",true );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("B",true );
		gameBoard.putTokenIntoGameBoard("B",false );
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("C", nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV5() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals(null, nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV6() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("C",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("B",true );
		gameBoard.putTokenIntoGameBoard("B",false );
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		
		assertEquals(null, nextAction);
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV7() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("C",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("B",true );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("E",true );
		gameBoard.putTokenIntoGameBoard("E",false );
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("C", nextAction);
	}

	@Test
	public void testAlphaGoMakeOneActionToHaveTwoDifferentWinningWaysV8() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A",true );
		gameBoard.putTokenIntoGameBoard("C",true );
		gameBoard.putTokenIntoGameBoard("C",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("D",false );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("B",true );
		gameBoard.putTokenIntoGameBoard("B",false );
		gameBoard.putTokenIntoGameBoard("E",true );
		gameBoard.putTokenIntoGameBoard("E",false );
		gameBoard.putTokenIntoGameBoard("C",true );
		
		this._outputController.printGameBoard(gameBoard);
		String nextAction = this._alphaGo.MakeOneActionToHaveTwoDifferentWinningWays();
		System.out.println(nextAction);
		assertEquals("D", nextAction);
	}
}
