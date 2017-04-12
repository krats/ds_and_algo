// Question Link: http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fibonacci {
    public static int fib(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for(int i=2; i<=n; i++)
        {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int n = in.nextInt();
            System.out.println(fib(n));
        }
    }
}
