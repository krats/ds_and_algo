import org.junit.Test;
import static org.junit.Assert.*;

public class StepsConstructTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"...",
 ".#.",
 "..."};
		int k = 4;
		assertEquals("DDRR", new StepsConstruct().construct(board, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"...",
 ".#.",
 "..."};
		int k = 12;
		assertEquals("DUDUDUDUDDRR", new StepsConstruct().construct(board, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"...#.",
 "..#..",
 ".#..."};
		int k = 100;
		assertEquals("", new StepsConstruct().construct(board, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"..#",
 "#.#",
 "..#",
 ".#.",
 "..."};
		int k = 6;
		assertEquals("", new StepsConstruct().construct(board, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {".#...",
 ".#.#.",
 ".#.#.",
 ".#.#.",
 "...#."};
		int k = 16;
		assertEquals("DDDDRRUUUURRDDDD", new StepsConstruct().construct(board, k));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] board = new String[] {"#.", 
 ".."};
		int k = 2;
		assertEquals("", new StepsConstruct().construct(board, k));
	}
}
