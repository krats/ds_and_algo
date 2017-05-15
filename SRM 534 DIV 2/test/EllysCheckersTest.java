import org.junit.Test;
import static org.junit.Assert.*;

public class EllysCheckersTest {
	
	@Test(timeout=2000)
	public void test0() {
		String board = ".o...";
		assertEquals("YES", new EllysCheckers().getWinner(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String board = "..o..o";
		assertEquals("YES", new EllysCheckers().getWinner(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String board = ".o...ooo..oo..";
		assertEquals("NO", new EllysCheckers().getWinner(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String board = "......o.ooo.o......";
		assertEquals("YES", new EllysCheckers().getWinner(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String board = ".o..o...o....o.....o";
		assertEquals("NO", new EllysCheckers().getWinner(board));
	}

	@Test(timeout=2000)
	public void test5() {
		String board = ".ooooo";
		assertEquals("NO", new EllysCheckers().getWinner(board));
	}
}
