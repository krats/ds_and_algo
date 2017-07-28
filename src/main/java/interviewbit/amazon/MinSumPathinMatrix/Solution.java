package interviewbit.amazon.MinSumPathinMatrix;

import java.util.ArrayList;

public class Solution {
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		if(n == 0)
			return 0;
		int m = a.get(0).size();
		int[][] dp = new int[2][m];
		int index = 0;
		for(int i=0; i< m; i++) {
			dp[index][i] = a.get(0).get(i);
			if(i > 0)
				dp[index][i] += dp[index][i-1];
		}
		for(int i=1; i<n; i++) {
			index ^= 1;
			for (int j=0; j<m; j++) {
				if( j > 0)
					dp[index][j] = a.get(i).get(j) + Math.min(dp[index][j-1], dp[index^1][j]);
				else
					dp[index][j] = a.get(i).get(j) + dp[index^1][j];
			}
		}
		return dp[index][m-1];
	}
}
