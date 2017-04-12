// Question Link: http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s)
    {
        int N = s.length();
        boolean dp[][] = new boolean[N][N];
        int ans_i = 0;
        int ans_j = 0;
        for(int len=1; len<=N; len++)
        {
            for(int i=0; i<N-len+1; i++)
            {
                int j = i + len - 1;
                if(i==j)
                {
                    dp[i][j] = true;
                    if(j-i+1 > ans_j-ans_i+1)
                    {
                        ans_i = i;
                        ans_j = j;
                    }
                }
                else if(i+1 == j && s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = true;
                    if(j-i+1 > ans_j-ans_i+1)
                    {
                        ans_i = i;
                        ans_j = j;
                    }
                }
                else if(s.charAt(i) == s.charAt(j))
                {
                    if(dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                        if(j-i+1 > ans_j-ans_i+1)
                        {
                            ans_i = i;
                            ans_j = j;
                        }
                    }
                }
            }
        }
        return s.substring(ans_i, ans_j+1);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int t=0; t<T; t++)
        {
            String s = in.nextLine();
            System.out.println(longestPalindrome(s));
        }
    }
}
