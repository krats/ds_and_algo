package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockandCost {

    static int sherlockAndCost(int numbers[], int N)
    {
        int ans = 0;
        int dp[][] = new int[N][2];
        for(int i=1; i<N; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0]+1-1, dp[i-1][1]+Math.abs(1-numbers[i-1]));
            dp[i][1] = Math.max(dp[i-1][0]+numbers[i]-1, dp[i-1][1]+Math.abs(numbers[i]-numbers[i-1]));
        }
        return Math.max(dp[N-1][0], dp[N-1][1]);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = in.nextInt();
            int numbers[] = new int[N];
            for(int i=0; i<N; i++)
            {
                numbers[i] = in.nextInt();
            }
            System.out.println(sherlockAndCost(numbers, N));
        }
    }
}
