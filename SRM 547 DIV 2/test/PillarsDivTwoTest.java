import org.junit.Test;
import static org.junit.Assert.*;

public class PillarsDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] height = new int[] {3,3,3};
		int w = 2;
		assertEquals(5.656854249492381, new PillarsDivTwo().maximalLength(height, w), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] height = new int[] {1,1,1,1};
		int w = 100;
		assertEquals(300.0, new PillarsDivTwo().maximalLength(height, w), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] height = new int[] {100,2,100,2,100};
		int w = 4;
		assertEquals(396.32310051270036, new PillarsDivTwo().maximalLength(height, w), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] height = new int[] {2,1,1,2};
		int w = 1;
		assertEquals(3.82842712474619, new PillarsDivTwo().maximalLength(height, w), 1e-9);
	}
}
