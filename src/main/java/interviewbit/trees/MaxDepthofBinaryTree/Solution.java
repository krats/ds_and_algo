package interviewbit.trees.MaxDepthofBinaryTree;

public class Solution {
	public int maxDepth(TreeNode a) {
		if(a == null)
			return 0;
		return Math.max(maxDepth(a.left), maxDepth(a.right))+1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
