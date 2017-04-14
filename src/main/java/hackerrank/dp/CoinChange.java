package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    static long coinChange(int[] coins, int N, int M)
    {
        long dp[][] = new long[N+1][M+1];
        for(int i=0; i<=M; i++)
        {
            dp[0][i] = 1;
        }
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                dp[i][j] = dp[i][j-1];
                if(coins[j-1] <= i)
                {
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[N][M];
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int coins[] = new int[M];
        for(int i = 0; i<M; i++)
        {
            coins[i] = in.nextInt();
        }
        System.out.println(coinChange(coins, N, M));
    }
}
