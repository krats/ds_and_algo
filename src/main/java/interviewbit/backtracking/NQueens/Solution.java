package interviewbit.backtracking.NQueens;

import java.util.ArrayList;

/**
 * Created by karthikb on 09-07-2017.
 */
public class Solution {
	ArrayList<ArrayList<String>> ans;
	int a;
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		this.ans = new ArrayList<ArrayList<String>>();
		this.a = a;
		solveNQueensRec(new ArrayList<ArrayList<Integer>>());
		return ans;
	}
	
	private void solveNQueensRec(ArrayList<ArrayList<Integer>> current) {
		if(current.size() == a)
		{
			char[][] c = new char[a][a];
			for(int i=0; i<a; i++)
			{
				for(int j=0; j<a; j++)
				{
					c[i][j] = '.';
				}
			}
			for(int i=0; i<current.size(); i++)
			{
				c[current.get(i).get(0)][current.get(i).get(1)] = 'Q';
			}
			ArrayList<String> cS = new ArrayList<>(a);
			for(int i=0; i<a; i++)
			{
				cS.add(new String(c[i]));
			}
			ans.add(cS);
		}
		else
		{
			int i = current.size();
			for(int j=0; j<a; j++)
			{
				boolean isPossible = true;
				for(int k=0; k<current.size(); k++)
				{
					if(current.get(k).get(1) == j || Math.abs(i-current.get(k).get(0)) == Math.abs(j-current.get(k).get(1))) {
						isPossible = false;
						break;
					}
				}
				if(isPossible)
				{
					ArrayList<Integer> c = new ArrayList<>(2);
					c.add(i);
					c.add(j);
					current.add(c);
					solveNQueensRec(current);
					current.remove(current.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solveNQueens(4));
	}
}
