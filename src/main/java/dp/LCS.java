// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LCS {
    public static int LCS(String s1, String s2, int M, int N)
    {
        int dp[][] = new int[M+1][N+1];
        for(int i = 1; i <= M; i++)
        {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= N; j ++)
        {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= M; i++)
        {
            for(int j = 1; j <= N; j ++)
            {
                dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i][j] > dp[i-1][j-1] + 1 ? dp[i][j] : dp[i-1][j-1] + 1;
                }
            }
        }
        return dp[M][N];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++)
        {
            int M = in.nextInt();
            int N = in.nextInt();
            in.nextLine();
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            System.out.println(LCS(s1, s2, M, N));
        }
    }
}
