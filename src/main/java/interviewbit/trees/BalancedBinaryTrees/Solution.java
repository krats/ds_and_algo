package interviewbit.trees.BalancedBinaryTrees;


public class Solution {
	public int isBalanced(TreeNode a) {
		int val = solve(a);
		if(val == -1)
			return 0;
		else
			return 1;
	}
	
	public int solve(TreeNode a) {
		if(a == null)
			return 0;
		else {
			int left = solve(a.left);
			if(left == -1)
				return -1;
			int right = solve(a.right);
			if(right == -1)
				return -1;
			if(Math.abs(left - right) > 1)
				return -1;
			else
				return Math.max(left, right) + 1;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
