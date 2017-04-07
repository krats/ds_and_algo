// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BinomialCoeffiecient {
    public static int binomialCoefficient(int n, int k)
    {
        int[][] ans = new int[n+1][k+1];
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= min(i,k); j++)
            {
                if(j==0)
                {
                    ans[i][j] = 1;
                }
                else if(i==j)
                {
                    ans[i][j] = 1;
                }
                else
                {
                    ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
                }
            }
        }
        return ans[n][k];
    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

    public static void main(String[] args)
    {
        System.out.println(binomialCoefficient(5,2));
    }
}
