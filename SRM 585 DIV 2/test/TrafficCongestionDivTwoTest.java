import org.junit.Test;
import static org.junit.Assert.*;

public class TrafficCongestionDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int treeHeight = 1;
		assertEquals(1L, new TrafficCongestionDivTwo().theMinCars(treeHeight));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int treeHeight = 2;
		assertEquals(3L, new TrafficCongestionDivTwo().theMinCars(treeHeight));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int treeHeight = 3;
		assertEquals(5L, new TrafficCongestionDivTwo().theMinCars(treeHeight));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int treeHeight = 10;
		assertEquals(683L, new TrafficCongestionDivTwo().theMinCars(treeHeight));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int treeHeight = 60;
		assertEquals(768614336404564651L, new TrafficCongestionDivTwo().theMinCars(treeHeight));
	}
}
