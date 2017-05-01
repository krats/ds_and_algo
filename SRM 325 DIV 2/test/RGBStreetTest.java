import org.junit.Test;
import static org.junit.Assert.*;

public class RGBStreetTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] houses = new String[] {"1 100 100", "100 1 100", "100 100 1"};
		assertEquals(3, new RGBStreet().estimateCost(houses));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] houses = new String[] {"1 100 100", "100 100 100", "1 100 100"};
		assertEquals(102, new RGBStreet().estimateCost(houses));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] houses = new String[] {"26 40 83", "49 60 57", "13 89 99"};
		assertEquals(96, new RGBStreet().estimateCost(houses));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] houses = new String[] {"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"};
		assertEquals(208, new RGBStreet().estimateCost(houses));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] houses = new String[] {"71 39 44", "32 83 55", "51 37 63", "89 29 100", 
 "83 58 11", "65 13 15", "47 25 29", "60 66 19"};
		assertEquals(253, new RGBStreet().estimateCost(houses));
	}
}
