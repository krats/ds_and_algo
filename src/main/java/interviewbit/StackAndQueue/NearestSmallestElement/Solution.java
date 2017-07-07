package interviewbit.StackAndQueue.NearestSmallestElement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<>(arr.size());
		Stack<Integer> stck = new Stack<>();
		for(int i=0; i<arr.size(); i++)
		{
			while (!stck.empty() && stck.peek() >= arr.get(i))
				stck.pop();
			if(stck.empty())
				ans.add(-1);
			else
				ans.add(stck.peek());
			stck.push(arr.get(i));
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i=0; i<arr.size(); i++)
		{
			arr.add(in.nextInt());
		}
		System.out.println(sol.prevSmaller(arr));
	}
}
