import org.junit.Test;
import static org.junit.Assert.*;

public class DivFreed2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 2;
		int k = 2;
		assertEquals(3, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 9;
		int k = 1;
		assertEquals(1, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 3;
		int k = 3;
		assertEquals(15, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 1;
		int k = 107;
		assertEquals(107, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 2;
		int k = 10;
		assertEquals(83, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int n = 2;
		int k = 1234;
		assertEquals(1515011, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int n = 3;
		int k = 8;
		assertEquals(326, new DivFreed2().count(n, k));
	}
	
	@Test(timeout=2000)
	public void test7() {
		int n = 10;
		int k = 100000;
		assertEquals(526882214, new DivFreed2().count(n, k));
	}
}
