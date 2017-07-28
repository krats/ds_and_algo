package interviewbit.amazon.WaysToDecode;

public class Solution {
	public int numDecodings(String a) {
		int n = a.length();
		int dp[] = new int[n+1];
		dp[n] = 1;
		int current=0;
		for(int i=n-1; i>=0; i--) {
			int c = a.charAt(i) - '0';
			if(!(c >= 1 && c <= 9))
			{
				if(i-1 >= 0 && (a.charAt(i-1) - '0' == 1 || a.charAt(i-1) - '0' == 2)){
					continue;
				}
				return 0;
			}
			current = dp[i+1];
			if(i +1 < n) {
				c = c*10 + (a.charAt(i+1) - '0');
				if(c <= 26) {
					current += dp[i+2];
				}
			}
			dp[i] = current;
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numDecodings("2611055971756562"));
	}
}
