import org.junit.Test;
import static org.junit.Assert.*;

public class JumpDistancesOnTreeEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] p = new int[] {0,1,1,0,4,4};
		int[] S = new int[] {2,4};
		assertEquals("Possible", new JumpDistancesOnTreeEasy().isPossible(p, S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] p = new int[] {0,1,1,0,4,4};
		int[] S = new int[] {1,2,3,4,5};
		assertEquals("Impossible", new JumpDistancesOnTreeEasy().isPossible(p, S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] p = new int[] {0,1,1,0,4,4};
		int[] S = new int[] {3,4};
		assertEquals("Impossible", new JumpDistancesOnTreeEasy().isPossible(p, S));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] p = new int[] {0,1,2,3,4,0,6,7,8,9};
		int[] S = new int[] {2,4,6,8,10};
		assertEquals("Impossible", new JumpDistancesOnTreeEasy().isPossible(p, S));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] p = new int[] {0};
		int[] S = new int[] {1};
		assertEquals("Possible", new JumpDistancesOnTreeEasy().isPossible(p, S));
	}
}
