// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RodCutting {
    public static int cutRod(int price[], int rodLength)
    {
        int dp[] = new int[rodLength+1];
        dp[0] = 0;
        dp[1] = price[0];
        for(int i=2; i<=rodLength; i++)
        {
            dp[i] = 0;
            for(int j=1; j<=i; j++)
            {
                dp[i] = dp[i] > price[j-1] + dp[i-j]? dp[i]: price[j-1] + dp[i-j];
            }
        }
        return dp[rodLength];
    }

    public static void main(String[] args)
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRod(arr, size));
    }
}
