package codeforces;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        int count = v0;
        int ans = 1;
        while(count < c)
        {
            ans++;
            if(v1 < v0 + (ans-1)*a)
                count = count + v1 - Math.min(count,l);
            else
                count = count + v0 + (ans-1)*a - Math.min(count,l);
        }
        out.println(ans);
    }
}
