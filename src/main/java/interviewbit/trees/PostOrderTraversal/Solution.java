package interviewbit.trees.PostOrderTraversal;

import java.util.*;

public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		if(a != null)
			stack.push(a);
		while (stack.size() != 0)
		{
			TreeNode c = stack.pop();
			if(c.left != null)
				stack.push(c.left);
			if(c.right != null)
				stack.push(c.right);
			ans.add(c.val);
		}
		Collections.reverse(ans);
		return ans;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}