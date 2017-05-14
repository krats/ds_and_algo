import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TrafficCongestionDivTwo {
	
	public long theMinCars(int treeHeight) {
		long ans[] = new long[Math.max(2,treeHeight+1)];
		ans[0] = 1;
		ans[1] = 1;
		for(int i=2; i<=treeHeight; i++) {
			ans[i] = 1;
			for(int j=i-2; j>=0; j--) {
				ans[i] += 2*ans[j];
			}
		}
		return ans[treeHeight];
	}
}