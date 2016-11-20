public class AlphaGo {
	private GameBoard _gameboard;
	private GameScreenOutputController _outputController;
	
	public AlphaGo(GameBoard gameboard) {
		this._gameboard = gameboard;
		this._outputController = new GameScreenOutputController();
		
	}
	

	public String decideNextAction() {
		try {
			this.WinByOneAction();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "F";
	}
	
	public String WinByOneAction() throws CloneNotSupportedException{
		String[] checkingColumns = { "A", "B", "C", "D", "E", "F", "G" };
		GameBoard gameBoard = (GameBoard) this._gameboard.clone();
		GameController controller = new GameController();
		controller.setGameBoard(gameBoard);
		
		for(int i=0; i<checkingColumns.length; i++){
			
			boolean inputResult = gameBoard.putTokenIntoGameBoard(checkingColumns[i], false);
			this._outputController.printGameBoard(gameBoard);
			
			if(inputResult){
				int actionResult = controller.isWin();
				if(actionResult > 0){
					return checkingColumns[i];
				}
				else{
					gameBoard.removeTokenOnGameBoard(checkingColumns[i]);
				}
			}
			
		}
		return null;
	}
	
}
