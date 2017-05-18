import org.junit.Test;
import static org.junit.Assert.*;

public class HandsShakingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 2;
		assertEquals(1L, new HandsShaking().countPerfect(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 4;
		assertEquals(2L, new HandsShaking().countPerfect(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 8;
		assertEquals(14L, new HandsShaking().countPerfect(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 6;
		assertEquals(5L, new HandsShaking().countPerfect(n));
	}
}
