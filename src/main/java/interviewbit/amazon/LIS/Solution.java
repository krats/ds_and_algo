package interviewbit.amazon.LIS;

import java.util.List;

public class Solution {
	public int lis(final List<Integer> a) {
		int n = a.size();
		int[] dp = new int[n];
		int ans = 0;
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=i-1; j >=0; j++) {
				if(a.get(i) > a.get(j) && dp[i] < dp[j] + 1)
				{
					dp[i] = dp[j]+1;
				}
			}
			if(ans < dp[i]) {
				ans = dp[i];
			}
		}
		return ans;
	}
}
