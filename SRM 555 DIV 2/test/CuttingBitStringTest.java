import org.junit.Test;
import static org.junit.Assert.*;

public class CuttingBitStringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "101101101";
		assertEquals(3, new CuttingBitString().getmin(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "1111101";
		assertEquals(1, new CuttingBitString().getmin(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "00000";
		assertEquals(-1, new CuttingBitString().getmin(S));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "110011011";
		assertEquals(3, new CuttingBitString().getmin(S));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "1000101011";
		assertEquals(-1, new CuttingBitString().getmin(S));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "111011100110101100101110111";
		assertEquals(5, new CuttingBitString().getmin(S));
	}
}
