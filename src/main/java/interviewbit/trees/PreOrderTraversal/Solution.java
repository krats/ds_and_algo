package interviewbit.trees.PreOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode current;
		if(a != null)
			stack.push(a);
		while (stack.size() != 0) {
			current = stack.pop();
			ans.add(current.val);
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
		}
		return ans;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}