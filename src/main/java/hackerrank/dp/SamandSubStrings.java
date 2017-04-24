package hackerrank.dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SamandSubStrings {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int N = s.length();
        long ans = Integer.parseInt(Character.toString(s.charAt(0)));
        long prev = ans;
        for(int i=1; i<N; i++)
        {
            int num = Integer.parseInt(Character.toString(s.charAt(i)));
            long current = (prev*10 + (i+1)*num)%1000000007;
            ans += current;
            ans %= 1000000007;
            prev = current;
        }
        System.out.println(ans);
    }
}
