package interviewbit.trees.FlattenBinaryTreetoLinkedList;

public class Solution {
	public TreeNode flatten(TreeNode a) {
		if(a == null) {
			return null;
		}
		TreeNode left = a.left;
		TreeNode right = a.right;
		if(left != null) {
			left = flatten(left);
		}
		if(right != null) {
			right = flatten(right);
		}
		a.left = null;
		a.right = left;
		if(left != null) {
			while (left.right != null) {
				left = left.right;
			}
			left.right = right;
		}
		else {
			a.right = right;
		}
		return a;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}