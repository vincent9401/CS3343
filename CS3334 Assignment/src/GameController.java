import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameController {
	private GameBoard _gameBoard;
	private GameScreenOutputController _outputController;
	
	public GameController(){
		this._gameBoard = new GameBoard();
		this._outputController = new GameScreenOutputController();
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
		
		outputController.printGameBoard(gameBoard);
		
		if(playerRound){
			outputController.printMessage(GameInstances.INPUT_OPTION_MENU);
			String input = this.getColumnIndex();
			outputController.printMessage(GameInstances.SHOW_INPUTED_COLUMN_INDEX + input+"\n");
			gameBoard.putTokenIntoGameBoard(input, playerRound);
		}
		outputController.printGameBoard(gameBoard);
		
	}
}
