import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameScreenOutputControllerTest {
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
	public void testPrintGameBoard() throws Exception {
		setOutput();
		
		GameScreenOutputController gsoc = new GameScreenOutputController();
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("D", true);
		gsoc.printGameBoard(gameBoard);
		
		String expectResult = "Game Board:\n"
							+ "Player = X, Robot = O\n"
							+ " A B C D E F G\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|*|*|O|X|*|*|*|\n"
							+ "|*|*|X|O|X|*|*|\n\n";

		assertEquals(expectResult, getOutput());
	}
	
	@Test
	public void testPrintGameBoardV2() throws Exception {
		setOutput();
		
		GameScreenOutputController gsoc = new GameScreenOutputController();
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gsoc.printGameBoard(gameBoard);
		
		String expectResult = "Game Board:\n"
							+ "Player = X, Robot = O\n"
							+ " A B C D E F G\n"
							+ "|*|*|O|*|*|*|*|\n"
							+ "|*|*|X|*|*|*|*|\n"
							+ "|*|*|O|*|*|*|*|\n"
							+ "|*|*|X|*|*|*|*|\n"
							+ "|*|*|O|*|*|*|*|\n"
							+ "|*|*|X|*|*|*|*|\n\n";

		assertEquals(expectResult, getOutput());
	}

	@Test
	public void testPrintGameBoardV3() throws Exception {
		setOutput();
		
		GameScreenOutputController gsoc = new GameScreenOutputController();
		GameBoard gameBoard = new GameBoard();
		gameBoard.initializeGameBoard();
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("A", false);
		gameBoard.putTokenIntoGameBoard("A", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("B", false);
		gameBoard.putTokenIntoGameBoard("B", true);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("C", false);
		gameBoard.putTokenIntoGameBoard("C", true);
		gameBoard.putTokenIntoGameBoard("D", true);
		gameBoard.putTokenIntoGameBoard("D", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("E", false);
		gameBoard.putTokenIntoGameBoard("E", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("F", false);
		gameBoard.putTokenIntoGameBoard("F", true);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gameBoard.putTokenIntoGameBoard("G", false);
		gameBoard.putTokenIntoGameBoard("G", true);
		gsoc.printGameBoard(gameBoard);
		
		String expectResult = "Game Board:\n"
							+ "Player = X, Robot = O\n"
							+ " A B C D E F G\n"
							+ "|*|*|*|*|*|*|*|\n"
							+ "|X|*|*|*|*|*|X|\n"
							+ "|O|X|*|*|*|X|O|\n"
							+ "|X|O|X|*|X|O|X|\n"
							+ "|O|X|O|O|O|X|O|\n"
							+ "|X|O|X|X|X|O|X|\n\n";

		assertEquals(expectResult, getOutput());
	}
}
