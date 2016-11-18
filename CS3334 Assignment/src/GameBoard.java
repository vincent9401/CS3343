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
	
	public ConnectedBlock ConnectFourInColumn(String playerSymbol){
		int startColumn = -1;
		int startRow = -1;
		int endRow = -1;
		
		
		for(int column = 0; column < GameInstances.BOARD_COLUMN; column++){
			startColumn = column;
			for(int row = GameInstances.BOARD_ROW-1; row >= 0; row--){
				
				//System.out.println(" row : "+row+" column : "+column+" startRow : "+ startRow+" endRow : "+ endRow);
				
				if((this._gameBoard[row][column]).equals("*")){
					
					break;
				}
				else if((this._gameBoard[row][column]).equals(playerSymbol)){
					if(startRow < 0 ){
						startRow = row;
					}
					endRow = row;
				}
				else{
					startRow = -1;
					endRow = -1;
				}
				
				if((startRow - endRow) >= 3){
					ConnectedBlock cb = new ConnectedBlock(startRow, startColumn, endRow, startColumn, GameInstances.CONNECT_TYPE[0]);
					return cb;
				}
			}
		}
		
		return null;
	}
	
	public ConnectedBlock ConnectFourInRow(String playerSymbol){
		int startColumn = -1;
		int endColumn = -1;
		int startRow = -1;
		
		for(int row = GameInstances.BOARD_ROW-1; row >= 0; row--){
			startRow = row;	
			for(int column = 0; column < GameInstances.BOARD_COLUMN; column++){
				
				//System.out.println(" row : "+row+" column : "+column+" startRow : "+ startRow+" endRow : "+ startRow);
				
				if((this._gameBoard[row][column]).equals(playerSymbol)){
					if(startColumn < 0 ){
						startColumn = column;
					}
					endColumn = column;
				}
				else{
					startColumn = -1;
					endColumn = -1;
				}
				
				if((endColumn - startColumn) >= 3){
					ConnectedBlock cb = new ConnectedBlock(startRow, startColumn, startRow, endColumn, GameInstances.CONNECT_TYPE[1]);
					return cb;
				}
				
			}
		}
			
		return null;
	}
	
	
}
