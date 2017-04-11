// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromePartitioning {
    public static int minPartitions(String s)
    {
        int N = s.length();
        Boolean isPalindrome[][] = new Boolean[N][N];
        int ans[][] = new int[N][N];
        for(int len=1; len <=N; len++)
        {
            for(int i=0; i<N-len+1; i++)
            {
                int j = i + len - 1;
                if(i==j)
                {
                    isPalindrome[i][j] = Boolean.TRUE;
                }
                else if(i+1 == j)
                {
                    if(s.charAt(i) == s.charAt(j))
                        isPalindrome[i][j] = Boolean.TRUE;
                    else
                        isPalindrome[i][j] = Boolean.FALSE;
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1])
                    {
                        isPalindrome[i][j] = Boolean.TRUE;
                    }
                    else
                    {
                        isPalindrome[i][j] = Boolean.FALSE;
                    }
                }
            }
        }
        for(int len=1; len <=N; len++)
        {
            for (int i = 0; i < N - len + 1; i++)
            {
                int j = i + len - 1;
                if(isPalindrome[i][j])
                {
                    ans[i][j] = 0;
                }
                else
                {
                    ans[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++)
                    {
                        if(ans[i][j] > 1+ans[i][k]+ans[k+1][j])
                        {
                            ans[i][j] = 1+ans[i][k]+ans[k+1][j];
                        }
                    }
                }
            }
        }
        return ans[0][N-1];
    }
    public static void main(String[] args)
    {
        String s = "ababbbabbababa";
        System.out.println("Minimum partitions required for "+s+" is = "+ minPartitions(s));
    }
}
