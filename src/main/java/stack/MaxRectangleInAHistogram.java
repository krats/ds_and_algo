// Question Link: https://www.youtube.com/watch?v=VNbkzsnllsU

package stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxRectangleInAHistogram {
    public static int MaxRectangleInAHistogram(int[] hist, int N)
    {
        int pos,temp_pos=0,temp_h,tempsize,maxsize=0;
        int hstack[] = new int[N];
        int pstack[] = new int[N];
        int hstack_head=-1;
        int pstack_head=-1;
        for(pos=0; pos<N; pos++)
        {
            if(hstack_head == -1 || hstack[hstack_head] < hist[pos])
            {
                hstack_head++;
                pstack_head++;
                hstack[hstack_head] = hist[pos];
                pstack[pstack_head] = pos;
            }
            else if(hstack[hstack_head] > hist[pos])
            {
                while(hstack_head != -1 && hstack[hstack_head] > hist[pos])
                {
                    temp_pos = pstack[pstack_head];
                    pstack_head--;
                    temp_h = hstack[hstack_head];
                    hstack_head--;
                    tempsize = temp_h*(pos-temp_pos);
                    if(maxsize < tempsize)
                    {
                        maxsize = tempsize;
                    }
                }
                if(hstack_head == -1)
                {
                    hstack_head++;
                    pstack_head++;
                    hstack[hstack_head] = hist[pos];
                    pstack[pstack_head] = temp_pos;
                }
            }
        }
        while (hstack_head >=0)
        {
            temp_pos = pstack[pstack_head];
            pstack_head--;
            temp_h = hstack[hstack_head];
            hstack_head--;
            tempsize = temp_h*(pos-temp_pos);
            if(maxsize < tempsize)
            {
                maxsize = tempsize;
            }
        }
        return maxsize;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] hist = new int[N];
            for (int j = 0; j < N; j++) {
                hist[j] = in.nextInt();
            }
            System.out.println(MaxRectangleInAHistogram(hist, N));
        }
    }
}
