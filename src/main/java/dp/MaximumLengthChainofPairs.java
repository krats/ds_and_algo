// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumLengthChainofPairs {
    public static int partition(int arr[][], int low, int high)
    {
        int pivot[] = arr[high];
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (arr[j][1] <= pivot[0])
            {
                i++;
                int temp[] = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp[] = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void sortPairs(int[][] pairs, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(pairs, low, high);
            sortPairs(pairs, low, pi-1);
            sortPairs(pairs, pi+1, high);
        }
    }

    public static int maxLengthChain(int[][] pairs)
    {
        int N = pairs.length;
        sortPairs(pairs, 0, N-1);
        int dp[] = new int[N];
        for(int i=0; i<N; i++)
        {
            dp[i] = 1;
            for(int j=i; j>=0; j--)
            {
                if(pairs[j][1] < pairs[i][0])
                {
                    dp[i] = dp[i] > dp[j] + 1? dp[i] : dp[j] + 1;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++)
        {
            if(dp[i] > ans)
            {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        int pairs1[][] = {{5, 24}, {15, 25}, {27, 40}, {50, 60}};
        System.out.println(maxLengthChain(pairs1));
        int pairs2[][] = {{5, 24}, {15, 28}, {27, 40}, {39, 60}, {50, 90}};
        System.out.println(maxLengthChain(pairs2));
        int pairs3[][] = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };
        System.out.println(maxLengthChain(pairs3));
    }
}
