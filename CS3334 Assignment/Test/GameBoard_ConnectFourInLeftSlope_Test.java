import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_ConnectFourInLeftSlope_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public GameBoard_ConnectFourInLeftSlope_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}
	
	

	@Test
	public void test_1() {
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
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		assertEquals(5, actualResult.getStartRow());
		assertEquals(3, actualResult.getStartColumn());
		assertEquals(2, actualResult.getEndRow());
		assertEquals(6, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
		
	}
	
	@Test
	public void test_2() {
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
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(null, actualResult);
		
	}
	
	@Test
	public void test_3() {
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
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(4, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(1, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
		
	}
	
	@Test
	public void test_4() {
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
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(3, actualResult.getStartRow());
		assertEquals(1, actualResult.getStartColumn());
		assertEquals(0, actualResult.getEndRow());
		assertEquals(4, actualResult.getEndColumn());
		assertEquals("left_slope_connect", actualResult.getConnect_type());
		
	}

}