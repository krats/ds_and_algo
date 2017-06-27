import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructLCSEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int ab = 2;
		int bc = 3;
		int ca = 4;
		assertEquals("1111 101 1010101", new ConstructLCSEasy().construct(ab, bc, ca));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int ab = 4;
		int bc = 4;
		int ca = 7;
		assertEquals("10101010 1011 1010101", new ConstructLCSEasy().construct(ab, bc, ca));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int ab = 6;
		int bc = 7;
		int ca = 8;
		assertEquals("10101010 1111010 110101010", new ConstructLCSEasy().construct(ab, bc, ca));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int ab = 7;
		int bc = 8;
		int ca = 8;
		assertEquals("10101010 010101101 110101001011", new ConstructLCSEasy().construct(ab, bc, ca));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int ab = 15;
		int bc = 17;
		int ca = 19;
		assertEquals("000100101101111011000 11110111010011101010 100100001010101001010101000011111", new ConstructLCSEasy().construct(ab, bc, ca));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int ab = 50;
		int bc = 50;
		int ca = 50;
		assertEquals("11111111111111111111111111111111111111111111111111 11111111111111111111111111111111111111111111111111 11111111111111111111111111111111111111111111111111", new ConstructLCSEasy().construct(ab, bc, ca));
	}
}
