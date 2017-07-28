package interviewbit.trees.ConstructBinaryTreeFromInorderAndPreorder;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	ArrayList<Integer> inorder;
	ArrayList<Integer> preorder;
	HashMap<Integer, Integer> pre;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
		int n = preorder.size();
		if(n == 0)
			return null;
		this.pre = new HashMap<>();
		for(int i=0; i<n; i++){
			pre.put(preorder.get(i), i);
		}
		
		this.inorder = inorder;
		this.preorder = preorder;
		return solve(0, n-1);
	}
	TreeNode solve(int start, int end) {
		if(start > end)
			return null;
		if(start == end)
			return new TreeNode(inorder.get(start));
		int minIndex = Integer.MAX_VALUE;
		int mid = -1;
		for(int i=start; i <= end; i++) {
			if(this.pre.get(this.inorder.get(i)) < minIndex) {
				minIndex = this.pre.get(this.inorder.get(i));
				mid = i;
			}
		}
		TreeNode root = new TreeNode(this.preorder.get(minIndex));
		root.left = solve(start, mid-1);
		root.right = solve(mid+1, end);
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
