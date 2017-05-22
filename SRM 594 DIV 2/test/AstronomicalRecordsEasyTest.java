import org.junit.Test;
import static org.junit.Assert.*;

public class AstronomicalRecordsEasyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] A = new int[] {1,2,3,4};
		int[] B = new int[] {2,3,4,5};
		assertEquals(5, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] A = new int[] {1,2,3,4};
		int[] B = new int[] {2,4,6,8};
		assertEquals(4, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] A = new int[] {1,2,3,5,6,8,9};
		int[] B = new int[] {2,4,5,6,7,8,9};
		assertEquals(9, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] A = new int[] {1,2,3,4};
		int[] B = new int[] {6,7,8,9};
		assertEquals(6, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] A = new int[] {200,500};
		int[] B = new int[] {100,200,300,400,600,700,800,900};
		assertEquals(9, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] A = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] B = new int[] {6,7,8,9,10,11,12,13,14,15};
		assertEquals(15, new AstronomicalRecordsEasy().minimalPlanets(A, B));
	}
}
