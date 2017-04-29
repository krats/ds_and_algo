import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ColorfulRoad {
	
	public int getMin(String road) {
		int N = road.length();
		int dp[] = new int[N];
		for(int i=N-2; i>=0; i--)
		{
			int ans = Integer.MAX_VALUE;
			for(int j=i+1; j<N; j++)
			{
				if(dp[j] != Integer.MAX_VALUE && (road.charAt(i) == 'R' && road.charAt(j) == 'G' || road.charAt(i) == 'G' && road.charAt(j) == 'B' || road.charAt(i) == 'B' && road.charAt(j) == 'R'))
				{
					ans = Math.min(ans, dp[j]+(j-i)*(j-i));
				}
			}
			dp[i] = ans;
		}
		if(dp[0] == Integer.MAX_VALUE)
			return -1;
		return dp[0];
	}
}
