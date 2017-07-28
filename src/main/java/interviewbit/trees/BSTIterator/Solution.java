package interviewbit.trees.BSTIterator;

import java.util.Stack;

public class Solution {
	Stack<TreeNode> in;
	public Solution(TreeNode root) {
		in = new Stack<>();
		while (root != null) {
			in.push(root);
			root = root.left;
		}
	}
	
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return in.size() > 0;
	}
	
	/** @return the next smallest number */
	public int next() {
		TreeNode ans = in.pop();
		TreeNode temp = ans;
		if(temp.right != null){
			temp = temp.right;
			while (temp != null) {
				in.push(temp);
				temp = temp.left;
			}
		}
		return ans.val;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
