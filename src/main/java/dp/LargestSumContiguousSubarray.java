// Question Link: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestSumContiguousSubarray {

    public static int largestSumContiguousSubarray(int numbers[])
    {
        int N = numbers.length;
        int dp[] = new int[N];
        dp[0] = numbers[0];
        for(int i=1; i<N; i++)
        {
            if(dp[i-1] > 0)
            {
                dp[i] = dp[i-1]+numbers[i];
            }
            else
            {
                dp[i] = numbers[i];
            }
        }
        int ans = -Integer.MAX_VALUE;
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
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int n = in.nextInt();
            int numbers[] = new int[n];
            for(int i=0; i<n; i++)
            {
                numbers[i] = in.nextInt();
            }
            System.out.println(largestSumContiguousSubarray(numbers));
        }
    }
}
