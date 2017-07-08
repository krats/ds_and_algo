package interviewbit.backtracking.CombinationSum2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by karthikb on 08-07-2017.
 */
public class Solution {
	ArrayList<ArrayList<Integer>> ans;
	ArrayList<Integer> a;
	int b;
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		this.ans = new ArrayList<ArrayList<Integer>>();
		this.a = a;
		combinationSumRecursive(new ArrayList<Integer>(), b, 0);
		return ans;
	}
	
	private void combinationSumRecursive(ArrayList<Integer> current, int target, int start) {
		if(target > 0) {
			for (int i = start; i < a.size() && target >= a.get(i); i++) {
				if(i == start || (i > start && a.get(i) != a.get(i-1)))
				{
					current.add(a.get(i));
					combinationSumRecursive(current, target - a.get(i), i+1);
					current.remove(current.size() - 1);
				}
			}
		}
		else if(target == 0)
		{
			ans.add(new ArrayList<Integer>(current));
		}
	}
}
