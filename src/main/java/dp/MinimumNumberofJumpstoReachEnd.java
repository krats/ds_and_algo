// Question Link: http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinimumNumberofJumpstoReachEnd {
    public static int minSteps(int[] numbers)
    {
        int N = numbers.length;
        int dp[] = new int[N];
        dp[N-1] = 0;
        for(int i=N-2; i>=0; i--)
        {
            if(numbers[i] == 0)
            {
                dp[i] = Integer.MAX_VALUE;
            }
            else if(N-i+1 <= numbers[i])
            {
                dp[i] = 1;
            }
            else
            {
                dp[i] = Integer.MAX_VALUE;
                for(int j=i+1; j<min(i+numbers[i]+1,N); j++)
                {
                    if(dp[i] > dp[j] + 1 && dp[j]!= Integer.MAX_VALUE)
                    {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[0] == Integer.MAX_VALUE? -1: dp[0];
    }

    public static int min(int a, int b)
    {
        return a<b?a:b;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = in.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
            {
                arr[i] = in.nextInt();
            }
            System.out.println(minSteps(arr));
        }
    }
}
