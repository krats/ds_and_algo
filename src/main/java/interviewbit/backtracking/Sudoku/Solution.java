package interviewbit.backtracking.Sudoku;

import java.util.ArrayList;

/**
 * Created by karthikb on 10-07-2017.
 */
public class Solution {
	String numbers = "0123456789";
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solveSudokuRecursive(a, 0);
	}
	
	boolean solveSudokuRecursive(ArrayList<ArrayList<Character>> a, int index)
	{
		if(index >= 81)
			return true;
		else
		{
			for(int k = index; k < 81; k++)
			{
				int i = k/9;
				int j = k%9;
				if(a.get(i).get(j) == '.')
				{
					boolean[] possible = new boolean[10];
					for(int t=1; t<10; t++)
						possible[t] = true;
					for(int t=0; t<9; t++)
					{
						if(a.get(t).get(j) != '.')
							possible[a.get(t).get(j)-'0'] = false;
					}
					for(int t=0; t<9; t++)
					{
						if(a.get(i).get(t) != '.')
							possible[a.get(i).get(t)-'0'] = false;
					}
					int k1 = i - (i%3);
					int k2 = j - (j%3);
					for(int k11=k1; k11<k1+3; k11++)
					{
						for(int k22=k2; k22<k2+3; k22++)
						{
							if(a.get(k11).get(k22) != '.')
								possible[a.get(k11).get(k22)-'0'] = false;
						}
					}
					for(int t=1; t<=9; t++)
					{
						if(possible[t])
						{
							a.get(i).set(j,numbers.charAt(t));
							boolean result = solveSudokuRecursive(a, index+1);
							if(result)
								return result;
							else
								a.get(i).set(j,'.');
						}
					}
					return false;
				}
			}
			return true;
		}
	}
}
