import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameController {
	
	private GameBoard gameBoard;
	private GameScreenOutputController _outputController;
	private static GameController instance = new GameController();
	
	public static GameController getInstance(){
		return instance;
	}
	
	private GameController(){
		this.gameBoard = GameBoard.getInstance();
		this._outputController = new GameScreenOutputController();
	}
	
	public void setGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
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
		AlphaGo AI = new AlphaGo();
		GameBoard gameBoard = this.gameBoard;
		GameScreenOutputController outputController = this._outputController;
		gameBoard.initializeGameBoard();
		
		boolean playerRound = this.isPlayerFirst();
		String message = playerRound ? GameInstances.PLAYER_FIRST : GameInstances.ROBOT_FIRST;
		outputController.printMessage(message);
		
		
		
		while((isWin()==0) && !gameBoard.isFull()){
			outputController.printGameBoard(gameBoard);
			String playerMove;
			String AI_Move;
			if(playerRound){// playerRound = true -> means that there is the human player round
				outputController.printMessage(GameInstances.INPUT_OPTION_MENU);
				playerMove = this.getColumnIndex();
				outputController.printMessage(GameInstances.SHOW_INPUTED_COLUMN_INDEX + playerMove+"\n");
				gameBoard.putTokenIntoGameBoard(playerMove, true);
				playerRound = false;
			}
			else{// playerRound = false -> means that there is the robot round
				
				AI_Move = AI.decideNextAction();
				
				if(AI_Move == null) System.out.println("FUCKMKT");
				
				System.out.println(AI_Move);
				
				System.out.println("before put token to board");
				this._outputController.printGameBoard(gameBoard);
				
				gameBoard.putTokenIntoGameBoard(AI_Move, false);
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
			cb =  this.gameBoard.connectFourInColumn(tokens[i], 3);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this.gameBoard.connectFourInRow(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this.gameBoard.connectFourInRightSlope(tokens[i]);
			if(!(cb == null)){
				result++;
			}
			
			cb =  this.gameBoard.connectFourInLeftSlope(tokens[i]);
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
