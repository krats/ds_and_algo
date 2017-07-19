package codeforces.cf422;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String len = in.nextLine();
        String s = in.nextLine();
        String t = in.nextLine();
        int sn = s.length();
        int tn = t.length();
        int ans = Integer.MAX_VALUE;
        int index = -1;
        int count;
        for(int i=0; i<tn-sn+1; i++)
        {
            count = 0;
            for(int j=i; j<i+sn; j++)
            {
                if(s.charAt(j-i) != t.charAt(j))
                {
                    count++;
                }
            }
            if(count < ans)
            {
                ans = count;
                index = i;
            }
        }
        if(ans > 0)
        {
            out.println(ans);
            StringBuilder line = new StringBuilder();
            for(int i=0; i<sn; i++)
            {
                if(s.charAt(i) != t.charAt(index+i))
                {
                    line.append(Integer.toString(i+1));
                    line.append(" ");
                }
            }
            line.delete(line.length()-1, line.length());
            out.println(line);
        }
        else
        {
            out.println(ans);
        }
    }
}
