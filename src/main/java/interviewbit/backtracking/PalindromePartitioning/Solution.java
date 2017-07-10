package interviewbit.backtracking.PalindromePartitioning;

import java.util.ArrayList;

/**
 * Created by karthikb on 09-07-2017.
 */
public class Solution {
	int N;
	String a;
	public ArrayList<ArrayList<String>> partition(String a) {
		N = a.length();
		this.a = a;
		boolean[][] isPalindrome = new boolean[a.length()][a.length()];
		for(int len=1; len<=a.length(); len++)
		{
			for(int i=0; i<a.length()-len+1; i++)
			{
				int j = i + len-1;
				if(len == 1)
					isPalindrome[i][j] = true;
				else if(len == 2)
					isPalindrome[i][j] = a.charAt(i) == a.charAt(j);
				else
					isPalindrome[i][j] = (a.charAt(i) == a.charAt(j) && isPalindrome[i+1][j-1]);
			}
		}
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		partitionRecursive(ans, new ArrayList<String>(), 0, isPalindrome);
		return ans;
	}
	
	void partitionRecursive(ArrayList<ArrayList<String>> ans, ArrayList<String> current, int start, boolean[][] isPalindrome)
	{
		if(start == N)
		{
			ans.add(new ArrayList<>(current));
		}
		else
		{
			for(int j=start; j<N; j++)
			{
				if(isPalindrome[start][j])
				{
					current.add(a.substring(start, j+1));
					partitionRecursive(ans,current,j+1,isPalindrome);
					current.remove(current.size()-1);
				}
			}
		}
	}
}
