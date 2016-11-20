import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameController {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	private AlphaGo _alphaGo;
	
	public GameController(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
		this._alphaGo = new AlphaGo(this._gameBoard);
	}
	
	public void setGameBoard(GameBoard gameBoard){
		this._gameBoard = gameBoard;
	}
	
	public boolean isPlayerFirst(){
		Random ran = new Random();
		int tmp = ran.nextInt(100)+1;
		
		if(tmp <= 50){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getColumnIndex(){
		while(true){
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			if(!Arrays.asList(GameInstances.COLUMN_NAME).contains(input)){
				this._outputController.printMessage(GameInstances.INCORRECT_COLUMN_INDEX);
			}
			else{
				return input;
			}
		} 
	}
	
	public void playGame(){
		GameBoard gameBoard = this._gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();
		
		boolean playerRound = this.isPlayerFirst();
		String message = playerRound ? GameInstances.PLAYER_FIRST : GameInstances.ROBOT_FIRST;
		outputController.printMessage(message);
		
		
		
		while((this.isWin() == 0) && !gameBoard.isGameBoardFull()){
			outputController.printGameBoard(gameBoard);
			String input;
			if(playerRound){// playerRound = true -> means that there is the human player round
				outputController.printMessage(GameInstances.INPUT_OPTION_MENU);
				input = this.getColumnIndex();
				outputController.printMessage(GameInstances.SHOW_INPUTED_COLUMN_INDEX + input+"\n");
				gameBoard.putTokenIntoGameBoard(input, true);
				playerRound = false;
			}
			else{// playerRound = false -> means that there is the robot round
				input = this._alphaGo.decideNextAction();
				gameBoard.putTokenIntoGameBoard(input, false);
				playerRound = true;
			}
		}
		
		outputController.printGameBoard(gameBoard);
		
	}
	
	public int isWin(){
		int result = 0;
		String[] tokens = {GameInstances.PLAYER_TOKEN, GameInstances.ROBOT_TOKEN};
		ConnectedBlock cb;
		for(int i = 0; i<tokens.length; i++){
			result = 0;
			cb =  this._gameBoard.ConnectFourInColumn(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this._gameBoard.ConnectFourInRow(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this._gameBoard.ConnectFourInRightSlope(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this._gameBoard.ConnectFourInLeftSlope(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			if(result>0){
				return result;
			}
			
		}
		
		return 0;
	}
}
