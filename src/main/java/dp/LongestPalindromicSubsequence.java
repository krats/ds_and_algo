// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestPalindromicSubsequence {
    public static int LongestPalindromicSubsequence(String sequence)
    {
        int N = sequence.length();
        int dp[][] = new int[N][N];
        for(int len = 1; len<=N; len++)
        {
            for(int i=0; i<N-len+1; i++)
            {
                int j =  i + len - 1;
                if(i==j)
                {
                    dp[i][j] = 1;
                }
                else if(sequence.charAt(i) == sequence.charAt(j))
                {
                    if(i+1 == j)
                    {
                        dp[i][j] = 2;
                    }
                    else
                    {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                }
                else
                {
                    dp[i][j] = (dp[i+1][j] > dp[i][j-1] ? dp[i+1][j] : dp[i][j-1]);
                }
            }
        }
        return dp[0][N-1];
    }

    public static void main(String args[])
    {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The lnegth of the lps is "+ LongestPalindromicSubsequence(seq));
    }
}
