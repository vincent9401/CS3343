import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_ConnectFourInRow_Test {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	
	public GameBoard_ConnectFourInRow_Test(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
	}

	@Test
	public void testConnectedInRowV1() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		outputController.printGameBoard(gameBoard);
		
		assertEquals(null, gameBoard.ConnectFourInColumn(GameInstances.PLAYER_TOKEN));
	}
	
	@Test
	public void testConnectedInRowV2() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRow(GameInstances.PLAYER_TOKEN);
		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(5, actualResult.getStartRow());
		assertEquals(1, actualResult.getStartColumn());
		assertEquals(5, actualResult.getEndRow());
		assertEquals(4, actualResult.getEndColumn());
	}
	
	@Test
	public void testConnectedInRowV3() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRow(GameInstances.ROBOT_TOKEN);
		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(4, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(4, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
	}
	
	@Test
	public void testConnectedInRowV4() {
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();

		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		outputController.printGameBoard(gameBoard);
		
		ConnectedBlock actualResult = gameBoard.ConnectFourInRow(GameInstances.ROBOT_TOKEN);
		System.out.println(actualResult.getConnect_type()+" / "+actualResult.getStartRow()+" / "+actualResult.getStartColumn()+" / "+actualResult.getEndRow()+" / "+actualResult.getEndColumn() );
		
		assertEquals(4, actualResult.getStartRow());
		assertEquals(2, actualResult.getStartColumn());
		assertEquals(4, actualResult.getEndRow());
		assertEquals(5, actualResult.getEndColumn());
	}

}
