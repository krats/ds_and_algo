// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestBitonicSubsequence {
    public static int LBS(int numbers[])
    {
        int N = numbers.length;
        int lis[] = new int[N];
        int lds[] = new int[N];
        for(int i=0; i<N; i++)
        {
            lis[i] = 1;
            for(int j=i; j>=0; j--)
            {
                if(numbers[j] < numbers[i])
                {
                    int val = 1 + lis[j];
                    if(val > lis[i])
                    {
                        lis[i] = val;
                    }
                }
            }
        }
        for(int i=N-1; i>=0; i--)
        {
            lds[i] = 1;
            for(int j=i; j<N; j++)
            {
                if(numbers[j] < numbers[i])
                {
                    int val = 1 + lds[j];
                    if(val > lds[i])
                    {
                        lds[i] = val;
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++)
        {
            int val = lis[i] + lds[i] -1;
            if(val > ans)
            {
                ans = val;
            }
        }
        return ans;
    }
    public static void main (String[] args)
    {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        int n = arr.length;
        System.out.println("Length of LBS is "+ LBS(arr));
    }
}
