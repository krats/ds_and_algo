package interviewbit.trees.RoottoLeafPathsWithSum;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> ans;
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ans = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		c.add(root.val);
		hasPathSum(root, sum, c);
		return ans;
	}
	
	public void hasPathSum(TreeNode a, int b, ArrayList<Integer> path) {
		if(a.val == b && a.left == null && a.right == null) {
			ans.add((ArrayList<Integer>) path.clone());
		}
		if(a.left != null) {
			path.add(a.left.val);
			hasPathSum(a.left, b-a.val, path);
			path.remove(path.size()-1);
		}
		if(a.right != null) {
			path.add(a.right.val);
			hasPathSum(a.right, b-a.val, path);
			path.remove(path.size()-1);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}