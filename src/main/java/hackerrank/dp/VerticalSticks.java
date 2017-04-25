package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VerticalSticks {
    static double C(int n, int r)
    {
        r = Math.min(r, n-r);
        if(r == 0) return 1;
        double ans = 1;
        for(int k=n; k>n-r; k--)
        {
            ans*=k;
        }
        for(int k=1; k<=r; k++)
        {
            ans/=k;
        }
        return ans;
    }
    static double solution(int[] arr, int N)
    {
        Arrays.sort(arr);
        double ans = 0;
        for(int i=1; i<=N; i++)
        {
            int r = i;
            while(arr[r] == arr[i]) r--;
            int greater = N-r-1;
            int smaller = r;
            for(int j=1; j<=N; j++)
            {
                for(int k=0; k<=j-1 && k<=smaller; k++)
                {
                    if(k == j-1) ans += (k+1)*C(smaller,k)/(C(N-1, k)*N);
                    else ans += (k+1)*C(smaller,k)*greater/(N*(N-1)*C(N-2, k));
                }
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t < T; t++)
        {
            int N = in.nextInt();
            int arr[] = new int[N+1];
            arr[0] = -1;
            for(int i=1; i<=N;i ++)
            {
                arr[i] = in.nextInt();
            }
            double ans = Math.round(solution(arr, N)*100.0)/100.0;
            System.out.printf("%.2f\n", ans);
        }
    }
}
