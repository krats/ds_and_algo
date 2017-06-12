import org.junit.Test;
import static org.junit.Assert.*;

public class CirclesCountryTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] X = new int[] {0};
		int[] Y = new int[] {0};
		int[] R = new int[] {2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;
		assertEquals(0, new CirclesCountry().leastBorders(X, Y, R, x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] X = new int[] {0,-6,6};
		int[] Y = new int[] {0,1,2};
		int[] R = new int[] {2,2,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 5;
		int y2 = 1;
		assertEquals(2, new CirclesCountry().leastBorders(X, Y, R, x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] X = new int[] {1,-3,2,5,-4,12,12};
		int[] Y = new int[] {1,-1,2,5,5,1,1};
		int[] R = new int[] {8,1,2,1,1,1,2};
		int x1 = -5;
		int y1 = 1;
		int x2 = 12;
		int y2 = 1;
		assertEquals(3, new CirclesCountry().leastBorders(X, Y, R, x1, y1, x2, y2));
	}
	
	@Test()
	public void test3() {
		int[] X = new int[] {-3,2,2,0,-4,12,12,12};
		int[] Y = new int[] {-1,2,3,1,5,1,1,1};
		int[] R = new int[] {1,3,1,7,1,1,2,3};
		int x1 = 2;
		int y1 = 3;
		int x2 = 13;
		int y2 = 2;
		assertEquals(5, new CirclesCountry().leastBorders(X, Y, R, x1, y1, x2, y2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] X = new int[] {-107,-38,140,148,-198,172,-179,148,176,153,-56,-187};
		int[] Y = new int[] {175,-115,23,-2,-49,-151,-52,42,0,68,109,-174};
		int[] R = new int[] {135,42,70,39,89,39,43,150,10,120,16,8};
		int x1 = 102;
		int y1 = 16;
		int x2 = 19;
		int y2 = -108;
		assertEquals(3, new CirclesCountry().leastBorders(X, Y, R, x1, y1, x2, y2));
	}
}
