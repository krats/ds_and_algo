import org.junit.Test;
import static org.junit.Assert.*;

public class StrIIRecTest {
	
	@Test(timeout=2000)
	public void test0() {
		int n = 2;
		int minInv = 1;
		String minStr = "ab";
		assertEquals("ba", new StrIIRec().recovstr(n, minInv, minStr));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int n = 9;
		int minInv = 1;
		String minStr = "efcdgab";
		assertEquals("efcdgabhi", new StrIIRec().recovstr(n, minInv, minStr));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int n = 11;
		int minInv = 55;
		String minStr = "debgikjfc";
		assertEquals("kjihgfedcba", new StrIIRec().recovstr(n, minInv, minStr));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int n = 15;
		int minInv = 0;
		String minStr = "e";
		assertEquals("eabcdfghijklmno", new StrIIRec().recovstr(n, minInv, minStr));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int n = 9;
		int minInv = 20;
		String minStr = "fcdebiha";
		assertEquals("fcdehigba", new StrIIRec().recovstr(n, minInv, minStr));
	}
}
