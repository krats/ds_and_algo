import org.junit.Test;
import static org.junit.Assert.*;

public class LexmaxReplaceTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "abb";
		String t = "c";
		assertEquals("cbb", new LexmaxReplace().get(s, t));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "z";
		String t = "f";
		assertEquals("z", new LexmaxReplace().get(s, t));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "fedcba";
		String t = "ee";
		assertEquals("feeeba", new LexmaxReplace().get(s, t));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "top";
		String t = "coder";
		assertEquals("trp", new LexmaxReplace().get(s, t));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "xldyzmsrrwzwaofkcxwehgvtrsximxgdqrhjthkgfucrjdvwlr";
		String t = "xfpidmmilhdfzypbguentqcojivertdhshstkcysydgcwuwhlk";
		assertEquals("zyyyzyxwwwzwvuuttxwtssvtssxrqxppqrontmmllukrkjvwlr", new LexmaxReplace().get(s, t));
	}
}
