package codeforces.cfe24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int li[] = new int[m];
        for(int i=0; i<m; i++)
        {
            li[i] = in.nextInt();
        }
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        boolean isPossible = true;
        HashSet<Integer> set = new HashSet<>(n);
        for(int i=1; i<=n; i++)
        {
            set.add(i);
        }
        for(int i=0; i<m-1; i++)
        {
            if(!visited[li[i]-1])
            {
                visited[li[i]-1] = true;
                int value = (li[i+1] + n - li[i])%n;
                if(value == 0)
                {
                    value = n;
                }
                if(set.contains(value))
                {
                    ans[li[i]-1] = value;
                    set.remove(value);
                }
                else
                {
                    isPossible = false;
                    break;
                }
            }
            else
            {
                int value = (li[i+1] + n - li[i])%n;
                if(value == 0)
                {
                    value = n;
                }
                if(value != ans[li[i]-1])
                {
                    isPossible = false;
                    break;
                }
            }
        }
        if(!isPossible)
            out.print(-1);
        else
        {
            for(int i=0; i<n; i++)
            {
                if(visited[i])
                {
                    set.remove(ans[i]);
                }
            }
            for(int i=0; i<n; i++)
            {
                if(!visited[i])
                {
                    int current = (Integer) set.toArray()[0];
                    set.remove(current);
                    ans[i] = current;
                }
            }
            StringBuilder val = new StringBuilder(n);
            val.append(ans[0]);
            for(int i=1; i<n; i++)
            {
                val.append(" ");
                val.append(ans[i]);
            }
            out.println(val);
        }
    }
}
