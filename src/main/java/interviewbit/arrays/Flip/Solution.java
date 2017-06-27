package interviewbit.arrays.Flip;

import java.util.ArrayList;

/**
 * Created by karthikb on 25-06-2017.
 */
public class Solution {
	public ArrayList<Integer> flip(String A) {
		int N = A.length();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
		{
			arr[i] = A.charAt(i) == '1' ? -1 : 1;
		}
		int max_so_far = 0;
		int max_ending_here = 0;
		int L = -1;
		int R = -1;
		int k = 0;
		for(int i=0; i<N; i++)
		{
			max_ending_here += arr[i];
			if(max_ending_here < 0)
			{
				max_ending_here = 0;
				k = i+1;
			}
			if(max_so_far < max_ending_here)
			{
				max_so_far = max_ending_here;
				L = k;
				R = i;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>(2);
		if(max_so_far == 0)
			return ans;
		if(arr[0] == -2)
		{
			arr[0] = -1;
		}
		for(int i=1; i<N; i++)
		{
			if(arr[i] == -2)
			{
				arr[i] = -1;
			}
			arr[i] += arr[i-1];
		}
		for(int i=L-1; i>=0; i--)
		{
			if(i > 0) {
				if (arr[L-1] - arr[i - 1] == 0) {
					L = i;
				}
			}
			else
			{
				if (arr[L-1] == 0) {
					L = i;
				}
			}
		}
		ans.add(L+1);
		ans.add(R+1);
		return ans;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		System.out.println(sol.flip("010"));
		System.out.println(sol.flip("1101010001"));
		System.out.println(sol.flip("010101000001010011"));
	}
}