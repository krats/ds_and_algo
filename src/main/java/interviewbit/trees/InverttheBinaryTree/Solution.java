package interviewbit.trees.InverttheBinaryTree;

import java.util.Stack;

public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode current, temp;
		while (stack.size() != 0){
			current = stack.pop();
			temp = current.left;
			current.left = current.right;
			current.right = temp;
			if(current.left != null)
				stack.push(current.left);
			if(current.right != null)
				stack.push(current.right);
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}