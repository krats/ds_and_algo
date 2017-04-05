// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EDIT_DISTANCE {
    public static int EditDistance(String s1, String s2, int M, int N)
    {
        int dp[][] = new int[M+1][N+1];
        dp[0][0] = 0;
        for(int i = 1; i <= M; i++)
        {
            dp[i][0] = i;
        }
        for(int j = 1; j <= N; j ++)
        {
            dp[0][j] = j;
        }
        for(int i = 1; i <= M; i++)
        {
            for(int j = 1; j <= N; j ++)
            {
                dp[i][j] = dp[i-1][j] + 1 < dp[i][j-1] +1 ? dp[i-1][j] + 1 : dp[i][j-1] + 1;
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i][j] < dp[i-1][j-1] ? dp[i][j] : dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = dp[i][j] < dp[i-1][j-1] + 1 ? dp[i][j] : dp[i-1][j-1] + 1;
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
            String s = in.nextLine();
            String[] words=s.split("\\s");
            System.out.println(EditDistance(words[0], words[1], M, N));
        }
    }
}
