package interviewbit.backtracking.Combinations;

import java.util.ArrayList;

/**
 * Created by karthikb on 08-07-2017.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		boolean arr[] = new boolean[n];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>(k);
		combineRecursive(n, k,1,ans,current);
		return ans;
	}
	
	private void combineRecursive(int n, int k, int next, ArrayList<ArrayList<Integer>>  ans, ArrayList<Integer> current) {
		if(current.size() == k)
		{
			ans.add(current);
		}
		else
		{
			for(int i=next; i<Math.min(n+1,next+n-k+1); i++)
			{
				ArrayList<Integer> c = new ArrayList<>(k);
				for (int j: current){
					c.add(j);
				}
				c.add(i);
				combineRecursive(n,k,i+1,ans,c);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.combine(3, 2));
	}
}
