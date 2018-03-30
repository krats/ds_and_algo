package leetcode.LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        if (N == 0){
            return "";
        }
        int ans = 0;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[N][N];
        for (int len = 1; len <= N; len++) {
            for (int i = 0; i < N - len +1; i++) {
                int j = i + len - 1;
                if(len == 1) {
                    dp[i][j] = true;
                } else if(len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if(dp[i][j] && ans < len) {
                    ans = len;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
