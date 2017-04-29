import org.junit.Test;
import static org.junit.Assert.*;

public class MultiNumberTest {
	
	@Test(timeout=2000)
	public void test0() {
		int number = 1;
		assertEquals("NO", new MultiNumber().check(number));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int number = 1221;
		assertEquals("YES", new MultiNumber().check(number));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int number = 1236;
		assertEquals("YES", new MultiNumber().check(number));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int number = 4729382;
		assertEquals("NO", new MultiNumber().check(number));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int number = 42393338;
		assertEquals("YES", new MultiNumber().check(number));
	}
}
