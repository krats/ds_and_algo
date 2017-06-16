import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleWeightsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] weight1 = new String[] {"..14",
 "..94",
 "19..",
 "44.."};
		String[] weight2 = new String[] {"..94",
 "..14",
 "91..",
 "44.."};
		assertEquals(64, new DoubleWeights().minimalCost(weight1, weight2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] weight1 = new String[] {"..14",
 "..14",
 "11..",
 "44.."};
		String[] weight2 = new String[] {"..94",
 "..94",
 "99..",
 "44.."};
		assertEquals(36, new DoubleWeights().minimalCost(weight1, weight2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] weight1 = new String[] {"..",
 ".."};
		String[] weight2 = new String[] {"..",
 ".."};
		assertEquals(-1, new DoubleWeights().minimalCost(weight1, weight2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] weight1 = new String[] {".....9",
 "..9...",
 ".9.9..",
 "..9.9.",
 "...9.9",
 "9...9."};
		String[] weight2 = new String[] {".....9",
 "..9...",
 ".9.9..",
 "..9.9.",
 "...9.9",
 "9...9."};
		assertEquals(2025, new DoubleWeights().minimalCost(weight1, weight2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] weight1 = new String[] {".4...1",
 "4.1...",
 ".1.1..",
 "..1.1.",
 "...1.1",
 "1...1."};
		String[] weight2 = new String[] {".4...1",
 "4.1...",
 ".1.1..",
 "..1.1.",
 "...1.1",
 "1...1."};
		assertEquals(16, new DoubleWeights().minimalCost(weight1, weight2));
	}
}
