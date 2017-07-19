package codeforces.cf423div2;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int singleTable = in.nextInt();
        int doubleTable = in.nextInt();
        int sharedTable = 0;
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            int current = in.nextInt();
            if(current == 1)
            {
                if(singleTable > 0)
                    singleTable--;
                else if(doubleTable > 0)
                {
                    doubleTable--;
                    sharedTable++;
                }
                else if(sharedTable > 0)
                {
                    sharedTable--;
                }
                else
                {
                    ans += 1;
                }
            }
            else
            {
                if(doubleTable > 0)
                {
                    doubleTable--;
                }
                else
                {
                    ans += 2;
                }
            }
        }
        out.print(ans);
    }
}
