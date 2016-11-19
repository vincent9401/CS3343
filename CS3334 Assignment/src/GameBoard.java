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
		// When player = true -> human player round
		// When player = false -> robot round
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
	
	public ConnectedBlock ConnectFourInRightSlope(String playerSymbol){
		final int INIT_CHECKING_ROW = GameInstances.BOARD_ROW-1;
		final int INIT_CHECKING_COLUMN = 0;
		final int FINAL_CHECK_ROW = 0;
		final int FINAL_CHECK_COLUMN = GameInstances.BOARD_COLUMN-1;
		
		int currentRow = INIT_CHECKING_ROW;
		int currentColumn = INIT_CHECKING_COLUMN;
		boolean isContinue = true;  
		
		while(isContinue){
			
			//System.out.println("");
			//System.out.println("Outer_Row: "+currentRow +" Outer_Column: "+ currentColumn);

			
			int innerRow = currentRow;
			int innerColumn = currentColumn;
			int startRow = -1;
			int startColumn = -1;
			int endRow =1;
			int endColumn = -1;
			
			while((innerRow < GameInstances.BOARD_ROW) && (innerColumn < GameInstances.BOARD_COLUMN)){
				
				//System.out.println("inner_Row: " + innerRow +" inner_column: "+innerColumn);
				
				if((this._gameBoard[innerRow][innerColumn]).equals(playerSymbol)){
					if(startColumn < 0 ){
						startRow = innerRow;
						startColumn = innerColumn;
					}
					endRow = innerRow;
					endColumn = innerColumn;
				}
				else{
					startRow = -1;
					startColumn= -1;
					endRow = -1;
					endColumn = -1;
				}
				//System.out.println("Star_Row: "+startRow +" Start_Column: "+ startColumn+" End_Row: "+endRow+" End_column: "+endColumn);
				
				int difference = endRow - startRow;
				difference = (difference > 0) ? difference : -difference;
				if(difference >= 3){
					ConnectedBlock cb = new ConnectedBlock(startRow, startColumn, endRow, endColumn, GameInstances.CONNECT_TYPE[2]);
					return cb;
				}
				
				innerRow++;
				innerColumn++;
			}
				
			currentRow--;
			
			if( currentRow < 0){
				currentRow = FINAL_CHECK_ROW;
				currentColumn++;
			}
			
			isContinue = !(currentColumn >= FINAL_CHECK_COLUMN );	
		}
			
		return null;
	}
	
	
	public ConnectedBlock ConnectFourInLeftSlope(String playerSymbol){
		final int INIT_CHECKING_ROW = 0;
		final int INIT_CHECKING_COLUMN = 0;
		final int FINAL_CHECK_ROW = GameInstances.BOARD_ROW-1;
		final int FINAL_CHECK_COLUMN = GameInstances.BOARD_COLUMN-1;
		
		int currentRow = INIT_CHECKING_ROW;
		int currentColumn = INIT_CHECKING_COLUMN;
		boolean isContinue = true;  
		
		
		while(isContinue){
			
			//System.out.println("");
			//System.out.println("Outer_Row: "+currentRow +" Outer_Column: "+ currentColumn);

			
			int innerRow = currentRow;
			int innerColumn = currentColumn;
			int startRow = -1;
			int startColumn = -1;
			int endRow =1;
			int endColumn = -1;
			
			while((innerRow >= 0) && (innerColumn < GameInstances.BOARD_COLUMN)){
				
				//System.out.println("inner_Row: " + innerRow +" inner_column: "+innerColumn);
				
				if((this._gameBoard[innerRow][innerColumn]).equals(playerSymbol)){
					if(startColumn < 0 ){
						startRow = innerRow;
						startColumn = innerColumn;
					}
					endRow = innerRow;
					endColumn = innerColumn;
				}
				else{
					startRow = -1;
					startColumn= -1;
					endRow = -1;
					endColumn = -1;
				}
				//System.out.println("Star_Row: "+startRow +" Start_Column: "+ startColumn+" End_Row: "+endRow+" End_column: "+endColumn);
				
				int difference = endRow - startRow;
				difference = (difference > 0) ? difference : -difference;
				if(difference >= 3){
					ConnectedBlock cb = new ConnectedBlock(startRow, startColumn, endRow, endColumn, GameInstances.CONNECT_TYPE[3]);
					return cb;
				}
				
				innerRow--;
				innerColumn++;
			}
				
			currentRow++;
			
			if( currentRow > FINAL_CHECK_ROW){
				currentRow = FINAL_CHECK_ROW;
				currentColumn++;
			}
			
			isContinue = !(currentColumn >= FINAL_CHECK_COLUMN );	
		}
			
		return null;
	}
	
	
}
