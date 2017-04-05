// Question Link: http://practice.geeksforgeeks.org/problems/min-coin/0

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    public static int CoinChange(int[] coins, int M, int N)
    {
        int table[][] = new int[N+1][M];
        int x,y;
        for(int i = 0; i < M; i++)
        {
            table[0][i] = 1;
        }
        for(int i = 1; i < N+1; i++)
        {
            for(int j = 0; j < M; j++)
            {
               x = (i - coins[j] >= 0) ? table[i-coins[j]][j] : 0;
                y = (j >= 1) ? table[i][j-1] : 0;
                table[i][j] = x+y;
            }
        }
        return table[N][M-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int M = in.nextInt();
            int N = in.nextInt();
            int[] coins = new int[M];
            for (int j = 0; j < M; j++) {
                coins[j] = in.nextInt();
            }
            System.out.println(CoinChange(coins, M, N));
        }
    }
}
