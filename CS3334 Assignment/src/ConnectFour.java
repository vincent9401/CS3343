import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
	public static boolean isWin = false;

	public static void main(String args[]) {

		
		GameController gameController = GameController.getInstance();
		gameController.playGame();

	}
	
}
	
	

