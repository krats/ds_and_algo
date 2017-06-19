import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BiconnectedDiv2 {
	
	public int minimize(int[] w1, int[] w2) {
		int n = w1.length+1;
		int ans = 0;
		for(int i=0; i<n-1; i++)
		{
			ans += w1[i];
		}
		for(int i=0; i<n-2; i++)
		{
			ans += w2[i];
		}
		for(int i=1; i<n-2; i++)
		{
			if(w1[i] > 0)
				ans -= w1[i];
		}
		
		return ans;
	}
}
