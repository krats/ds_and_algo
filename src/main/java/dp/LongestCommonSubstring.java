// Question Link: http://www.geeksforgeeks.org/longest-common-substring/
package dp;

import java.util.Scanner;

/**
 * Created by karthikb on 15-05-2017.
 */
public class LongestCommonSubstring {
    public static int LongestCommonSubstring(String s1, String s2, int N, int M)
    {
        int dp[][] = new int[N][M];
        int ans = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    dp[i][j] = 1;
                    if(i>0 && j >0)
                    {
                        dp[i][j] += dp[i-1][j-1];
                    }
                    if(ans < dp[i][j])
                    {
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.next());
        for(int t=0; t<T; t++)
        {
            int N = Integer.parseInt(in.next());
            int M = Integer.parseInt(in.next());
            String s1 = in.next();
            String s2 = in.next();
            System.out.println(LongestCommonSubstring(s1, s2, N, M));
        }
    }
}
