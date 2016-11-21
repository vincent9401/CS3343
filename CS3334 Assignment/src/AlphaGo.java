import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlphaGo {
	private GameBoard _gameboard;
	private GameScreenOutputController _outputController;
	
	public AlphaGo(GameBoard gameboard) {
		this._gameboard = gameboard;
		this._outputController = new GameScreenOutputController();
		
	}
	

	public String decideNextAction() {
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		String action;
		List<String> possibleActions;
		Random rand = new Random();
		
		
		System.out.println("Inner Code");
		this._outputController.printGameBoard(this._gameboard);
		
		try {
			
			System.out.println("Robot WinByOneAction");
			this._outputController.printGameBoard(this._gameboard);
			
			action = this.WinByOneAction();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("player WinByOneAction");
			this._outputController.printGameBoard(this._gameboard);
			
			action = this.BlockPlayerWinByOneAction();
			if(!(action == null)){
				return action;
			}
			
			
			System.out.println("Robot MakeOneActionToHaveTwoDifferentWinningWays");
			this._outputController.printGameBoard(this._gameboard);
			
			action = this.MakeOneActionToHaveTwoDifferentWinningWays();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("player MakeOneActionToHaveTwoDifferentWinningWays");
			this._outputController.printGameBoard(this._gameboard);
			
			action = this.BlockPlayerMakeOneActionToHaveTwoDifferentWinningWays();
			if(!(action == null)){
				return action;
			}
			
			System.out.println("Robot MakeOneActionToHaveOnetWinningWay");
			this._outputController.printGameBoard(this._gameboard);
			
			possibleActions = this.MakeOneActionToHaveOnetWinningWay();
			if(!(possibleActions.isEmpty())){
				
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			System.out.println("Robot posibleSeconTokenInput");
			this._outputController.printGameBoard(this._gameboard);
			
			possibleActions = this.posibleSeconTokenInput();
			if(!(possibleActions.isEmpty())){
				
				int n = rand.nextInt(possibleActions.size());
				return possibleActions.get(n);
			}
			
			System.out.println("Before return from AlphaGo");
			this._outputController.printGameBoard(this._gameboard);
			
			return checkingColumns[rand.nextInt(checkingColumns.length)];
				
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
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
				}
				else{
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
			
		}
		return null;
		
	}
	
	
	public String WinByOneAction(GameBoard gb) throws CloneNotSupportedException{
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
				}
				else{
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
	
	public List posibleSeconTokenInput() throws CloneNotSupportedException{
		return this.posibleSeconTokenInput(this._gameboard);
	}
	
	public List posibleSeconTokenInput(GameBoard gb) throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List bestActions = new ArrayList();
		List normalActions = new ArrayList();
		List suggestedActions = new ArrayList();
		GameBoard gameBoard = (GameBoard) gb.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			if(inputResult){
				String bestResult =this.MakeOneActionToHaveTwoDifferentWinningWays(gameBoard);
				if(!(bestResult == null)){
					bestActions.add(checkingColumns[i]);
				}
				else{
					List normalResult = this.MakeOneActionToHaveOnetWinningWay(gameBoard);
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
		}
		else{
			suggestedActions = bestActions;
		}
		
//		for(int i=0; i<suggestedActions.size(); i++){
//			System.out.println(suggestedActions.get(i));
//		}
		
		return suggestedActions;
	}
	
	
	public List MakeOneActionToHaveOnetWinningWay(GameBoard gb) throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		List possibleActions = new ArrayList();
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
	
	public List MakeOneActionToHaveOnetWinningWay() throws CloneNotSupportedException{
		return this.MakeOneActionToHaveOnetWinningWay(this._gameboard);
		
	}
	
	
	public String WinByTweActions() throws CloneNotSupportedException{
		return null;
	}
	
	
}
