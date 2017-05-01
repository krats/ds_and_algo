import org.junit.Test;
import static org.junit.Assert.*;

public class AttendanceShortTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] names = new String[] {"Justin"};
		String[] attendance = new String[] {"PAAPP"};
		assertArrayEquals(new String[] {"Justin" }, new AttendanceShort().shortList(names, attendance));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] names = new String[] {"Justin","Chris"};
		String[] attendance = new String[] {"PAAPP","PPPPA"};
		assertArrayEquals(new String[] {"Justin" }, new AttendanceShort().shortList(names, attendance));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] names = new String[] {"Sunny"};
		String[] attendance = new String[] {"PPPAM"};
		assertArrayEquals(new String[] { }, new AttendanceShort().shortList(names, attendance));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] names = new String[] {"Mansi", "Arjun", "Nikhil", "Taneja"};
		String[] attendance = new String[] {"PPPPMPPAPP", "AAMAAPP", "PPPPAAP", "PPPAAAMPP"};
		assertArrayEquals(new String[] {"Arjun", "Nikhil", "Taneja" }, new AttendanceShort().shortList(names, attendance));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] names = new String[] {};
		String[] attendance = new String[] {};
		assertArrayEquals(new String[] { }, new AttendanceShort().shortList(names, attendance));
	}
}
