import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlphaGo {
	private GameBoard gameBoard;
	private GameScreenOutputController _outputController;
	
	public AlphaGo() {
		this.gameBoard = GameBoard.getInstance();
		this._outputController = new GameScreenOutputController();
		
	}
	

	public String decideNextAction() {
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		String action;
		List<String> possibleActions;
		Random rand = new Random();
		
		
		try {
			
			action = this.winByOneAction();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("player WinByOneAction");
			this._outputController.printGameBoard(this.gameBoard);
			
			action = this.blockPlayerWinByOneAction();
			if(!(action == null)){
				return action;
			}
			
			
			System.out.println("Robot MakeOneActionToHaveTwoDifferentWinningWays");
			this._outputController.printGameBoard(this.gameBoard);
			
			action = this.makeTwoWinWays();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("player MakeOneActionToHaveTwoDifferentWinningWays");
			this._outputController.printGameBoard(this.gameBoard);
			
			action = this.blockPlayerMakeOneActionToHaveTwoDifferentWinningWays();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("Robot MakeOneActionToHaveOneWinningWay");
			this._outputController.printGameBoard(this.gameBoard);
			
			possibleActions = this.makeOneWinWay();
			if(!(possibleActions.isEmpty())){
				
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			System.out.println("Robot posibleSeconTokenInput");
			this._outputController.printGameBoard(this.gameBoard);
			
			possibleActions = this.posibleSecondTokenInput();
			if(!(possibleActions.isEmpty())){
				
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			System.out.println("Before return from AlphaGo");
			this._outputController.printGameBoard(this.gameBoard);
			
			return checkingColumns[rand.nextInt(checkingColumns.length)];
				
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String blockPlayerWinByOneAction() throws CloneNotSupportedException{
		
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameController controller = GameController.getInstance();

		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], true);
			//this._outputController.printGameBoard(gameBoard);
			
			if(inputResult){
				int actionResult = controller.isWin();
				if(actionResult > 0){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
				else{
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
			
		}
		return null;
		
	}
	
	
	public String winByOneAction() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameController controller = GameController.getInstance();
		
		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			//this._outputController.printGameBoard(gameBoard);
			
			if(inputResult){
				int actionResult = controller.isWin();
				if(actionResult > 0){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
				else{
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
			
		}
		return null;
	}
	

	public String blockPlayerMakeOneActionToHaveTwoDifferentWinningWays() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameController controller = GameController.getInstance();
		
		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], true);
			int ways = 0;
			
			if(inputResult){
				for(int j=0; j<checkingColumns.length; j++){
					inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[j], true);
					if(inputResult){
						int actionResult = controller.isWin();
						if(actionResult > 0){		
							ways++;
						}
					}
					gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
				}
				if(ways > 1){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
			}
			gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
		}
		return null;
	}
	
	public String makeTwoWinWays() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameController controller = GameController.getInstance();
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			int ways = 0;
			
			if(inputResult){
				for(int j=0; j<checkingColumns.length; j++){
					inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[j], false);
					if(inputResult){
						int actionResult = controller.isWin();
						if(actionResult > 0){							
							ways++;	
						}
					}
					gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
				}
				if(ways > 1){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
			}
			gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
		}
		return null;
	}
	
	

	public List<String> posibleSecondTokenInput() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List<String> bestActions = new ArrayList<String>();
		List<String> normalActions = new ArrayList<String>();
		List<String> suggestedActions = new ArrayList<String>();
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			if(inputResult){
				String bestResult =this.makeTwoWinWays();
				if( bestResult != null ){
					bestActions.add(checkingColumns[i]);
				}
				else{
					List<String> normalResult = this.makeOneWinWay();
					if(!normalResult.isEmpty()){
						normalActions.add(checkingColumns[i]);
					}
				}
				gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
			}
		}
		
		if(bestActions.isEmpty()){
			suggestedActions = normalActions;
		}
		else{
			suggestedActions = bestActions;
		}
		
//		for(int i=0; i<suggestedActions.size(); i++){
//			System.out.println(suggestedActions.get(i));
//		}
		
		return suggestedActions;
	}
	
	
	public List<String> makeOneWinWay() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List<String> possibleActions = new ArrayList<String>();
		GameController controller = GameController.getInstance();
		
		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			
			if(inputResult){
				for(int j=0; j<checkingColumns.length; j++){
					inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[j], false);
					
					if(inputResult){
						int actionResult = controller.isWin();
						if(actionResult > 0){
							possibleActions.add(checkingColumns[i]);
						}		
					}
					gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
				}
			}
			gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
		}
		return possibleActions;
	}

	
}
