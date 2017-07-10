package interviewbit.backtracking.Permutations;

import java.util.ArrayList;

/**
 * Created by karthikb on 10-07-2017.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		permuteRec(ans, 0, a);
		return ans;
	}
	
	private void permuteRec(ArrayList<ArrayList<Integer>> ans, int i, ArrayList<Integer> current) {
		if(i == current.size())
		{
			ans.add(new ArrayList<>(current));
		}
		else
		{
			int temp;
			for(int k=i; k<current.size(); k++)
			{
				temp = current.get(i);
				current.set(i, current.get(k));
				current.set(k, temp);
				permuteRec(ans, i+1, current);
				temp = current.get(i);
				current.set(i, current.get(k));
				current.set(k, temp);
			}
		}
	}
}
