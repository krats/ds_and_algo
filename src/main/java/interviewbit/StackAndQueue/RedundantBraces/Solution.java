package interviewbit.StackAndQueue.RedundantBraces;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public int braces(String a) {
		Stack<Character> stck = new Stack<>();
		for(int i=0; i<a.length(); i++)
		{
			if(a.charAt(i) == '(' || a.charAt(i) == '+' || a.charAt(i) == '-'  || a.charAt(i) == '*' || a.charAt(i) == '/')
				stck.push(a.charAt(i));
			if(a.charAt(i) == ')')
			{
				if(stck.pop() == '(')
					return 1;
				else
					stck.pop();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in  = new Scanner(System.in);
		System.out.println(sol.braces(in.nextLine()));
	}
}
