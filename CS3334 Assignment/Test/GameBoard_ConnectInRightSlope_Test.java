import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_ConnectInRightSlope_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public GameBoard_ConnectInRightSlope_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}
	
	

	@Test
	public void testConnectedInRightSlope_1() {
		
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult =  gameBoard.ConnectFourInRightSlope(GameInstances.PLAYER_TOKEN);
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(null, actualResult);
	}
	
	@Test
	public void testConnectedInRightSlope_2() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRightSlope(GameInstances.PLAYER_TOKEN);
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(2, actualResult.getStartRow());
		assertEquals(0, actualResult.getStartColumn());
		assertEquals(5, actualResult.getEndRow());
		assertEquals(3, actualResult.getEndColumn());
	}
	
	@Test
	public void testConnectedInRightSlope_3() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRightSlope(GameInstances.ROBOT_TOKEN);
//		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(1, actualResult.getStartRow());
		assertEquals(0, actualResult.getStartColumn());
		assertEquals(4, actualResult.getEndRow());
		assertEquals(3, actualResult.getEndColumn());
	}
	
	@Test
	public void testConnectedInRightSlope_4() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", true);

		
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRightSlope(GameInstances.ROBOT_TOKEN);
		//.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(0, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(3, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
	}
	
	@Test
	public void testConnectedInRightSlope_5() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRightSlope(GameInstances.ROBOT_TOKEN);
		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(2, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(5, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
	}
	

}
