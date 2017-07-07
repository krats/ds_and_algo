package interviewbit.BitManipulation.MinXorValue;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by karthikb on 02-07-2017.
 */
public class Solution {
	public int findMinXor(ArrayList<Integer> A) {
		int current;
		int n = A.size();
		Collections.sort(A);
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n-1; i++)
		{
			current = A.get(i)^A.get(i+1);
			if(ans > current)
			{
				ans = current;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] nums = new int[]{0, 2, 5, 7};
		ArrayList<Integer> A = new ArrayList<>(nums.length);
		for(int i=0; i<nums.length; i++)
		{
			A.add(nums[i]);
		}
		System.out.println(sol.findMinXor(A));
	}
}
