import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MutaliskEasy {
	
	public int minimalAttacks(int[] x) {
		if(x.length == 1)
		{
			return (x[0]%9)==0? x[0]/9 : 1+x[0]/9;
		}
		if(x.length == 2)
		{
			x = new int[]{x[0], x[1], 0};
		}
		int n = 60;
		int dp[][][] = new int[n+1][n+1][n+1];
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=n; j++)
			{
				for(int k=0; k<=n; k++)
				{
					dp[i][j][k] = dp[Math.max(0, i-9)][Math.max(0, j-3)][Math.max(0, k-1)];
					dp[i][j][k] = Math.min(dp[i][j][k], dp[Math.max(0, i-3)][Math.max(0, j-9)][Math.max(0, k-1)]);
					dp[i][j][k] = Math.min(dp[i][j][k], dp[Math.max(0, i-1)][Math.max(0, j-9)][Math.max(0, k-3)]);
					dp[i][j][k] = Math.min(dp[i][j][k], dp[Math.max(0, i-9)][Math.max(0, j-1)][Math.max(0, k-3)]);
					dp[i][j][k] = Math.min(dp[i][j][k], dp[Math.max(0, i-1)][Math.max(0, j-3)][Math.max(0, k-9)]);
					dp[i][j][k] = Math.min(dp[i][j][k], dp[Math.max(0, i-3)][Math.max(0, j-1)][Math.max(0, k-9)]);
					dp[i][j][k] += 1;
					if(i==0 && j==0 && k==0)
						dp[i][j][k] = 0;
				}
			}
		}
		return dp[x[0]][x[1]][x[2]];
	}
}
