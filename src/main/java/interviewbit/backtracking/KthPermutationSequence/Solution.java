package interviewbit.backtracking.KthPermutationSequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karthikb on 10-07-2017.
 */
public class Solution {
	public String getPermutation(int n, int k) {
		int[] arr = new int[n];
		boolean[] set = new boolean[n];
		getPermutationRec(arr, k-1, n, 0, set);
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<n; i++) {
			ans.append(Integer.toString(arr[i]));
		}
		return ans.toString();
	}
	
	int fact(int k, long t)
	{
		if(k == 0)
			return 1;
		else
		{
			long ans = 1;
			while(k>0)
			{
				ans*=k;
				k--;
				if(ans > t)
					return -1;
			}
			return (int) ans;
		}
	}
	
	private boolean getPermutationRec(int[] arr, int k, int n, int index, boolean[] set) {
		if(index == n)
			return true;
		else
		{
			int factnminus1 = fact(n-index-1, k);
			int t = 0;
			if(factnminus1 != -1)
				t = k/factnminus1;
			t++;
			int current = 0;
			for(int i=0; i<n; i++)
			{
				if(!set[i])
				{
					t--;
					if(t == 0)
					{
						current = i+1;
						break;
					}
				}
			}
			int rem = k;
			if(factnminus1 != -1)
			{
				rem = k%factnminus1;
			}
			arr[index] = current;
			set[current-1] = true;
			getPermutationRec(arr, rem, n, index+1, set);
			return false;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.getPermutation(100, Integer.MAX_VALUE));
	}
}
