import org.junit.Test;
import static org.junit.Assert.*;

public class RepeatStringEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "frankfurt";
		assertEquals(4, new RepeatStringEasy().maximalLength(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "single";
		assertEquals(0, new RepeatStringEasy().maximalLength(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "singing";
		assertEquals(6, new RepeatStringEasy().maximalLength(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "aababbababbabbbbabbabb";
		assertEquals(18, new RepeatStringEasy().maximalLength(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "x";
		assertEquals(0, new RepeatStringEasy().maximalLength(s));
	}
}
