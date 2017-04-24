package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Abbreviation {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int t=0; t<T; t++)
        {
            char[] arr1 = in.nextLine().toCharArray();
            char[] arr2 = in.nextLine().toCharArray();
            int N = arr1.length;
            int M = arr2.length;
            boolean dp[][] = new boolean[N][M];
            boolean arr[] = new boolean[N];
            for(int i=0; i<N; i++)
            {
                if(Character.isLowerCase(arr1[i]))
                {
                    arr[i] = true;
                }
                else
                {
                    break;
                }
            }
            if(N >= M)
            {
                for(int i=0; i<N; i++)
                {
                    for(int j=0; j<=Math.min(i,M-1); j++)
                    {
                        if(i==j)
                        {
                            dp[i][j] = arr1[i] == arr2[j] || Character.toUpperCase(arr1[i]) == arr2[j];
                            if(i != 0)
                            {
                                dp[i][j] = dp[i][j] && dp[i-1][j-1];
                            }
                        }
                        else
                        {
                            boolean ans = false;
                            if(Character.isLowerCase(arr1[i]))
                            {
                                for(int k=i-1; k>=j;k--)
                                {
                                    ans = ans || dp[k][j];
                                    if(ans)
                                        break;
                                    if(Character.isUpperCase(arr1[k]))
                                    {
                                        break;
                                    }
                                }
                            }
                            if(!ans && (arr1[i] == arr2[j] || Character.toUpperCase(arr1[i]) == arr2[j]) && (j > 0 || arr[i-1]))
                            {
                                if(j > 0)
                                    ans = dp[i-1][j-1];
                                else
                                    ans = true;
                            }
                            dp[i][j] = ans;
                        }
                    }
                }
            }
            if(dp[N-1][M-1])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
