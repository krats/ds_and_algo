import org.junit.Test;
import static org.junit.Assert.*;

public class RouteIntersectionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 1;
		int[] coords = new int[] {1};
		String moves = "+";
		assertEquals("VALID", new RouteIntersection().isValid(N, coords, moves));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 2;
		int[] coords = new int[] {1,2,1,2};
		String moves = "++--";
		assertEquals("NOT VALID", new RouteIntersection().isValid(N, coords, moves));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 3;
		int[] coords = new int[] {1,2,3,1,2};
		String moves = "+++--";
		assertEquals("VALID", new RouteIntersection().isValid(N, coords, moves));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 344447;
		int[] coords = new int[] {132,51717,628,344447,628,51717,344447,2};
		String moves = "+-++-+--";
		assertEquals("NOT VALID", new RouteIntersection().isValid(N, coords, moves));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 1;
		int[] coords = new int[] {1,1};
		String moves = "+-";
		assertEquals("NOT VALID", new RouteIntersection().isValid(N, coords, moves));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 990630;
		int[] coords = new int[] {833196,524568,361663,108056,28026,824639,269315,440977,440977,765458,
988451,242440,948414,130873,773990,765458,130873,28026,853121,553636,
581069,82254,735536,833196,898562,898562,940783,988451,540613,317306,
623194,940783,571384,988451,108056,514374,97664};
		String moves = "--+---+-+++-+-+---++-++-+---+-+--+-++";
		assertEquals("NOT VALID", new RouteIntersection().isValid(N, coords, moves));
	}
}
