
public class GameScreenOutputController {

	public void printMessage(String message){
		System.out.println(message);
	}
	
	// Print out the game board
	public void printGameBoard(GameBoard gameBoard) {
		// String[][] gameBoard, String playToken, String robotToken
		String[][] gameBoardInstance = gameBoard.getGameBoard();
		
		System.out.println("Game Board:");
		System.out.println("Player = " + GameInstances.PLAYER_TOKEN + ", Robot = " + GameInstances.ROBOT_TOKEN);
		System.out.println(" A B C D E F G");
		for (String[] row : gameBoardInstance) {
			System.out.print("|");
			for (String field : row) {
				System.out.print(field + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
}
