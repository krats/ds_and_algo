// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Partition {
    public static boolean isPartitionable(int[] arr)
    {
        int sum = 0;
        int N = arr.length;
        for(int i=0; i<N; i++)
        {
            sum += arr[i];
        }
        if(sum%2 != 0)
        {
            return false;
        }
        sum /= 2;
        boolean dp[][] = new boolean[sum+1][N];
        for(int i=0; i<=sum; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(sum == 0)
                {
                    dp[i][j] = true;
                }
                else if(j==0)
                {
                    if(arr[j] == i)
                    {
                        dp[i][j] = true;
                    }
                }
                else
                {
                    dp[i][j] = dp[i][j-1];
                    if(arr[j] <= i)
                    {
                        dp[i][j] = dp[i][j] || dp[i-arr[j]][j-1];
                    }
                }
            }
        }
        return dp[sum][N-1];
    }

    public static void main(String args[])
    {
        int T;
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = in.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
            {
                arr[i] = in.nextInt();
            }
            System.out.println(isPartitionable(arr)?"YES":"NO");
        }
    }
}
