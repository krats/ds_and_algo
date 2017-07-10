package interviewbit.backtracking.GrayCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karthikb on 10-07-2017.
 */
public class Solution {
	ArrayList<Integer> ans;
	public ArrayList<Integer> grayCode(int a) {
		ans = new ArrayList<>((int) Math.pow(2, a));
		ans.add(0);
		ans.add(1);
		for(int i=1; i<a; i++)
		{
			int n = ans.size();
			int current = (int) Math.pow(2, i);
			for(int j=n-1; j>=0; j--)
			{
				ans.add(current+ans.get(j));
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.grayCode(2));
	}
}
