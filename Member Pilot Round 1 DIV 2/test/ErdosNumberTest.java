import org.junit.Test;
import static org.junit.Assert.*;

public class ErdosNumberTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] publications = new String[] {"ERDOS"};
		assertArrayEquals(new String[] {"ERDOS 0" }, new ErdosNumber().calculateNumbers(publications));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] publications = new String[] {"KLEITMAN LANDER", "ERDOS KLEITMAN"};
		assertArrayEquals(new String[] {"ERDOS 0", "KLEITMAN 1", "LANDER 2" }, new ErdosNumber().calculateNumbers(publications));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] publications = new String[] {"ERDOS A", "A B", "B AA C"};
		assertArrayEquals(new String[] {"A 1", "AA 3", "B 2", "C 3", "ERDOS 0" }, new ErdosNumber().calculateNumbers(publications));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] publications = new String[] {"ERDOS B", "A B C", "B A E", "D F"};
		assertArrayEquals(new String[] {"A 2", "B 1", "C 2", "D", "E 2", "ERDOS 0", "F" }, new ErdosNumber().calculateNumbers(publications));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] publications = new String[] {"ERDOS KLEITMAN", "CHUNG GODDARD KLEITMAN WAYNE", "WAYNE GODDARD KLEITMAN", 
 "ALON KLEITMAN", "DEAN GODDARD WAYNE KLEITMAN STURTEVANT"};
		assertArrayEquals(new String[] {"ALON 2", "CHUNG 2", "DEAN 2", "ERDOS 0", "GODDARD 2", "KLEITMAN 1", "STURTEVANT 2", "WAYNE 2" }, new ErdosNumber().calculateNumbers(publications));
	}
}
