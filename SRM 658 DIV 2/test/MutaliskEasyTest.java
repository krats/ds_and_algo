import org.junit.Test;
import static org.junit.Assert.*;

public class MutaliskEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] x = new int[] {12,10,4};
		assertEquals(2, new MutaliskEasy().minimalAttacks(x));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] x = new int[] {54,18,6};
		assertEquals(6, new MutaliskEasy().minimalAttacks(x));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] x = new int[] {55,60,53};
		assertEquals(13, new MutaliskEasy().minimalAttacks(x));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] x = new int[] {1,1,1};
		assertEquals(1, new MutaliskEasy().minimalAttacks(x));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] x = new int[] {60, 40};
		assertEquals(9, new MutaliskEasy().minimalAttacks(x));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] x = new int[] {60};
		assertEquals(7, new MutaliskEasy().minimalAttacks(x));
	}
}
