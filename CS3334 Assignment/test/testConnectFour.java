import org.junit.Assert;
import org.junit.Test;

public class testConnectFour {

	@Test
	public void testIsNotGameBoardFull() {
		String[][] gameBoard = new String[5][5];
		ConnectFour.initializeGameBoard(gameBoard);
		boolean result = ConnectFour.isGameBoardFull(gameBoard);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void testIsGameBoardFull() {
		String[][] gameBoard = new String[5][5];
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = "X";
			}
		}
		boolean result = ConnectFour.isGameBoardFull(gameBoard);
		Assert.assertEquals(true, result);
	}

}
