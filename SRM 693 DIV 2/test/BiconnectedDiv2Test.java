import org.junit.Test;
import static org.junit.Assert.*;

public class BiconnectedDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int[] w1 = new int[] {1,2};
		int[] w2 = new int[] {3};
		assertEquals(6, new BiconnectedDiv2().minimize(w1, w2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] w1 = new int[] {-1,-2,-3};
		int[] w2 = new int[] {-4,-5};
		assertEquals(-15, new BiconnectedDiv2().minimize(w1, w2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] w1 = new int[] {1,100,-3,2};
		int[] w2 = new int[] {-2,1,4};
		assertEquals(3, new BiconnectedDiv2().minimize(w1, w2));
	}
	@Test(timeout=2000)
	public void test3() {
		int[] w1 = new int[] {7094, -4355, 3191, -1241};
		int[] w2 = new int[] {-1886, 8914, -7386};
		assertEquals(1140, new BiconnectedDiv2().minimize(w1, w2));
	}
}
