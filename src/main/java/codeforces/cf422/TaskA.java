package codeforces.cf422;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        n = Math.min(n,m);
        int ans = 1;
        for(int i=2; i<=n; i++)
            ans *= i;
        out.println(ans);
    }
}
