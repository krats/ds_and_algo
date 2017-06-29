package interviewbit.binarysearch.MedianOfArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthikb on 29-06-2017.
 */
public class Solution {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int m = a.size();
		int n = b.size();
		int start = 0;
		int end = m-1;
		int res = -1;
		int mid = -1;
		int lessThan = (n+m)/2;
		while(start <= end)
		{
			mid = (start+end)/2;
			int count = countLessThan(b,a.get(mid));
			if(count + mid == lessThan)
			{
				res = mid;
				break;
			}
			else if(count + mid < lessThan)
			{
				start = mid+1;
			}
			else
			{
				end = mid-1;
			}
		}
		int ans = 0;
		if(res == -1)
		{
			start = 0;
			end = n-1;
			while(start <= end)
			{
				mid = (start+end)/2;
				int count = countLessThan(a,b.get(mid));
				if(count + mid == lessThan)
				{
					res = mid;
					break;
				}
				else if(count + mid < lessThan)
				{
					start = mid+1;
				}
				else
				{
					end = mid-1;
				}
			}
			ans = b.get(res);
		}
		else
		{
			ans = a.get(res);
		}
		if((n+m)%2 == 0)
		{
			lessThan--;
			start = 0;
			end = m-1;
			res = -1;
			mid = -1;
			while(start <= end)
			{
				mid = (start+end)/2;
				int count = countLessThan(b,a.get(mid));
				if(count + mid == lessThan)
				{
					res = mid;
					break;
				}
				else if(count + mid < lessThan)
				{
					start = mid+1;
				}
				else
				{
					end = mid-1;
				}
			}
			if(res == -1)
			{
				start = 0;
				end = n-1;
				while(start <= end)
				{
					mid = (start+end)/2;
					int count = countLessThan(a,b.get(mid));
					if(count + mid == lessThan)
					{
						res = mid;
						break;
					}
					else if(count + mid < lessThan)
					{
						start = mid+1;
					}
					else
					{
						end = mid-1;
					}
				}
				ans += b.get(res);
			}
			else
			{
				ans += a.get(res);
			}
			return ((double) ans)/2;
		}
		else
		{
			return ans;
		}
	}
	
	int countLessThan(List<Integer> arr, int b)
	{
		int res = -1;
		int start = 0;
		int end = arr.size()-1;
		while(start <= end)
		{
			int mid = (start+end)/2;
			if(arr.get(mid) >= b)
			{
				end = mid-1;
				res = mid;
			}
			else
			{
				start = mid+1;
			}
		}
		if(res == -1)
		{
			return arr.size();
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		ArrayList<Integer> a = new ArrayList<>(100);
		ArrayList<Integer> b = new ArrayList<>(100);
		int[] aa = new int[]{-49, 2, 9, 24, 43, 44};
		int[] bb = new int[]{7, 14, 16, 26, 35, 38, 42};
		for(int i: aa)
		{
			b.add(i);
		}
		for(int i:bb)
		{
			a.add(i);
		}
		System.out.println(sol.findMedianSortedArrays(a,b));
	}
}
