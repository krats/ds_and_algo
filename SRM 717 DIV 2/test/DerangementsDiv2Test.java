import org.junit.Test;
import static org.junit.Assert.*;

public class DerangementsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 0;
		int m = 2;
		assertEquals(1, new DerangementsDiv2().count(n, m));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 2;
		int m = 1;
		assertEquals(4, new DerangementsDiv2().count(n, m));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 1;
		int m = 2;
		assertEquals(3, new DerangementsDiv2().count(n, m));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 3;
		int m = 5;
		assertEquals(21234, new DerangementsDiv2().count(n, m));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 20;
		int m = 27;
		assertEquals(88437461, new DerangementsDiv2().count(n, m));
	}
}
