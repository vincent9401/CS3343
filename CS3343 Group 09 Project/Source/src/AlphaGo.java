import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlphaGo {
	private GameBoard _gameboard;
	public AlphaGo(GameBoard gameboard) {
		this._gameboard = gameboard;
	}
	
	public String decideNextAction() {
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		String action;
		List<String> possibleActions;
		Random rand = new Random();
		
		try {
			action = this.WinByOneAction();
			if(!(action == null)){
				return action;
			}
			
			
			action = this.BlockPlayerWinByOneAction();
			if(!(action == null)){
				return action;
			}
			
			action = this.MakeOneActionToHaveTwoDifferentWinningWays();
			if(!(action == null)){
				return action;
			}
			
			action = this.BlockPlayerMakeOneActionToHaveTwoDifferentWinningWays();
			if(!(action == null)){
				return action;
			}
			
			
			possibleActions = this.MakeOneActionToHaveOneWinningWay();
			if(!(possibleActions.isEmpty())){
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			
			possibleActions = this.possibleSeconTokenInput();
			if(!(possibleActions.isEmpty())){
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			
			return checkingColumns[rand.nextInt(checkingColumns.length)];
				
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String BlockPlayerWinByOneAction() throws CloneNotSupportedException{
		
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameBoard gameBoard = (GameBoard) this._gameboard.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], true);
			//this._outputController.printGameBoard(gameBoard);
			
			if(inputResult){
				int actionResult = controller.isWin();
				if(actionResult > 0){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				} else {
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
		}
		return null;
	}
	
	public String WinByOneAction(GameBoard gb) throws CloneNotSupportedException {
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameBoard gameBoard = (GameBoard) gb.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			//this._outputController.printGameBoard(gameBoard);
			
			if(inputResult){
				int actionResult = controller.isWin();
				if(actionResult > 0){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				} else {
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
		}
		return null;
	}
	
	public String WinByOneAction() throws CloneNotSupportedException{
		return WinByOneAction(this._gameboard);
	}
	
	public String BlockPlayerMakeOneActionToHaveTwoDifferentWinningWays() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameBoard gameBoard = (GameBoard) this._gameboard.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], true);
			int ways = 0;
			
			if(inputResult){
				for(int j=0; j<checkingColumns.length; j++){
					inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[j], true);
					
					if (inputResult) {
						int actionResult = controller.isWin();
						if (actionResult > 0) {
							ways++;
						}
						
//						this._outputController.printGameBoard(gameBoard);
//						System.out.print("actionResult :"+actionResult+" i ="+i+" j = "+j+" , " );
						gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
					}
				}
				if (ways > 1) {
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
				gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
			}
		}
		return null;
	}
	
	public String MakeOneActionToHaveTwoDifferentWinningWays(GameBoard gb) throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameBoard gameBoard = (GameBoard) gb.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
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
						
//						this._outputController.printGameBoard(gameBoard);
//						System.out.print("actionResult :"+actionResult+" i ="+i+" j = "+j+" , " );
						gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
					}	
				}
				if(ways > 1){
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
					return checkingColumns[i];
				}
				gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
			}
		}
		return null;
	}
	
	public String MakeOneActionToHaveTwoDifferentWinningWays() throws CloneNotSupportedException{
		return this.MakeOneActionToHaveTwoDifferentWinningWays(this._gameboard);
	}
	
	public List<String> possibleSeconTokenInput() throws CloneNotSupportedException{
		return this.possibleSeconTokenInput(this._gameboard);
	}
	
	public List<String> possibleSeconTokenInput(GameBoard gb) throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List<String> bestActions = new ArrayList<String>();
		List<String> normalActions = new ArrayList<String>();
		List<String> suggestedActions = new ArrayList<String>();
		GameBoard gameBoard = (GameBoard) gb.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			if(inputResult){
				String bestResult =this.MakeOneActionToHaveTwoDifferentWinningWays(gameBoard);
				if(!(bestResult == null)){
					bestActions.add(checkingColumns[i]);
				} else {
					List<String> normalResult = this.MakeOneActionToHaveOneWinningWay(gameBoard);
					if(!normalResult.isEmpty()){
						normalActions.add(checkingColumns[i]);
					}
				}
				
//				this._outputController.printGameBoard(gameBoard);
//				System.out.println("Best Actions");
//				for(int k=0; k<bestActions.size(); k++){
//					System.out.println(bestActions.get(k));
//				}
//				System.out.println("Normal Actions");
//				for(int k=0; k<normalActions.size(); k++){
//					System.out.println(normalActions.get(k));
//				}
				
				gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
			}
		}
		
		if(bestActions.isEmpty()){
			suggestedActions = normalActions;
		} else {
			suggestedActions = bestActions;
		}
		
//		for(int i=0; i<suggestedActions.size(); i++){
//			System.out.println(suggestedActions.get(i));
//		}
		
		return suggestedActions;
	}
	
	
	public List<String> MakeOneActionToHaveOneWinningWay(GameBoard gb) throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List<String> possibleActions = new ArrayList<String>();
		GameBoard gameBoard = (GameBoard) gb.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
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
						//this._outputController.printGameBoard(gameBoard);
						//System.out.print("actionResult :"+actionResult+" i ="+i+" j = "+j+" , " );
						gameBoard.removeTokenOnGameBoard(checkingColumns[j]);
					}
				}
				gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
			}
		}
		
//		for(int i=0; i<possibleActions.size(); i++){
//			System.out.println(possibleActions.get(i));
//		}

		return possibleActions;
	}
	
	public List<String> MakeOneActionToHaveOneWinningWay() throws CloneNotSupportedException{
		return this.MakeOneActionToHaveOneWinningWay(this._gameboard);
	}
	
	public String WinByTwoActions() throws CloneNotSupportedException{
		return null;
	}
}
