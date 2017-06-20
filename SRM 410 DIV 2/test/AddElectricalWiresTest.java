import org.junit.Test;
import static org.junit.Assert.*;

public class AddElectricalWiresTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] wires = new String[] {"000","000","000"};
		int[] gridConnections = new int[] {0};
		assertEquals(3, new AddElectricalWires().maxNewWires(wires, gridConnections));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] wires = new String[] {"000","000","000"};
		int[] gridConnections = new int[] {0,1};
		assertEquals(1, new AddElectricalWires().maxNewWires(wires, gridConnections));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] wires = new String[] {"01","10"};
		int[] gridConnections = new int[] {0};
		assertEquals(0, new AddElectricalWires().maxNewWires(wires, gridConnections));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] wires = new String[] {"00000","00000","00000","00000","00000"};
		int[] gridConnections = new int[] {0,1,2,3,4};
		assertEquals(0, new AddElectricalWires().maxNewWires(wires, gridConnections));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] wires = new String[] {"01000","10100","01010","00100","00000"};
		int[] gridConnections = new int[] {2,4};
		assertEquals(3, new AddElectricalWires().maxNewWires(wires, gridConnections));
	}
}
