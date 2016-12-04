import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AlphaGo_MakeOneActionToHaveOnetWinningWay_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public AlphaGo_MakeOneActionToHaveOnetWinningWay_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}

	@Test
	public void testAlphaGoMakeOneActionToHaveOnetWinningWayV1() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", true);

		this._outputController.printGameBoard(gameBoard);
		List<String> actualResult = this._alphaGo.MakeOneActionToHaveOneWinningWay();

		assertEquals("A", actualResult.get(0));
		assertEquals("C", actualResult.get(1));
		assertEquals("D", actualResult.get(2));
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveOnetWinningWayV2() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("B", false);

		this._outputController.printGameBoard(gameBoard);
		List<String> actualResult = this._alphaGo.MakeOneActionToHaveOneWinningWay();

		assertEquals("A", actualResult.get(0));
		assertEquals("C", actualResult.get(1));
		assertEquals("D", actualResult.get(2));
	}
	
	@Test
	public void testAlphaGoMakeOneActionToHaveOnetWinningWayV3() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", false);

		this._outputController.printGameBoard(gameBoard);
		List<String> actualResult = this._alphaGo.MakeOneActionToHaveOneWinningWay();

		assertEquals("D", actualResult.get(0));
	}

}
