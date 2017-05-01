import org.junit.Test;
import static org.junit.Assert.*;

public class NumberofFiboCallsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 0;
		assertArrayEquals(new int[] {1, 0 }, new NumberofFiboCalls().fiboCallsMade(n));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 3;
		assertArrayEquals(new int[] {1, 2 }, new NumberofFiboCalls().fiboCallsMade(n));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 6;
		assertArrayEquals(new int[] {5, 8 }, new NumberofFiboCalls().fiboCallsMade(n));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 22;
		assertArrayEquals(new int[] {10946, 17711 }, new NumberofFiboCalls().fiboCallsMade(n));
	}
}
