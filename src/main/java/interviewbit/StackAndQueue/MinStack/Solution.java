package interviewbit.StackAndQueue.MinStack;

import java.util.Stack;

/**
 * Created by karthikb on 07-07-2017.
 */
class Solution {
	int n = 0;
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	int current = Integer.MAX_VALUE;
	
	public void push(int x) {
		stack.push(x);
		current = Math.min(current, x);
		min.push(current);
		n++;
	}
	
	public void pop() {
		if(n == 0)
			return;
		stack.pop();
		min.pop();
		n--;
		if(n == 0)
			current = Integer.MAX_VALUE;
		else
			current = min.peek();
	}
	
	public int top() {
		if(n == 0)
			return -1;
		return stack.peek();
	}
	
	public int getMin() {
		if(n == 0)
			return -1;
		return min.peek();
	}
}
