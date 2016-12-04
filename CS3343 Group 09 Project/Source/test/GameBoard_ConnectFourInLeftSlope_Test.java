import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_ConnectFourInLeftSlope_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	
	public GameBoard_ConnectFourInLeftSlope_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
	}
	
	@Test
	public void testConnectFourInLeftSlopeV1() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInLeftSlope(GameInstances.ROBOT_TOKEN);
		assertEquals(5, actualResult.getStartRow());
		assertEquals(3, actualResult.getStartColumn());
		assertEquals(2, actualResult.getEndRow());
		assertEquals(6, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
	}
	
	@Test
	public void testConnectFourInLeftSlopeV2() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", true);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInLeftSlope(GameInstances.ROBOT_TOKEN);
		assertEquals(null, actualResult);
	}
	
	@Test
	public void testConnectFourInLeftSlopeV3() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInLeftSlope(GameInstances.PLAYER_TOKEN);
		
		assertEquals(4, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(1, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
	}
	
	@Test
	public void testConnectFourInLeftSlopeV4() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInLeftSlope(GameInstances.PLAYER_TOKEN);

		assertEquals(3, actualResult.getStartRow());
		assertEquals(1, actualResult.getStartColumn());
		assertEquals(0, actualResult.getEndRow());
		assertEquals(4, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
	}

}
