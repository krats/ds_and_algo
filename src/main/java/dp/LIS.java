// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LIS {

    public static int LIS(int[] inputArray, int N){
        int l_lis[] = new int[N];
        l_lis[0] = 1;
        for(int i = 0; i < N; i++)
        {
            l_lis[i] = 1;
            for(int j = i-1; j >= 0; j--)
            {
                if(inputArray[j] < inputArray[i] && l_lis[j] + 1 > l_lis[i])
                {
                    l_lis[i] = l_lis[j] + 1;
                }
            }
        }
        int ans = 1;
        for(int i = 0; i < N; i++)
        {
            if(l_lis[i] > ans)
            {
                ans = l_lis[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++)
        {
            int N = in.nextInt();
            int arr[] = new int[N];
            for(int j = 0; j < N; j ++)
            {
                arr[j] = in.nextInt();
            }
            System.out.println(LIS(arr, N));
        }
    }

}