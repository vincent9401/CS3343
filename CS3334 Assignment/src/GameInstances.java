import java.util.HashMap;
import java.util.Map;

public class GameInstances {
	public final static String PLAYER_FIRST = "Player starts the game first!";
	public final static String ROBOT_FIRST = "Computer starts the game first!";
	public final static String PLAYER_ROUND = "Player's Round";
	public final static String ROBOT_ROUND = "Robot's Round";
	public final static String INPUT_OPTION_MENU = "Which column you want to input? (A-G): ";
	public final static String INCORRECT_COLUMN_INDEX = "Invalid column, input again!: ";
	public final static String SHOW_INPUTED_COLUMN_INDEX = "Your input: ";
	
	public final static String[] CONNECT_TYPE = {"column_connect", "row_connect", "slop_connect"};
	
	public static final String PLAYER_TOKEN = "X";
	public static final String ROBOT_TOKEN = "O";
	public static final int BOARD_ROW = 6;
	public static final int BOARD_COLUMN = 7;
	public static final String[] COLUMN_NAME = {"A", "B", "C", "D", "E", "F", "G", "a", "b", "c", "d", "e", "f", "g"};
	public static final Map<String, Integer> COLUMN_MAP = new HashMap<String, Integer>()
	{{
		put("A", 0);
		put("B", 1);
		put("C", 2);
		put("D", 3);
		put("E", 4);
		put("F", 5);
		put("G", 6);
		put("a", 0);
		put("b", 1);
		put("c", 2);
		put("d", 3);
		put("e", 4);
		put("f", 5);
		put("g", 6);
	}};
}
