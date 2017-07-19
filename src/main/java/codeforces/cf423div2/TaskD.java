package codeforces.cf423div2;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int rest = n-k;
        int levels = n/k;
        if(n%k != 0)
        	levels += 1;
        out.println(2*levels);
    }
}
