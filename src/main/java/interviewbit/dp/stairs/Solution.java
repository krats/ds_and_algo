package interviewbit.dp.stairs;

public class Solution {
	public int climbStairs(int a) {
		int[] dp = new int[a+1];
		dp[a] = 1;
		for(int i=a-1; i>=0; i--){
			dp[i] = dp[i+1];
			if(i+2 <= a){
				dp[i] += dp[i+2];
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.climbStairs(100));
	}
}
