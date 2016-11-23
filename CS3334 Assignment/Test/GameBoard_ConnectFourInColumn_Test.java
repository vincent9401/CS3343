import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_ConnectFourInColumn_Test {
	
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	
	public GameBoard_ConnectFourInColumn_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
	}

	@Test
	public void testConnectedInColumn_1() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", true);
		outputController.printGameBoard(gameBoard);
		
		assertEquals(null, gameBoard.ConnectFourInColumn(GameInstances.PLAYER_TOKEN));
	}
	
	@Test
	public void testConnectedInColumn_2() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInColumn(GameInstances.PLAYER_TOKEN);
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		assertEquals(5, actualResult.getStartRow());
		assertEquals(1, actualResult.getStartColumn());
		assertEquals(2, actualResult.getEndRow());
		assertEquals(1, actualResult.getEndColumn());
		assertEquals(GameInstances.CONNECT_TYPE[0], actualResult.getConnect_type());
		
	}
	
	@Test
	public void testConnectedInColumn_3() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		outputController.printGameBoard(gameBoard);
		
		assertEquals(null, gameBoard.ConnectFourInColumn(GameInstances.PLAYER_TOKEN));
	}
	
	@Test
	public void testConnectedInColumn_4() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();
		
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		outputController.printGameBoard(gameBoard);

		ConnectedBlock actualResult = gameBoard.ConnectFourInColumn(GameInstances.PLAYER_TOKEN);
		//System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		assertEquals(4, actualResult.getStartRow());
		assertEquals(6, actualResult.getStartColumn());
		assertEquals(1, actualResult.getEndRow());
		assertEquals(6, actualResult.getEndColumn());
		assertEquals(GameInstances.CONNECT_TYPE[0], actualResult.getConnect_type());
	}

	@Test
	public void testConnectedInColumn_5() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();
		
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInColumn(GameInstances.ROBOT_TOKEN);
		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		assertEquals(5, actualResult.getStartRow());
		assertEquals(3, actualResult.getStartColumn());
		assertEquals(2, actualResult.getEndRow());
		assertEquals(3, actualResult.getEndColumn());
		assertEquals(GameInstances.CONNECT_TYPE[0], actualResult.getConnect_type());
	}

}
