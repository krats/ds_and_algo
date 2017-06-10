import org.junit.Test;
import static org.junit.Assert.*;

public class FriendScoreTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] friends = new String[] {"NNN",
 "NNN",
 "NNN"};
		assertEquals(0, new FriendScore().highestScore(friends));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] friends = new String[] {"NYY",
 "YNY",
 "YYN"};
		assertEquals(2, new FriendScore().highestScore(friends));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] friends = new String[] {"NYNNN",
 "YNYNN", 
 "NYNYN", 
 "NNYNY", 
 "NNNYN"};
		assertEquals(4, new FriendScore().highestScore(friends));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] friends = new String[] {"NNNNYNNNNN",
 "NNNNYNYYNN",
 "NNNYYYNNNN",
 "NNYNNNNNNN",
 "YYYNNNNNNY",
 "NNYNNNNNYN",
 "NYNNNNNYNN",
 "NYNNNNYNNN",
 "NNNNNYNNNN",
 "NNNNYNNNNN"};
		assertEquals(8, new FriendScore().highestScore(friends));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] friends = new String[] {"NNNNNNNNNNNNNNY",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNYNNNNNNN",
 "NNNNNNNYNNNNNNY",
 "NNNNNNNNNNNNNNY",
 "NNNNNNNNYNNNNNN",
 "NNNNNNNNNNNNNNN",
 "NNYYNNNNNNNNNNN",
 "NNNNNYNNNNNYNNN",
 "NNNNNNNNNNNNNNY",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNNYNNNNNN",
 "NNNNNNNNNNNNNNN",
 "NNNNNNNNNNNNNNN",
 "YNNYYNNNNYNNNNN"};
		assertEquals(6, new FriendScore().highestScore(friends));
	}
}
