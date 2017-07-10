package interviewbit.backtracking.GenerateAllParentheses2;

import java.util.ArrayList;

/**
 * Created by karthikb on 09-07-2017.
 */
public class Solution {
	public ArrayList<String> generateParenthesis(int a) {
		ArrayList<String> ans = new ArrayList<>();
		generateParenthesisRecursive(ans, new StringBuilder(2*a), 0, 0, a);
		return ans;
	}
	
	void generateParenthesisRecursive(ArrayList<String> ans, StringBuilder current, int count, int countRev, int a)
	{
		if(current.length() == 2*a)
		{
			ans.add(current.toString());
		}
		else {
			if(count+countRev < a)
			{
				current.append('(');
				generateParenthesisRecursive(ans, current, count+1, countRev, a);
				current.delete(current.length()-1, current.length());
			}
			if(count > 0) {
				current.append(')');
				generateParenthesisRecursive(ans, current, count-1, countRev+1, a);
				current.delete(current.length() - 1, current.length());
			}
		}
	}
}
