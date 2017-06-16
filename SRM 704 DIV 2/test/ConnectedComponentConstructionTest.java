import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectedComponentConstructionTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] s = new int[] {2,1,1,2,1};
		assertArrayEquals(new String[] {"NNNYN", "NNNNN", "NNNNN", "YNNNN", "NNNNN" }, new ConnectedComponentConstruction().construct(s));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] s = new int[] {1,1,1,1};
		assertArrayEquals(new String[] {"NNNN", "NNNN", "NNNN", "NNNN" }, new ConnectedComponentConstruction().construct(s));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] s = new int[] {3,3,3};
		assertArrayEquals(new String[] {"NYY", "YNY", "YYN" }, new ConnectedComponentConstruction().construct(s));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] s = new int[] {4,4,4,4,4};
		assertArrayEquals(new String[] { }, new ConnectedComponentConstruction().construct(s));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] s = new int[] {1};
		assertArrayEquals(new String[] {"N" }, new ConnectedComponentConstruction().construct(s));
	}
}
