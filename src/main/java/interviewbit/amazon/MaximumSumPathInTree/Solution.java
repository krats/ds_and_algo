package interviewbit.amazon.MaximumSumPathInTree;


public class Solution {
	int ans = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode a) {
		if(a == null)
			return 0;
		int k = sovle(a);
		if(k > ans)
			ans = k;
		return ans;
	}
	
	int sovle(TreeNode root) {
		if(root == null)
			return 0;
		else if(root.left == null && root.right == null) {
			ans = Math.max(root.val, ans);
			return root.val;
		}
		else {
			int left = Integer.MIN_VALUE;
			int right = Integer.MIN_VALUE;
			if(root.left != null) {
				left = sovle(root.left);
			}
			if(root.right != null) {
				right = sovle(root.right);
			}
			int maxPassingThrough = root.val;
			int c = root.val;
			if(left > 0)
			{
				maxPassingThrough = Math.max(maxPassingThrough, left + root.val);
				c += left;
			}
			if(right > 0) {
				maxPassingThrough = Math.max(maxPassingThrough, right + root.val);
				c += right;
			}
			ans = Math.max(c, ans);
			return maxPassingThrough;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
