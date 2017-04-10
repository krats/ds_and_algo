// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSumIncreasingSubsequence {
    public static int maxSumIS(int numbers[])
    {
        int N = numbers.length;
        int dp[] = new int[N];
        dp[0] = numbers[0];
        for(int i=1; i<N; i++)
        {
            dp[i] = numbers[i];
            for(int j=i; j>=0; j--)
            {
                if(numbers[j] < numbers[i])
                {
                    int cval = dp[j] < 0? numbers[i] : numbers[i]+dp[j];
                    if(cval > dp[i])
                    {
                        dp[i] = cval;
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            if(ans < dp[i])
            {
                ans = dp[i];
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int T;
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for(int i=0; i<T; i++)
        {
            int N = in.nextInt();
            int numbers[] = new int[N];
            for(int j=0; j<N; j++)
            {
                numbers[j] = in.nextInt();
            }
            System.out.println(maxSumIS(numbers));
        }
    }

}
