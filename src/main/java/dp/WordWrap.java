// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WordWrap {
    public static String wordWrap(String s, int lineLength)
    {
        String words[] = s.split("\\s+");
        int N = words.length;
        int lc[][] = new int[N][N];
        int lengths[] = new int[N];
        for(int i=0 ; i<N; i++)
        {
            lengths[i] = words[i].length();
        }
        for(int i=0; i<N; i++)
        {
            for(int j=i; j<N; j++)
            {
                lc[i][j] = Integer.MAX_VALUE;
                int length = 0;
                for(int k=i; k<=j; k++)
                {
                    length += lengths[k];
                }
                if(length + j - i<= lineLength)
                {
                    lc[i][j] = (lineLength -length - j + i)^3;
                }
            }
        }
        int costs[] = new int[N+1];
        int p[] = new int[N+1];
        costs[0] = 0;
        for(int j=1; j<=N; j++)
        {
            costs[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++)
            {
                if (costs[i-1] != Integer.MAX_VALUE && lc[i-1][j-1] != Integer.MAX_VALUE && (costs[i-1] + lc[i-1][j-1] < costs[j]))
                {
                    costs[j] = costs[i-1] + lc[i-1][j-1];
                    p[j] = i;
                }
            }
        }
        return solution(words, p, N);
    }

    public static String solution(String[] words, int p[], int N)
    {
        String ans = "";
        if(N == 0)
        {
            return "";
        }
        else
        {
            ans = solution(words, p, p[N]-1);
        }
        String line = words[p[N]-1];
        for(int i=p[N]+1; i<=N; i++)
        {
            line += " " + words[i-1];
        }
        if(ans == "")
        {
            ans = line;
        }
        else
        {
            ans = ans + "\n" + line;
        }
        return ans;
    }

    public static void main(String args[])
    {
        String s = "aaa bb cc ddddd";
        System.out.println(wordWrap(s, 6));
    }
}
