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
		
		
		
		while(!this.isWin(gameBoard) && !gameBoard.isGameBoardFull()){
			outputController.printGameBoard(gameBoard);
		
			if(playerRound){// playerRound = true -> means that there is the human player round
				outputController.printMessage(GameInstances.INPUT_OPTION_MENU);
				String input = this.getColumnIndex();
				outputController.printMessage(GameInstances.SHOW_INPUTED_COLUMN_INDEX + input+"\n");
				gameBoard.putTokenIntoGameBoard(input, playerRound);
				outputController.printGameBoard(gameBoard);

				
				break;
			}
			else{// playerRound = flase -> means that there is the robot round
				//TODO
			}
		}
		
	}
	
	public boolean isWin(GameBoard gameBoard){
		return false;//TODO
	}
}
