import java.util.HashMap;
import java.util.Map;

public class GameConstants {
	public static final int ROW = 6;
	public static final int COLUMN = 7;
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