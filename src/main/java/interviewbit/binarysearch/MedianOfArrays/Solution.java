package interviewbit.binarysearch.MedianOfArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by karthikb on 29-06-2017.
 */
public class Solution {
	public double findMedianSortedArrays(final List<Integer> a1, final List<Integer> b1)
	{
		List<Integer> a = a1;
		List<Integer> b = b1;
		int n = a.size();
		int m = b.size();
		int start,end,i,j;
		if(m < n) {
			List<Integer> temp = a;
			a = b;
			b = temp;
			n = a.size();
			m = b.size();
		}
		if(n == 0) {
			if(m % 2 == 0) {
				return (b.get(m/2)+b.get(m/2 - 1))/2.0;
			}
			else if(m == 1)
				return b.get(0);
			else
				return b.get(m/2);
		}
		if(n == 1) {
			if(m %2 == 0) {
				if(a.get(0) < b.get(m/2-1)) {
					return b.get(m/2-1);
				}
				else {
					return Math.min(a.get(0), b.get(m/2));
				}
			}
			else {
				if(m == 1) {
					return (a.get(0) + b.get(0))/2.0;
				}
				else if(a.get(0) < b.get(m/2)) {
					return (b.get(m/2) + Math.max(a.get(0), b.get(m/2-1)))/2.0;
				}
				else {
					return (Math.min(a.get(0), b.get(m/2+1)) + b.get(m/2))/2.0;
				}
			}
		}
		if(n == 2) {
			if(m %2 != 0) {
				ArrayList<Integer> c = new ArrayList<>(3);
				c.add(b.get(m/2));
				c.add(Math.max(b.get(m/2 - 1), a.get(0)));
				c.add(Math.min(b.get(m/2 + 1), a.get(1)));
				Collections.sort(c);
				return c.get(1);
			}
			else {
				ArrayList<Integer> c = new ArrayList<>(3);
				c.add(b.get(m/2));
				c.add(b.get(m/2-1));
				if(m/2 -2 >= 0)
				{
					c.add(Math.max(b.get(m/2 - 2), a.get(0)));
				}
				else
					c.add(a.get(0));
				if(m/2 + 1 < m)
				{
					c.add(Math.min(b.get(m/2 + 1), a.get(1)));
				}
				else {
					c.add(a.get(1));
				}
				Collections.sort(c);
				return (c.get(1) + c.get(2))/2.0;
			}
		}
		start = 0;
		end = n;
		while (start <= end) {
			i = (start + end) / 2;
			j = ((m + n + 1) / 2) - i;
			if(j == 0 || i == n || b.get(j - 1) > a.get(i)) {
				start = i + 1;
			}
			else if(j == m || i == 0 || b.get(j) < a.get(i-1)) {
				end = i - 1;
			}
			else if((m + n)%2 != 0) {
				return Math.max(a.get(i - 1), b.get(j - 1));
			}
			else {
				return (Math.max(a.get(i-1), b.get(j-1)) + Math.min(a.get(i),b.get(j)))/2.0;
			}
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		ArrayList<Integer> a = new ArrayList<>(100);
		ArrayList<Integer> b = new ArrayList<>(100);
		int[] aa = new int[]{-34, -18, -12, -3, 12, 16, 20, 31, 44};
		int[] bb = new int[]{-27, 25, 38};
		for(int i: aa)
		{
			a.add(i);
		}
		for(int i:bb)
		{
			b.add(i);
		}
		System.out.println(sol.findMedianSortedArrays(a,b));
	}
}
