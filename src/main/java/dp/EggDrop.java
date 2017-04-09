// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EggDrop {
    public static int EggDrop(int nEggs, int kFloors)
    {
        int dp[][] = new int[nEggs+1][kFloors+1];
        for(int i=1; i <= kFloors; i++)
        {
            dp[1][i] = i;
        }
        for(int i=1; i<=nEggs; i++)
        {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int i=2; i<=nEggs; i++)
        {
            for(int j=2; j<=kFloors; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=1; k<=j; k++)
                {
                    int val = 1 + (dp[i-1][k-1] > dp[i][j-k] ? dp[i-1][k-1] : dp[i][j-k]);
                    if(val < dp[i][j])
                        dp[i][j] = val;
                }
            }
        }
        return dp[nEggs][kFloors];
    }

    public static void main(String[] agrs)
    {
        int n,k,T;
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for(int i=0; i<T; i++)
        {
            n = in.nextInt();
            k = in.nextInt();
            System.out.println(EggDrop(n,k));
        }
    }

}
