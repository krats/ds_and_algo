package interviewbit.StackAndQueue.SimplifyDirectoryPath;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public String simplifyPath(String a) {
		Stack<String> stck = new Stack<>();
		String[] words = a.split("\\/");
		for(int i=0; i<words.length; i++)
		{
			if(words[i].equals("."))
				continue;
			if(words[i].equals(".."))
			{
				if(!stck.empty())
					stck.pop();
			}
			else if(!words[i].equals(""))
				stck.push(words[i]);
		}
		StringBuilder ans = new StringBuilder();
		if(stck.empty())
			return "/";
		while (!stck.empty())
			ans.insert(0, "/"+stck.pop());
		return ans.toString();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		System.out.println(sol.simplifyPath(in.nextLine()));
	}
}
