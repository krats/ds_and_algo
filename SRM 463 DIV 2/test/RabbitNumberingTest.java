import org.junit.Test;
import static org.junit.Assert.*;

public class RabbitNumberingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] maxNumber = new int[] {5};
		assertEquals(5, new RabbitNumbering().theCount(maxNumber));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] maxNumber = new int[] {4, 4, 4, 4};
		assertEquals(24, new RabbitNumbering().theCount(maxNumber));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] maxNumber = new int[] {5, 8};
		assertEquals(35, new RabbitNumbering().theCount(maxNumber));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] maxNumber = new int[] {2, 1, 2};
		assertEquals(0, new RabbitNumbering().theCount(maxNumber));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] maxNumber = new int[] {25, 489, 76, 98, 704, 98, 768, 39, 697, 8, 56, 74, 36, 95, 87, 2, 968, 4, 920, 54, 873, 90};
		assertEquals(676780400, new RabbitNumbering().theCount(maxNumber));
	}
}
