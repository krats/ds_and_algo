import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CostOfDancing {
	
	public int minimum(int K, int[] danceCost) {
		Arrays.sort(danceCost);
		int ans = 0;
		for(int i=0; i<K; i++)
			ans += danceCost[i];
		return ans;
	}
}
