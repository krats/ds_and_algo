package interviewbit.hashing.ValidSudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by karthikb on 12-07-2017.
 */
public class Solution {
	public int isValidSudoku(final List<String> a) {
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.size(); j++) {
				if (a.get(i).charAt(j) != '.') {
					char c = a.get(i).charAt(j);
					for (int k = 0; k < a.size(); k++) {
						if (a.get(i).charAt(k) == c && k != j)
						{
							return 0;
						}
						else if(a.get(k).charAt(j) == c && k != i)
						{
							return 0;
						}
					}
					for(int i1 = 3*(i/3); i1 < 3*(i/3)+3; i1++)
					{
						for(int j1 = 3*(j/3); j1 < 3*(j/3)+3; j1++)
						{
							if(a.get(i1).charAt(j1) == c && (i1 != i || j1 != j))
							{
								return 0;
							}
						}
					}
				}
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		String[] words = word.split("\\s+");
		ArrayList<String> arr = new ArrayList<>(9);
		for(int i=1; i<words.length; i++)
		{
			arr.add(words[i]);
		}
		System.out.println(sol.isValidSudoku(arr));
	}
}
