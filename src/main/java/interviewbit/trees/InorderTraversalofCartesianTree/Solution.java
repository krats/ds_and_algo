package interviewbit.trees.InorderTraversalofCartesianTree;


import java.util.ArrayList;

public class Solution {
	public TreeNode buildTree(ArrayList<Integer> a) {
		TreeNode root = null;
		for(int i=0; i<a.size(); i++) {
			root = addToTree(root, a.get(i));
		}
		return root;
	}
	
	TreeNode addToTree(TreeNode root, int val) {
		if(root == null || root.val < val) {
			TreeNode c = new TreeNode(val);
			c.left = root;
			return c;
		}
		else {
			root.right = addToTree(root.right, val);
			return root;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
