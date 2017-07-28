package interviewbit.trees.LeastCommonAncestor;

import java.util.ArrayList;

public class Solution {
	public int lca(TreeNode a, int val1, int val2) {
		ArrayList<TreeNode> path1 = new ArrayList<>();
		ArrayList<TreeNode> path2 = new ArrayList<>();
		int depth1 = findDepth(a, val1, path2);
		int depth2 = findDepth(a, val2, path1);
		if(depth1 == -1 || depth2 == -1)
			return -1;
		int i=path1.size()-1;
		int j=path2.size()-1;
		while (i >=0  && j >= 0 && path1.get(i) == path2.get(j))
		{
			i--;
			j--;
		}
		return path1.get(i+1).val;
	}
	
	public int findDepth(TreeNode a, int val, ArrayList<TreeNode> path) {
		if(a == null)
			return -1;
		else if(a.val == val)
		{
			path.add(a);
			return 0;
		}
		else
		{
			if(a.left != null)
			{
				int left = findDepth(a.left, val, path);
				if(left != -1)
				{
					path.add(a);
					return left+1;
				}
			}
			if(a.right != null)
			{
				int right = findDepth(a.right, val, path);
				if(right != -1)
				{
					path.add(a);
					return right+1;
				}
			}
			return -1;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}