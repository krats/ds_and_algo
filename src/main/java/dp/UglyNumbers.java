// Question Link: http://www.geeksforgeeks.org/ugly-numbers/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UglyNumbers {
    public static int uglyNumber(int n)
    {
        int numbers[] = new int[n];
        numbers[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        int next_i2;
        int next_i3;
        int next_i5;
        for(int i=1; i<n; i++)
        {
            next_i2=numbers[i2]*2;
            next_i3=numbers[i3]*3;
            next_i5=numbers[i5]*5;
            int min = next_i2 < next_i3? next_i2: next_i3;
            min = min < next_i5? min: next_i5;
            if(min == next_i2)
            {
                i2+=1;
            }
            if(min == next_i3)
            {
                i3+=1;
            }
            if(min == next_i5)
            {
                i5+=1;
            }
            numbers[i] = min;
        }
        return numbers[n-1];
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0; t<T; t++)
        {
            int n = in.nextInt();
            System.out.println(uglyNumber(n));
        }
    }
}
