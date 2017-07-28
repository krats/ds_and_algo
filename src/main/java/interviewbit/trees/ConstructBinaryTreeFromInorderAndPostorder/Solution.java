package interviewbit.trees.ConstructBinaryTreeFromInorderAndPostorder;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	ArrayList<Integer> inorder;
	ArrayList<Integer> postorder;
	HashMap<Integer, Integer> post;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		int n = postorder.size();
		if(n == 0)
			return null;
		this.post = new HashMap<>();
		for(int i=0; i<n; i++){
			post.put(postorder.get(i), i);
		}
		
		this.inorder = inorder;
		this.postorder = postorder;
		return solve(0, n-1);
	}
	
	TreeNode solve(int start, int end) {
		if(start > end)
			return null;
		if(start == end)
			return new TreeNode(inorder.get(start));
		int maxIndex = -1;
		int mid = -1;
		for(int i=start; i <= end; i++) {
			if(this.post.get(this.inorder.get(i)) > maxIndex) {
				maxIndex = Math.max(this.post.get(this.inorder.get(i)), maxIndex);
				mid = i;
			}
		}
		TreeNode root = new TreeNode(this.postorder.get(maxIndex));
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