import org.junit.Test;
import static org.junit.Assert.*;

public class ChangingSoundsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] changeIntervals = new int[] {5, 3, 7};
		int beginLevel = 5;
		int maxLevel = 10;
		assertEquals(10, new ChangingSounds().maxFinal(changeIntervals, beginLevel, maxLevel));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] changeIntervals = new int[] {15, 2, 9, 10};
		int beginLevel = 8;
		int maxLevel = 20;
		assertEquals(-1, new ChangingSounds().maxFinal(changeIntervals, beginLevel, maxLevel));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] changeIntervals = new int[] {74,39,127,95,63,140,99,96,154,18,137,162,14,88};
		int beginLevel = 40;
		int maxLevel = 243;
		assertEquals(238, new ChangingSounds().maxFinal(changeIntervals, beginLevel, maxLevel));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] changeIntervals = new int[] {214, 40, 203, 333, 118, 575, 217, 386, 319, 548, 137, 34, 415, 473, 140, 309, 333, 314, 358, 17, 330, 301, 188, 241, 542, 49, 226, 65, 423, 452, 288, 369, 281, 288, 485, 460, 506, 636, 520, 262, 489, 493, 405, 227, 507, 384, 544, 666, 118, 582};
		int beginLevel = 367;
		int maxLevel = 1000;
		assertEquals(999, new ChangingSounds().maxFinal(changeIntervals, beginLevel, maxLevel));
	}
}
