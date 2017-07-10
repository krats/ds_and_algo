package interviewbit.backtracking.LetterPhone;

import java.util.ArrayList;

/**
 * Created by karthikb on 09-07-2017.
 */
public class Solution {
	String alphabets = "abcdefghijklmnopqrstuvwxyz";
	public ArrayList<String> letterCombinations(String a) {
		ArrayList<String> ans = new ArrayList<>((int) Math.pow(a.length(),3));
		char[] current = new char[a.length()];
		letterCombinationsRecursive(ans, a, current, 0);
		return ans;
	}
	
	public void letterCombinationsRecursive(ArrayList<String> ans, String a, char[] current, int index) {
		if(index == current.length) {
			ans.add(new String(current));
		}
		else {
			if(a.charAt(index) == '0' || a.charAt(index) == '1')
			{
				current[index] = a.charAt(index);
				letterCombinationsRecursive(ans, a, current, index+1);
			}
			else if(a.charAt(index)-'0' < 7)
			{
				int c = a.charAt(index)-'2';
				for(int i=c*3; i<c*3+3; i++)
				{
					current[index] = alphabets.charAt(i);
					letterCombinationsRecursive(ans, a, current, index+1);
				}
			}
			else if(a.charAt(index) == '7')
			{
				for(int i=15; i<19; i++)
				{
					current[index] = alphabets.charAt(i);
					letterCombinationsRecursive(ans, a, current, index+1);
				}
			}
			else if(a.charAt(index) == '8')
			{
				for(int i=19; i<22; i++)
				{
					current[index] = alphabets.charAt(i);
					letterCombinationsRecursive(ans, a, current, index+1);
				}
			}
			else if(a.charAt(index) == '9')
			{
				for(int i=22; i<26; i++)
				{
					current[index] = alphabets.charAt(i);
					letterCombinationsRecursive(ans, a, current, index+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.letterCombinations("0123456789"));
	}
}
