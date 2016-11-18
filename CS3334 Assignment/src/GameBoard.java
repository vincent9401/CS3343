import java.util.HashMap;
import java.util.Map;

public class GameBoard {
	
			
		private String[][] _gameBoard;
			
	public GameBoard(){
		String[][] gameBoard = new String[GameInstances.BOARD_ROW][GameInstances.BOARD_COLUMN];
		this._gameBoard = gameBoard;
	}
	

	public void initializeGameBoard() {
		for (int i = 0; i < this._gameBoard.length; i++) {
			for (int j = 0; j < this._gameBoard[i].length; j++) {
				this._gameBoard[i][j] = "*";
			}
		}
		
	}
	
	// Put a token into the game board
	public void putTokenIntoGameBoard(String inputColumn, boolean playerRound) {
		// boolean playerRound 
		// player = true -> human player round
		// player = false -> robot round
		String playerToken = playerRound ? GameInstances.PLAYER_TOKEN : GameInstances.ROBOT_TOKEN;
			
		for(int i =  this._gameBoard.length -1; i >= 0; i--){
			int column = GameInstances.COLUMN_MAP.get(inputColumn);
			if(this._gameBoard[i][column].equals("*")) {
				this._gameBoard[i][column] = playerToken;
				break;
			}
		}
			
	}
	
	public String[][] getGameBoard(){
		return this._gameBoard;
	}
	
	// Check whether the game board is full of tokens
	public boolean isGameBoardFull() {
		String[][] gameBoardInstance =  this._gameBoard;
		for (String[] row : gameBoardInstance) {
			for (String field : row) {
				if (field.equals("*")) {
					return false;
				}
			}
		}
		return true;
	}
}
