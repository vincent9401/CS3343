import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
	public static boolean isWin = false;

	public static void main(String args[]) {
		String[][] gameBoard = new String[GameConstants.ROW][GameConstants.COLUMN];
		initializeGameBoard(gameBoard);
		System.out.println("Player starts the game first!");
		
		Scanner sc = new Scanner(System.in);
		String playerToken = "X";
		String robotToken = "O";
		// Use to find out who should take the turn
		int counter = 0;

		while (!isWin || !isGameBoardFull(gameBoard)) {
			printGameBoard(gameBoard, playerToken, robotToken);
			String token;
			if (counter % 2 == 0) {
				System.out.println("Player's turn!");
				token = playerToken;
			} else {
				System.out.println("Robot's turn!");
				token = robotToken;
			}
			
			System.out.print("Which column you want to input? (A-G): ");
			String inputColumn = sc.next();
			while (!Arrays.asList(GameConstants.COLUMN_NAME).contains(inputColumn)) {
				System.out.print("Invalid column, input again!: ");
				inputColumn = sc.next();
			}
			System.out.println("Your input: " + inputColumn);
			System.out.println();
			
			putTokenIntoGameBoard(gameBoard, inputColumn, token);
			counter++;
		}
	}

	public static void putTokenIntoGameBoard(String[][] gameBoard, String inputColumn, String playerToken) {
		// Check the game board from bottom row to top row
		for (int i = gameBoard.length - 1; i >= 0; i--) {
			int column = GameConstants.COLUMN_MAP.get(inputColumn);
			if(gameBoard[i][column].equals("*")) {
				gameBoard[i][column] = playerToken;
				break;
			}
		}
	}

	// Initialize the game board
	public static void initializeGameBoard(String[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = "*";
			}
		}
	}

	
	// Print out the game board
	public static void printGameBoard(String[][] gameBoard, String playToken, String robotToken) {
		System.out.println("Game Board:");
		System.out.println("Player = " + playToken + ", Robot = " + robotToken);
		System.out.println(" A B C D E F G");
		for (String[] row : gameBoard) {
			System.out.print("|");
			for (String field : row) {
				System.out.print(field + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Check whether the game board is full of tokens
	public static boolean isGameBoardFull(String[][] gameBoard) {
		for (String[] row : gameBoard) {
			for (String field : row) {
				if (field.equals("*")) {
					return false;
				}
			}
		}
		return true;
	}
}
