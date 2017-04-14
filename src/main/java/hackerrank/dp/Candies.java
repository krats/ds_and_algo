package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Candies {
    static long minCandies(int[] scores, int N)
    {
        int dp[] = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++)
        {
            dp[i] = 1;
            if(scores[i] < scores[i-1])
            {
                for(int j=i-1; j>=0; j--)
                {
                    if(scores[j] > scores[j+1] && dp[j] <= dp[j+1])
                    {
                        dp[j] = dp[j+1]+1;
                    }
                    if(j != 0 && scores[j] >= scores[j-1])
                    {
                        break;
                    }
                }
            }
            if(scores[i] > scores[i-1])
            {
                dp[i] = dp[i-1]+1;
            }
        }
        long ans = 0;
        for(int i=0; i<N; i++)
        {
            ans += dp[i];
        }
        return ans;
    }

    static long minCandies2(int[] scores, int N)
    {
        int dp[] = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++)
        {
            dp[i] = 1;
            if(scores[i] > scores[i-1])
            {
                dp[i] = dp[i-1]+1;
            }
        }
        for(int i=N-2; i>=0; i--)
        {
            if(scores[i+1] < scores[i])
            {
                dp[i] = Math.max(dp[i], dp[i+1]+1);
            }
        }
        long ans = 0;
        for(int i=0; i<N; i++)
        {
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int scores[] = new int[N];
        for(int i=0; i<N; i++)
        {
            scores[i] = in.nextInt();
        }
        System.out.println(minCandies2(scores,N));
    }
}
