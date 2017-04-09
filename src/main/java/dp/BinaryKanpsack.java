// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BinaryKanpsack {
    public static int BinaryKanpsack(int[] weights, int[] values, int knapsackWeight)
    {
        int N = weights.length;
        int[][] dp = new int[knapsackWeight+1][N+1];
        for(int i = 0; i <= knapsackWeight; i++)
        {
            for(int j = 0; j <= N; j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else if(weights[j-1] <= i)
                {
                    dp[i][j] = dp[i][j-1] > dp[i-weights[j-1]][j-1] + values[j-1] ? dp[i][j-1] : dp[i-weights[j-1]][j-1] + values[j-1];
                }
                else
                {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[knapsackWeight][N];
    }

    public static void main(String[] args)
    {
        int values[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int  kanpsackWeight = 50;
        System.out.println(BinaryKanpsack(weights, values, kanpsackWeight));
    }
}
