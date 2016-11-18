import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
	public static boolean isWin = false;

	public static void main(String args[]) {

		GameBoard gameBoard = new GameBoard();
		GameController gameController = new GameController();
		GameScreenOutputController outputController = new GameScreenOutputController();
		
		gameBoard.initializeGameBoard();
		
		String message = gameController.isPlayerFirst() ? GameInstances.PLAYER_FIRST : GameInstances.ROBOT_FIRST;
		outputController.printMessage(message);
		
		Scanner sc = new Scanner(System.in);

		// Use to find out who should take the turn
		int counter = 0;

		while (!gameBoard.isGameBoardFull()) {
			
			outputController.printGameBoard(gameBoard);
			String token;
//			if (counter % 2 == 0) {
//				System.out.println("Player's turn!");
//				token = playerToken;
//			} else {
//				System.out.println("Robot's turn!");
//				token = robotToken;
//			}
//			
			System.out.print("Which column you want to input? (A-G): ");
//			String inputColumn = sc.next();
//			while (!Arrays.asList(GameBoard.COLUMN_NAME).contains(inputColumn)) {
//				System.out.print("Invalid column, input again!: ");
//				inputColumn = sc.next();
//			}
//			System.out.println("Your input: " + inputColumn);
//			System.out.println();
//			
//			putTokenIntoGameBoard(gameBoard, inputColumn, token);
//			counter++;
			break;
		}
	}

}
	
	

