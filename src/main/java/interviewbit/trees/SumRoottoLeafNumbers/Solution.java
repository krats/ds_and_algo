package interviewbit.trees.SumRoottoLeafNumbers;

public class Solution {
	int ans;
	public int sumNumbers(TreeNode a) {
		ans = 0;
		if(a == null) {
			return 0;
		}
		traverse(a, 0);
		return ans;
	}
	
	void traverse(TreeNode root, long sum) {
		if(root.left == null && root.right == null){
			ans = (ans + (int)((sum*10+root.val))%1003)%1003;
			return;
		}
		if(root.left != null) {
			traverse(root.left, (sum*10+root.val)%1003);
		}
		if(root.right != null) {
			traverse(root.right, (sum*10+root.val)%1003);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}