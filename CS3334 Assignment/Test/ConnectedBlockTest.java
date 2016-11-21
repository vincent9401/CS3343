import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ConnectedBlockTest {
	private ConnectedBlock cb;
	
	@Before
	public void setUp() {
		cb = new ConnectedBlock(0, 1, 3, 4, "right_slope_connect");
	}

	@Test
	public void testGetStartRow() {
		assertEquals(0, cb.getStartRow());
	}
	
	@Test
	public void testGetStartColumn() {
		assertEquals(1, cb.getStartColumn());
	}
	
	@Test
	public void testGetEndRow() {
		assertEquals(3, cb.getEndRow());
	}
	
	@Test
	public void testGetEndColumn() {
		assertEquals(4, cb.getEndColumn());
	}
	
	@Test
	public void testGetConnect_type() {
		assertEquals("right_slope_connect", cb.getConnect_type());
	}

}
