package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {
    public static void main(String[] args)
    {
        int t1, t2, N;
        Scanner in = new Scanner(System.in);
        t1 = in.nextInt();
        t2 = in.nextInt();
        N = in.nextInt();
        BigInteger fibm[] = new BigInteger[N];
        fibm[0] = BigInteger.valueOf(t1);
        fibm[1] = BigInteger.valueOf(t2);
        for(int i=2; i<N; i++)
        {
            fibm[i] = fibm[i-2].add(fibm[i-1].multiply(fibm[i-1]));
        }
        System.out.println(fibm[N-1].toString());
    }
}
