import org.junit.Test;
import static org.junit.Assert.*;

public class BearPlaysDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int A = 10;
		int B = 15;
		int C = 35;
		assertEquals("possible", new BearPlaysDiv2().equalPiles(A, B, C));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int A = 1;
		int B = 1;
		int C = 2;
		assertEquals("impossible", new BearPlaysDiv2().equalPiles(A, B, C));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int A = 4;
		int B = 6;
		int C = 8;
		assertEquals("impossible", new BearPlaysDiv2().equalPiles(A, B, C));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int A = 18;
		int B = 18;
		int C = 18;
		assertEquals("possible", new BearPlaysDiv2().equalPiles(A, B, C));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int A = 225;
		int B = 500;
		int C = 475;
		assertEquals("possible", new BearPlaysDiv2().equalPiles(A, B, C));
	}
}
