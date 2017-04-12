// Question Link: http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSizeSquareSubMatrix {
    public static int MaximumSizeSquare(int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;
        int dp[][] = new int[M][N];
        int max = 0;
        for(int i=0; i<M; i++)
        {
            dp[i][0] = matrix[i][0];
            if(dp[i][0] > max)
            {
                max = dp[i][0];
            }
        }
        for(int j=0; j<N; j++)
        {
            dp[0][j] = matrix[0][j];
            if(dp[0][j] > max)
            {
                max = dp[0][j];
            }
        }
        for(int i=1; i<M; i++)
        {
            for(int j=1; j<N; j++)
            {
                if(matrix[i][j] == 1)
                {
                    int min = dp[i-1][j-1];
                    min = dp[i-1][j] < min? dp[i-1][j]: min;
                    min = dp[i][j-1] < min? dp[i][j-1]: min;
                    dp[i][j] = min +1;
                    max = max > dp[i][j] ? max: dp[i][j];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
    return max;
    }

    public static void main(String args[])
    {
        int matrix[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(MaximumSizeSquare(matrix));
    }
}
