package interviewbit.StackAndQueue.EvaluateExpression;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	
	public int evalRPN(ArrayList<String> a) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i).equals("*"))
			{
				stack.push(stack.pop()*stack.pop());
			}
			else if(a.get(i).equals("+"))
			{
				stack.push(stack.pop()+stack.pop());
			}
			else if(a.get(i).equals("/"))
			{
				int aa = stack.pop();
				int bb = stack.pop();
				stack.push(bb/aa);
			}
			else if(a.get(i).equals("-"))
			{
				int aa = stack.pop();
				int bb = stack.pop();
				stack.push(bb-aa);
			}
			else
			{
				stack.push(Integer.parseInt(a.get(i)));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol);
	}
}
