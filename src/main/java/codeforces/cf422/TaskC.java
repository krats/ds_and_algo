package codeforces.cf422;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        ArrayList<Range> ranges = new ArrayList<>(n);
        for(int i=0; i<n; i++)
            ranges.add(new Range(in.nextInt(), in.nextInt(), in.nextInt()));
        Collections.sort(ranges);
        int l = 0;
        int ans = Integer.MAX_VALUE;
        int r = ranges.size()-1;
        while(l < r)
        {
            if(ranges.get(l).len + ranges.get(r).len == x)
            {
                if(ranges.get(l).x > ranges.get(r).y || ranges.get(r).x > ranges.get(l).y)
                {
                    ans = Math.min(ranges.get(l).cost + ranges.get(r).cost, ans);
                }
                for(int i = l+1; i<ranges.size(); i++)
                {
                    if(ranges.get(l).len == ranges.get(i).len)
                    {
                        if(ranges.get(i).x > ranges.get(r).y || ranges.get(r).x > ranges.get(i).y)
                            ans = Math.min(ranges.get(i).cost + ranges.get(r).cost, ans);
                    }
                    else
                    {
                        l = i-1;
                        break;
                    }
                }
                for(int i = r-1; i>=0; i--)
                {
                    if(ranges.get(r).len == ranges.get(i).len)
                    {
                        if(ranges.get(l).x > ranges.get(i).y || ranges.get(i).x > ranges.get(l).y)
                            ans = Math.min(ranges.get(i).cost + ranges.get(l).cost, ans);
                    }
                    else
                    {
                        r = i+1;
                        break;
                    }
                }
                l++;
                r--;
            }
            else if(ranges.get(l).len + ranges.get(r).len < x)
                l++;
            else
                r--;
        }
        out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    
    class Range implements Comparable<Range>{
        int x;
        int y;
        int cost;
        int len;
        public Range(int x, int y, int cost)
        {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.len = y-x+1;
        }
        
        public int compareTo(Range b)
        {
            return this.len - b.len;
        }
    }
}
