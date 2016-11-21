import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AlphaGo_PosibleSeconTokenInput_test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public AlphaGo_PosibleSeconTokenInput_test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}

	@Test
	public void test_1() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		this._outputController.printGameBoard(gameBoard);
		List result = this._alphaGo.posibleSeconTokenInput();
	
		assertEquals("A", result.get(0));
		assertEquals("B", result.get(1));
		assertEquals("C", result.get(2));
		assertEquals("D", result.get(3));
	}
	
	@Test
	public void test_2() throws CloneNotSupportedException {
		GameBoard gameBoard = this._gameBoard;
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		this._outputController.printGameBoard(gameBoard);
		List result = this._alphaGo.posibleSeconTokenInput();
	
		assertEquals("C", result.get(0));
		assertEquals("D", result.get(1));
	}

}
