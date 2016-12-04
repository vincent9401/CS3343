import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GameBoard_Clone_Test {
	private GameScreenOutputController outputController;
	private PrintStream oldPrintStream;
	private ByteArrayOutputStream bos;
	
	public GameBoard_Clone_Test(){
		GameScreenOutputController outputController = new GameScreenOutputController();
		this.outputController = outputController;
	}
	
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
	public void testGameBoardCloneV1() {
		GameBoard gameBoard1 = new GameBoard();
		
		GameBoard gameBoard2 = gameBoard1.clone();
		assertNotEquals(gameBoard1, gameBoard2);
			
		GameBoard gameBoard3 = gameBoard1.clone();
		assertNotEquals(gameBoard1, gameBoard3);

		GameBoard gameBoard4 = gameBoard1.clone();
		assertNotEquals(gameBoard1, gameBoard4);
			
		GameBoard gameBoard5 = gameBoard1.clone();
		assertNotEquals(gameBoard1, gameBoard5);
	}
	
	@Test
	public void testGameBoardCloneV2() throws Exception {
		GameBoard gameBoard_1 = new GameBoard();
		gameBoard_1.initializeGameBoard();
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		setOutput();
		this.outputController.printGameBoard(gameBoard_1);
		String gb1Result = getOutput();
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		setOutput();
		this.outputController.printGameBoard(gameBoard_2);
		String gb2Result = getOutput();
		
		assertEquals(gb1Result, gb2Result);
		assertNotEquals(gameBoard_1, gameBoard_2);
	}
	
	@Test
	public void testGameBoardCloneV3() throws Exception {
		GameBoard gameBoard_1 = new GameBoard();

		gameBoard_1.initializeGameBoard();
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		setOutput();
		this.outputController.printGameBoard(gameBoard_1);
		String gb1Result = getOutput();
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		setOutput();
		this.outputController.printGameBoard(gameBoard_2);
		gameBoard_2.putTokenIntoGameBoard("C", true);
		gameBoard_2.putTokenIntoGameBoard("D", true);
		String gb2Result = getOutput();
		
		assertEquals(gb1Result, gb2Result);
		assertNotEquals(gameBoard_1, gameBoard_2);
	}
	
	@Test
	public void testGameBoardCloneV4() throws Exception {
		GameBoard gameBoard_1 = new GameBoard();
		
		gameBoard_1.initializeGameBoard();
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		gameBoard_2.putTokenIntoGameBoard("C", true);
		gameBoard_2.putTokenIntoGameBoard("D", true);
		
		GameBoard gameBoard_3 = gameBoard_2.clone();
		gameBoard_3.putTokenIntoGameBoard("A", true);
		gameBoard_3.putTokenIntoGameBoard("G", true);
		
		GameBoard gameBoard_4 = gameBoard_3.clone();
		gameBoard_4.putTokenIntoGameBoard("B", true);
		gameBoard_4.putTokenIntoGameBoard("E", true);
		
		setOutput();
		this.outputController.printGameBoard(gameBoard_1);
		String gb1Result = getOutput();
		
		setOutput();
		this.outputController.printGameBoard(gameBoard_2);
		String gb2Result = getOutput();
		
		setOutput();
		this.outputController.printGameBoard(gameBoard_3);
		String gb3Result = getOutput();
		
		setOutput();
		this.outputController.printGameBoard(gameBoard_4);
		String gb4Result = getOutput();
		
		assertNotEquals(gb1Result, gb2Result);
		assertNotEquals(gb2Result, gb3Result);
		assertNotEquals(gb3Result, gb4Result);
		assertNotEquals(gb4Result, gb1Result);
	}

}
