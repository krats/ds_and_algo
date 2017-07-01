import org.junit.Test;
import static org.junit.Assert.*;

public class NiceTableTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] t = new String[] {"01",
 "10"};
		assertEquals("Nice", new NiceTable().isNice(t));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] t = new String[] {"01",
 "11"};
		assertEquals("Not nice", new NiceTable().isNice(t));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] t = new String[] {"0100",
 "1011",
 "0100"};
		assertEquals("Nice", new NiceTable().isNice(t));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] t = new String[] {"11",
 "10",
 "11",
 "11",
 "11"};
		assertEquals("Not nice", new NiceTable().isNice(t));
	}
}
