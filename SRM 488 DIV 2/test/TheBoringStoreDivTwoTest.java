import org.junit.Test;
import static org.junit.Assert.*;

public class TheBoringStoreDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		String J = "StoreOfJohn";
		String B = "StoreOfBrus";
		assertEquals("or", new TheBoringStoreDivTwo().find(J, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String J = "JohnAndJohn";
		String B = "John";
		assertEquals("", new TheBoringStoreDivTwo().find(J, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String J = "JohnPlaysGames";
		String B = "BrusAlsoPlays";
		assertEquals("ays", new TheBoringStoreDivTwo().find(J, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String J = "abacaba";
		String B = "abacabadabacaba";
		assertEquals("abaabacaba", new TheBoringStoreDivTwo().find(J, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String J = "aaabaaaaabb";
		String B = "bbbaaaaaaaaa";
		assertEquals("aaabaaaaa", new TheBoringStoreDivTwo().find(J, B));
	}
}
