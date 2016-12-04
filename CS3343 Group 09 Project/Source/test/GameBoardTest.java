import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameBoardTest {
	private PrintStream oldPrintStream;
	private ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() {
		System.setOut(oldPrintStream);
		return bos.toString();
	}

	@Test
	public void testInitializeGameBoard() throws Exception {
		setOutput();
		
		GameScreenOutputController gsoc = new GameScreenOutputController();
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gsoc.printGameBoard(gameBoard);
		
		String expectResult = "Game Board:\n"
							+ "Player = X, Robot = O\n"
							+ " A B C D E F G\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n\n";

		assertEquals(expectResult, getOutput());
	}
	
	@Test
	public void testRemoveTokenOnGameBoard() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		boolean expectResult = gameBoard.removeTokenOnGameBoard("A");

		assertEquals(expectResult, true);
	}

	@Test
	public void testPutTokenIntoGameBoard() throws Exception {
		setOutput();
		
		GameScreenOutputController gsoc = new GameScreenOutputController();
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		gsoc.printGameBoard(gameBoard);
		
		String expectResult = "Game Board:\n"
							+ "Player = X, Robot = O\n"
							+ " A B C D E F G\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|X|*|*|*|*|*|*|\n\n";

		assertEquals(expectResult, getOutput());
	}
	
	@Test
	public void testGetGameBoard() throws Exception {
		setOutput();
		
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		String[][] result = gameBoard.getGameBoard();
		
		for (String[] row : result) {
			for (String column : row) {
				System.out.print(column);
			}
		}

		assertEquals("******************************************", getOutput());
	}
	
	@Test
	public void testIsGameBoardFull() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		String[][] result = gameBoard.getGameBoard();
		
		for (String[] row : result) {
			for (int j = 0; j < row.length; j++) {
				row[j] = "X";
			}
		}

		assertEquals(true, gameBoard.isGameBoardFull());
	}
}
