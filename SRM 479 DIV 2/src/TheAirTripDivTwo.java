import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheAirTripDivTwo {
	
	public int find(int[] flights, int fuel) {
		int count = 0;
		while(count < flights.length && fuel >= flights[count]) {
			fuel -= flights[count];
			count += 1;
		}
		return count;
	}
}
