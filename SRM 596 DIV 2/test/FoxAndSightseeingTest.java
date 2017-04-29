import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndSightseeingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] position = new int[] {1, 4, -1, 3};
		assertEquals(4, new FoxAndSightseeing().getMin(position));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] position = new int[] {-2, 4, 3};
		assertEquals(5, new FoxAndSightseeing().getMin(position));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] position = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(9, new FoxAndSightseeing().getMin(position));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] position = new int[] {100, -100, 99, -99};
		assertEquals(199, new FoxAndSightseeing().getMin(position));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] position = new int[] {74,84,92,23,5,-70,-47,-59,24,-86,-39,99,85,-42,54,100,47,-3,42,38};
		assertEquals(836, new FoxAndSightseeing().getMin(position));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] position = new int[] {2,-3,5,7,-11,-13,17,-19,23,29,-31,-37,-41,43,-47,-53,-59,61,-67,71};
		assertEquals(535, new FoxAndSightseeing().getMin(position));
	}
}
