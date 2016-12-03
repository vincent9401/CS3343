import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoard_Clone_Test {
	private GameScreenOutputController outputController;
	
	public GameBoard_Clone_Test(){
		GameScreenOutputController outputController = new GameScreenOutputController();
		this.outputController = outputController;
	}

	@Test
	public void test_1() {
		GameBoard gameBoard = new GameBoard();
		
		System.out.println("\ntest_1");
		System.out.println("1st : "+gameBoard);
			gameBoard = gameBoard.clone();
			System.out.println("2nd : "+gameBoard);
			
			gameBoard = gameBoard.clone();
			System.out.println("3th : "+gameBoard);

			gameBoard = gameBoard.clone();
			System.out.println("4th : "+gameBoard);
			
			gameBoard = gameBoard.clone();
			System.out.println("5th : "+gameBoard);

	}
	
	@Test
	public void test_2() throws CloneNotSupportedException {
		GameBoard gameBoard_1 = new GameBoard();
		
		System.out.println("\ntest_2");
		
		System.out.println("1st : "+gameBoard_1);
		gameBoard_1.initializeGameBoard();
		this.outputController.printGameBoard(gameBoard_1);
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		this.outputController.printGameBoard(gameBoard_1);
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		System.out.println("2st : "+gameBoard_2);
		this.outputController.printGameBoard(gameBoard_2);
	}
	
	@Test
	public void test_3() throws CloneNotSupportedException {
		GameBoard gameBoard_1 = new GameBoard();
		
		System.out.println("\ntest_3");
		
		System.out.println("1st : "+gameBoard_1);
		gameBoard_1.initializeGameBoard();
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		this.outputController.printGameBoard(gameBoard_1);
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		System.out.println("2st : "+gameBoard_2);
		this.outputController.printGameBoard(gameBoard_2);
		gameBoard_2.putTokenIntoGameBoard("C", true);
		gameBoard_2.putTokenIntoGameBoard("D", true);
		
		System.out.println("GameBoard 1");
		this.outputController.printGameBoard(gameBoard_1);
		System.out.println("GameBoard 2");
		this.outputController.printGameBoard(gameBoard_2);
		
		
	}
	
	@Test
	public void test_4() throws CloneNotSupportedException {
		GameBoard gameBoard_1 = new GameBoard();
		
		System.out.println("\ntest_4");
		
		gameBoard_1.initializeGameBoard();
		System.out.println("GameBoard1 -- before put token: ");
		this.outputController.printGameBoard(gameBoard_1);
		gameBoard_1.putTokenIntoGameBoard("A", true);
		gameBoard_1.putTokenIntoGameBoard("B", true);
		System.out.println("GameBoard1 -- after put token: ");
		this.outputController.printGameBoard(gameBoard_1);
		
		GameBoard gameBoard_2 = gameBoard_1.clone();
		System.out.println("GameBoard2 -- clone from GameBoard1 before put token: ");
		this.outputController.printGameBoard(gameBoard_2);
		gameBoard_2.putTokenIntoGameBoard("C", true);
		gameBoard_2.putTokenIntoGameBoard("D", true);
		System.out.println("GameBoard2 --clone from GameBoard1 after put token: ");
		this.outputController.printGameBoard(gameBoard_2);
		
		GameBoard gameBoard_3 = gameBoard_1.clone();
		System.out.println("GameBoard3 -- clone from GameBoard1 before put token: ");
		this.outputController.printGameBoard(gameBoard_3);
		gameBoard_3.putTokenIntoGameBoard("A", true);
		gameBoard_3.putTokenIntoGameBoard("G", true);
		System.out.println("GameBoard3 --clone from GameBoard1 after put token: ");
		this.outputController.printGameBoard(gameBoard_3);
		
		GameBoard gameBoard_4 = gameBoard_3.clone();
		System.out.println("GameBoard4 -- clone from GameBoard3 before put token: ");
		this.outputController.printGameBoard(gameBoard_4);
		gameBoard_4.putTokenIntoGameBoard("B", true);
		gameBoard_4.putTokenIntoGameBoard("E", true);
		System.out.println("GameBoard4 --clone from GameBoard3 after put token: ");
		this.outputController.printGameBoard(gameBoard_4);
		
		System.out.println("GameBoard 1");
		this.outputController.printGameBoard(gameBoard_1);
		System.out.println("GameBoard 2");
		this.outputController.printGameBoard(gameBoard_2);
		System.out.println("GameBoard 3");
		this.outputController.printGameBoard(gameBoard_3);
		System.out.println("GameBoard 4");
		this.outputController.printGameBoard(gameBoard_4);
		
	}

}
