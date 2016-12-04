import static org.junit.Assert.*;

import org.junit.Test;

public class GameInstancesTest {
	
	@Test
	public void testInstantiate() {
		GameInstances gi = new GameInstances();
		assertNotNull(gi);
	}

	@Test
	public void testPlayerFirst() {
		assertEquals("Player starts the game first!", GameInstances.PLAYER_FIRST);
	}
	
	@Test
	public void testRobotFirst() {
		assertEquals("Computer starts the game first!", GameInstances.ROBOT_FIRST);
	}
	
	@Test
	public void testPlayerRound() {
		assertEquals("Player's Round", GameInstances.PLAYER_ROUND);
	}
	
	@Test
	public void testRobotRound() {
		assertEquals("Robot's Round", GameInstances.ROBOT_ROUND);
	}
	
	@Test
	public void testInputOptionMenu() {
		assertEquals("Which column you want to input? (A-G): ", GameInstances.INPUT_OPTION_MENU);
	}

	@Test
	public void testIncorrectColumnIndex() {
		assertEquals("Invalid column, input again!: ", GameInstances.INCORRECT_COLUMN_INDEX);
	}
	
	@Test
	public void testShowInputedColumnIndex() {
		assertEquals("Your input: ", GameInstances.SHOW_INPUTED_COLUMN_INDEX);
	}
	
	@Test
	public void testConnectType() {
		assertEquals("column_connect", GameInstances.CONNECT_TYPE[0]);
		assertEquals("row_connect", GameInstances.CONNECT_TYPE[1]);
		assertEquals("Right_slope_connect", GameInstances.CONNECT_TYPE[2]);
		assertEquals("left_slope_connect", GameInstances.CONNECT_TYPE[3]);
	}
	
	@Test
	public void testPlayerToken() {
		assertEquals("X", GameInstances.PLAYER_TOKEN);
	}
	
	@Test
	public void testRobotToken() {
		assertEquals("O", GameInstances.ROBOT_TOKEN);
	}
	
	@Test
	public void testBoardRow() {
		assertEquals(6, GameInstances.BOARD_ROW);
	}
	
	@Test
	public void testBoardColumn() {
		assertEquals(7, GameInstances.BOARD_COLUMN);
	}
	
	@Test
	public void testColumnName() {
		assertEquals("A", GameInstances.COLUMN_NAME[0]);
		assertEquals("B", GameInstances.COLUMN_NAME[1]);
		assertEquals("C", GameInstances.COLUMN_NAME[2]);
		assertEquals("D", GameInstances.COLUMN_NAME[3]);
		assertEquals("E", GameInstances.COLUMN_NAME[4]);
		assertEquals("F", GameInstances.COLUMN_NAME[5]);
		assertEquals("G", GameInstances.COLUMN_NAME[6]);
		assertEquals("a", GameInstances.COLUMN_NAME[7]);
		assertEquals("b", GameInstances.COLUMN_NAME[8]);
		assertEquals("c", GameInstances.COLUMN_NAME[9]);
		assertEquals("d", GameInstances.COLUMN_NAME[10]);
		assertEquals("e", GameInstances.COLUMN_NAME[11]);
		assertEquals("f", GameInstances.COLUMN_NAME[12]);
		assertEquals("g", GameInstances.COLUMN_NAME[13]);
	}
	
	@Test
	public void testColumnMap() {
		assertEquals(0, GameInstances.COLUMN_MAP.get("A").intValue());
		assertEquals(1, GameInstances.COLUMN_MAP.get("B").intValue());
		assertEquals(2, GameInstances.COLUMN_MAP.get("C").intValue());
		assertEquals(3, GameInstances.COLUMN_MAP.get("D").intValue());
		assertEquals(4, GameInstances.COLUMN_MAP.get("E").intValue());
		assertEquals(5, GameInstances.COLUMN_MAP.get("F").intValue());
		assertEquals(6, GameInstances.COLUMN_MAP.get("G").intValue());
		assertEquals(0, GameInstances.COLUMN_MAP.get("a").intValue());
		assertEquals(1, GameInstances.COLUMN_MAP.get("b").intValue());
		assertEquals(2, GameInstances.COLUMN_MAP.get("c").intValue());
		assertEquals(3, GameInstances.COLUMN_MAP.get("d").intValue());
		assertEquals(4, GameInstances.COLUMN_MAP.get("e").intValue());
		assertEquals(5, GameInstances.COLUMN_MAP.get("f").intValue());
		assertEquals(6, GameInstances.COLUMN_MAP.get("g").intValue());
	}
}
