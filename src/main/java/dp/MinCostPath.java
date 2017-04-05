// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinCostPath {
    public static int min(int i, int j, int k)
    {
        int ans = i < j? i : j;
        ans = ans < k ? ans : k;
        return ans;
    }
    public static int MinCostPath(int[][] matrix, int M, int N)
    {
        int mincost[][] = new int[M][N];
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if( i == 0 && j == 0)
                {
                    mincost[i][j] = matrix[i][j];
                }
                else if(i == 0)
                {
                    mincost[i][j] = matrix[i][j] + mincost[i][j-1];
                }
                else if(j == 0)
                {
                    mincost[i][j] = matrix[i][j] + mincost[i - 1][j];
                }
                else
                {
                    mincost[i][j] = matrix[i][j] + min(mincost[i-1][j], mincost[i][j-1], mincost[i-1][j-1]);
                }
            }
        }
        return mincost[M-1][N-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++)
        {
            int M = in.nextInt();
            int N = in.nextInt();
            int matrix[][] = new int[M][N];
            for(int j = 0; j < M; j ++)
            {
                for(int k = 0; k < N; k++)
                {
                    matrix[j][k] = in.nextInt();
                }
            }
            System.out.println(MinCostPath(matrix, M, N));
        }
    }
}
