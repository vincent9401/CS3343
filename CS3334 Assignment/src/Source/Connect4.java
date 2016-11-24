package Source;

public class Connect4 {
public static void main(String args[])
 {


 Connect4View view = new Connect4ViewText();
// Connect4View view = new Connect4ViewGraphical();



 Player [] players = new Player[2]; // Array to hold the players

 // Initialize the players
 players[0] = makePlayer(view, "first");
 players[1] = makePlayer(view, "second");

 // Hold current game state
 Connect4Game state = new Connect4Game(0, players);
 view.display(state);
 while (!state.gameIsOver())
 {
 int move = state.getPlayerToMove().getMove(state, view);
 state.makeMove(move);
 view.display(state);
 }
 if (state.isFull())
 view.reportToUser("It is a draw");
 else
 view.reportToUser(players[1 - state.getPlayerNum()].getName() + " wins!");
 }

 /**
 * Constructs a Connect 4 player. If the name contains "Computer" it
 * constructs a computer player; else a human player
 * @param view the view to use to communicate to the world
 * @param playerMsg the player to ask for
 * @return
 */
 public static Player makePlayer(Connect4View view, String playerMsg) {
 String playerName = view.getAnswer("Enter the name of the " + playerMsg +
 " player." + "\n(Include 'Computer' in the name of a computer player) ");
 if(playerName.contains("Computer")) {
 int depth = view.getIntAnswer("How far should I look ahead? ");
 return new ComputerConnect4Player(playerName, depth);
 }
 else
 return new HumanConnect4Player(playerName);
 }
}