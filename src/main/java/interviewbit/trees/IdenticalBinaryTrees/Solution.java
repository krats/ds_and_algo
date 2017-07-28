package interviewbit.trees.IdenticalBinaryTrees;


public class Solution {
	public int isSameTree(TreeNode a, TreeNode b) {
		if(a == null || b == null)
			return a == b ? 1 : 0;
		if(a.val == b.val)
			return (isSameTree(a.left, b.left) == 1) && (isSameTree(a.right, b.right) == 1) ? 1 : 0;
		return 0;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
