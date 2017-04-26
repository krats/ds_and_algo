package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimeXOR {
    static void seive(boolean isnotPrime[], int N)
    {
        isnotPrime[0] = true;
        isnotPrime[1] = true;
        for(int i=2; i<N; i++)
        {
            if(!isnotPrime[i])
            {
                for(int j=2; j*i<N; j++)
                {
                    isnotPrime[j*i] = true;
                }
            }
        }
    }
    static long primeMultisets(ArrayList<Integer> arrlist, int[] arr, int N, boolean isnotPrime[])
    {
        long ans = 0;
        int dp[][] = new int[2][9000];
        int flag = 1;
        int k = arrlist.size();
        dp[0][0] = 1;
        for(int i=0; i<k; i++)
        {
            for(int j=0; j<8192; j++)
            {
                int ans1 = 0;
                ans1 += dp[flag^1][j]*(1 + arr[arrlist.get(i)]/2)%1000000007;
                ans1 %= 1000000007;
                ans1 += dp[flag^1][(j^arrlist.get(i))]*((1 + arr[arrlist.get(i)])/2)%1000000007;
                ans1 %= 1000000007;
                dp[flag][j] = ans1;
            }
            flag = flag^1;
        }
        for(int i=1; i<8192; i++)
        {
            if(!isnotPrime[i])
            {
                    ans += dp[flag^1][i];
                    ans %= 1000000007;
            }

        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        boolean isnotPrime[] = new boolean[9000];
        seive(isnotPrime, 9000);
        for(int t=0; t<T; t++)
        {
            int N = in.nextInt();
            int arr[] = new int[4501];
            ArrayList<Integer> arrlist = new ArrayList<Integer>(N);
            for(int i=0; i<N; i++)
            {
                int k = in.nextInt();
                arr[k] += 1;
            }
            for(int i=3500; i<4501; i++)
            {
                if(arr[i] >= 1)
                {
                    arrlist.add(i);
                }
            }
            System.out.println(primeMultisets(arrlist, arr, N, isnotPrime));
        }
    }
}
