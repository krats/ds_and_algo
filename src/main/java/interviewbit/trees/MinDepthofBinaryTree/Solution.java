package interviewbit.trees.MinDepthofBinaryTree;

public class Solution {
	public int minDepth(TreeNode a) {
		if(a == null)
			return 0;
		int left = minDepth(a.left);
		int right = minDepth(a.right);
		if(left == 0 && right == 0)
			return 1;
		else if(left == 0)
			return right+1;
		else if(right == 0)
			return left+1;
		return Math.min(left, right)+1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
