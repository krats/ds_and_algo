import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PillarsDivTwo {
	
	public double maximalLength(int[] height, int w) {
		double dp[][] = new double[height.length][2];
		dp[0][0] = 0.0;
		dp[0][1] = 0.0;
		for(int i=1; i<height.length; i++)
		{
			dp[i][0] = Math.sqrt(w*w) + dp[i-1][0];
			dp[i][0] = Math.max(dp[i][0], Math.sqrt(w*w + (height[i-1]-1)*(height[i-1]-1)) + dp[i-1][1]);
			dp[i][1] = Math.sqrt(w*w + (height[i]-1)*(height[i]-1)) + dp[i-1][0];
			dp[i][1] = Math.max(dp[i][1], Math.sqrt(w*w + (height[i-1]-height[i])*(height[i-1]-height[i])) + dp[i-1][1]);
		}
		return Math.max(dp[height.length-1][0], dp[height.length-1][1]);
	}
}
