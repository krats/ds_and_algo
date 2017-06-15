import org.junit.Test;
import static org.junit.Assert.*;

public class MazeWanderingEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] maze = new String[] {"*.M"};
		assertEquals(0, new MazeWanderingEasy().decisions(maze));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] maze = new String[] {"*.M",
 ".X."};
		assertEquals(1, new MazeWanderingEasy().decisions(maze));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] maze = new String[] {"...",
 "XMX",
 "..*"};
		assertEquals(2, new MazeWanderingEasy().decisions(maze));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] maze = new String[] {".X.X......X",
 ".X*.X.XXX.X",
 ".XX.X.XM...",
 "......XXXX."};
		assertEquals(3, new MazeWanderingEasy().decisions(maze));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] maze = new String[] {"..........*",
 ".XXXXXXXXXX",
 "...........",
 "XXXXXXXXXX.",
 "M.........."};
		assertEquals(0, new MazeWanderingEasy().decisions(maze));
	}
}
