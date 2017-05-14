public class DivFreed2 {
	public int count(int n, int k) {
		int dp[][] = new int[2][k+1];
		int flag = 0;
		for(int t=1; t<=k; t++) {
			dp[flag][t] = 1;
		}
		int prev_sum = k;
		for(int i=2; i<=n; i++) {
			flag = flag^1;
            int curr_sum = 0;
			for(int j=1; j<=k; j++) {
				dp[flag][j] = prev_sum;
				int curr_item = 0;
				for(int t=2*j; t<=k; t+=j) {
                    curr_item = (curr_item +  dp[flag^1][t])%1000000007;
				}
				dp[flag][j] = (dp[flag][j] + 1000000007 - curr_item)%1000000007;
				curr_sum = (curr_sum + dp[flag][j])%1000000007;
			}
			prev_sum = curr_sum;
		}
		return prev_sum;
	}
}
