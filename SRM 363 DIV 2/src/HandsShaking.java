public class HandsShaking {
	public long countPerfect(int n) {
		long dp[] = new long[n + 1];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 4; i <= n; i += 2) {
			for (int j = 0; j < i; j += 2) {
				dp[i] += dp[j] * dp[i-j-2];
			}
		}
		return dp[n];
	}
}
