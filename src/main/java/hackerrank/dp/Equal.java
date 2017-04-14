package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Equal {
    static int findCount(int n)
    {
        int ans = 0;
        ans += n/5;
        n = n%5;
        ans += n/2;
        n = n%2;
        ans += n;
        return ans;
    }
    static long equal(int numbers[], int N)
    {
        long ans = Long.MAX_VALUE;
        int min = numbers[0];
        for(int i=0; i<N; i++)
        {
            if(min > numbers[i])
            {
                min = numbers[i];
            }
        }
        long curr_ans;
        for(int k=0; k<5; k++)
        {
            curr_ans = 0;
            for (int i = 0; i < N; i++) {
                curr_ans += findCount(numbers[i] -min +k);
            }
            if(ans > curr_ans)
            {
                ans = curr_ans;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = in.nextInt();
            int numbers[] = new int[N];
            for(int i=0; i<N; i++)
            {
                numbers[i] = in.nextInt();
            }
            System.out.println(equal(numbers, N));
        }
    }
}
