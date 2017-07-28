package interviewbit.amazon.PalindromePartitioningII;

public class Solution {
	public int minCut(String a) {
		int n = a.length();
		boolean[][] isPalindrome = new boolean[n][n];
		for (int len = 1; len <= n; len++) {
			for (int i=0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if(len == 1) {
					isPalindrome[i][j] = true;
				}
				else if (len == 2) {
					isPalindrome[i][j] = (a.charAt(i) == a.charAt(j));
				}
				else {
					isPalindrome[i][j] = ((a.charAt(i) == a.charAt(j)) && isPalindrome[i+1][j-1]);
				}
			}
		}
		int[][] dp = new int[n][n];
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				dp[i][j] = -1;
				if(isPalindrome[i][j]) {
					dp[i][j] = 0;
				}
				else {
					for(int k=i+1; k<=j; k++) {
						if(dp[i][k-1] != -1 && dp[k][j] != -1) {
							if(dp[i][j] == -1) {
								dp[i][j] = dp[i][k-1] + dp[k][j] + 1;
							}
							else {
								dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k][j] + 1);
							}
						}
					}
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.minCut("bbab"));
	}
}
