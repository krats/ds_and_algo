package codeforces.cf422;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int f[] = new int[r+1];
        int MOD = 1000000007;
        boolean[] seive = new boolean[r+1];
        seive[0] = true;
        seive[1] = true;
        int count = 0;
        for(int i=2; i<r+1; i++)
        {
            if(seive[i] == false)
            {
                count++;
                for(int j=2*i; j<r+1; j+=i)
                {
                    seive[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>(count);
        for(int i=2; i<r+1; i++)
        {
            if(seive[i] == false)
                primes.add(i);
        }
        for(int i=0; i<primes.size(); i++)
        {
            int current = primes.get(i);
            f[current] = (current*(current-1))/2;
        }
        for(int i=2; i<(r+1); i++)
        {
            int j = 0;
            boolean notentered = true;
            while(j < primes.size() && primes.get(j)*i < r+1)
            {
                notentered = false;
                int current = f[primes.get(j)] + primes.get(j)*(i*(i-1))/2;
                if(f[primes.get(j)*i] == 0)
                    f[primes.get(j)*i] = current;
                else
                    f[primes.get(j)*i] = Math.min(f[primes.get(j)*i], current);
                j++;
            }
            if(notentered)
                break;
        }
        long ans = 0;
        long term1 = 1;
        for(int i=0; i<r-l+1; i++)
        {
            ans = (ans + (term1*f[l+i])%MOD)%MOD;
            term1= (term1*t)%MOD;
        }
        out.println(ans);
    }
}
