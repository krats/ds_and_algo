import org.junit.Test;
import static org.junit.Assert.*;

public class SalaryCalculatorTest {
	
	@Test(timeout=2000)
	public void test0() {
		int P1 = 10;
		int P2 = 15;
		int salary = 1000;
		assertEquals(100.0, new SalaryCalculator().calcHours(P1, P2, salary), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int P1 = 10;
		int P2 = 15;
		int salary = 3000;
		assertEquals(266.6666666666667, new SalaryCalculator().calcHours(P1, P2, salary), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int P1 = 100;
		int P2 = 1;
		int salary = 1000000;
		assertEquals(980200.0, new SalaryCalculator().calcHours(P1, P2, salary), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int P1 = 17;
		int P2 = 23;
		int salary = 973546;
		assertEquals(42380.260869565216, new SalaryCalculator().calcHours(P1, P2, salary), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test4() {
		int P1 = 82;
		int P2 = 8;
		int salary = 12140;
		assertEquals(148.0487804878049, new SalaryCalculator().calcHours(P1, P2, salary), 1e-9);
	}
}
