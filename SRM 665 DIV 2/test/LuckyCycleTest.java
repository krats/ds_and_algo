import org.junit.Test;
import static org.junit.Assert.*;

public class LuckyCycleTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] edge1 = new int[] {1};
		int[] edge2 = new int[] {2};
		int[] weight = new int[] {4};
		assertArrayEquals(new int[] { }, new LuckyCycle().getEdge(edge1, edge2, weight));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] edge1 = new int[] {1, 3, 2, 4};
		int[] edge2 = new int[] {2, 2, 4, 5};
		int[] weight = new int[] {4, 7, 4, 7};
		assertArrayEquals(new int[] {1, 5, 7 }, new LuckyCycle().getEdge(edge1, edge2, weight));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] edge1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] edge2 = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] weight = new int[] {4, 4, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7};
		assertArrayEquals(new int[] {1, 12, 7 }, new LuckyCycle().getEdge(edge1, edge2, weight));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] edge1 = new int[] {1, 2, 3, 5, 6};
		int[] edge2 = new int[] {2, 3, 4, 3, 5};
		int[] weight = new int[] {4, 7, 7, 7, 7};
		assertArrayEquals(new int[] {1, 4, 4 }, new LuckyCycle().getEdge(edge1, edge2, weight));
	}
}
