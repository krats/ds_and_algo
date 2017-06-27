import org.junit.Test;
import static org.junit.Assert.*;

public class PermutipleTest {
	
	@Test(timeout=2000)
	public void test0() {
		int x = 142857;
		assertEquals("Possible", new Permutiple().isPossible(x));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int x = 14;
		assertEquals("Impossible", new Permutiple().isPossible(x));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int x = 1035;
		assertEquals("Possible", new Permutiple().isPossible(x));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int x = 1000000;
		assertEquals("Impossible", new Permutiple().isPossible(x));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int x = 100035;
		assertEquals("Possible", new Permutiple().isPossible(x));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int x = 4;
		assertEquals("Impossible", new Permutiple().isPossible(x));
	}
}
