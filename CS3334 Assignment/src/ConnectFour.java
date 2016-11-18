import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
	public static boolean isWin = false;

	public static void main(String args[]) {

		
		GameController gameController = new GameController();
		gameController.playGame();
//		
//		
//		
//		
//		
//		
//		
//		Scanner sc = new Scanner(System.in);
//
//		// Use to find out who should take the turn
//		int counter = 0;
//
//		while (!gameBoard.isGameBoardFull()) {
//			
//			outputController.printGameBoard(gameBoard);
//			
			
//			if (counter % 2 == 0) {
//				System.out.println(ROUND);
//				token = playerToken;
//			} else {
//				System.out.println("Robot's turn!");
//				token = robotToken;
//			}
//			
//			System.out.print(GameInstances.INPUT_OPTION_MENU);
//			String inputColumn = sc.next();// TODO handle the incorrect input 
//			boolean isCorrectInput = true;
//			
//			
//			//while (isCorrectInput) {
//				sc.reset();
//				inputColumn = sc.next();
//				isCorrectInput = gameController.isCorrectColumnIndex(inputColumn);
//				//if(isCorrectInput){
//				//	outputController.printMessage(GameInstances.INCORRECT_COLUMN_INDEX);
//				//}
//			//}
//			System.out.println("Your input: " + inputColumn);
//			System.out.println();
//			gameBoard.putTokenIntoGameBoard(inputColumn, playerRound);
////			counter++;
//			break;
//		}
	}
	
}
	
	

