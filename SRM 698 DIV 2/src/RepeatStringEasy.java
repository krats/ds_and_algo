public class RepeatStringEasy {
	public int lcs(String s1, String s2, int dp[][], int n) {
		dp[0][0] = dp[1][0] = dp[0][1] = 0;
		for(int i=1; i<s1.length()+1; i++)
		{
			for(int j=1; j<s2.length()+1; j++)
			{
				dp[i][j] = 0;
				if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
			}
		}
		return dp[s1.length()][s2.length()];
	}
	public int maximalLength(String s) {
		int ans = 0;
		int n = s.length();
		int dp[][] = new int[n+1][n+1];
		for(int i=1; i<n; i++) {
			int current = lcs(s.substring(0,i), s.substring(i,n), dp, n);
			if(current > ans)
				ans = current;
		}
		return 2*ans;
	}
}
