import org.junit.Test;
import static org.junit.Assert.*;

public class PathGameDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"#...."
,"...#."};
		assertEquals(2, new PathGameDiv2().calc(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"#"
,"."};
		assertEquals(0, new PathGameDiv2().calc(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"."
,"."};
		assertEquals(1, new PathGameDiv2().calc(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"....#.##.....#..........."
,"..#......#.......#..#...."};
		assertEquals(13, new PathGameDiv2().calc(board));
	}
}
