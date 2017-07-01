package codeforces.cfe24;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        long nd = n/(2*(k+1));
        long nc = k*nd;
        if(nc+nd > n/2)
        {
            nd--;
            nc = k*nd;
        }
        long losers = n - nc - nd;
        out.println(Long.toString(nd) + " " + Long.toString(nc) + " " + Long.toString(losers));
    }
}
