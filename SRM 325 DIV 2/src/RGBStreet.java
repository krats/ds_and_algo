import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RGBStreet {
	
	public int estimateCost(String[] houses) {
		int N = houses.length;
		int dp[][] = new int[N+1][3];
		dp[0][0] = dp[0][1] = dp[0][2] = 0;
		for(int i=1; i<=N; i++)
		{
			int[] colors = Arrays.stream(houses[i-1].split("\\s+")).mapToInt(Integer::parseInt).toArray();
			dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + colors[0];
			dp[i][1] = min(dp[i-1][2], dp[i-1][0]) + colors[1];
			dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + colors[2];
		}
		return Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
	}
}
