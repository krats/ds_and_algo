import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromicSubstringsDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		String[] S1 = new String[] {"a","a",""};
		String[] S2 = new String[] {"a"};
		assertEquals(6, new PalindromicSubstringsDiv2().count(S1, S2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] S1 = new String[] {"zaz"};
		String[] S2 = new String[] {};
		assertEquals(4, new PalindromicSubstringsDiv2().count(S1, S2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] S1 = new String[] {"top"};
		String[] S2 = new String[] {"coder"};
		assertEquals(8, new PalindromicSubstringsDiv2().count(S1, S2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] S1 = new String[] {};
		String[] S2 = new String[] {"daata"};
		assertEquals(7, new PalindromicSubstringsDiv2().count(S1, S2));
	}
}
