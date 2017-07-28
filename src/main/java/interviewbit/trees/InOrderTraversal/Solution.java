package interviewbit.trees.InOrderTraversal;

import java.util.*;

public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stck = new Stack<>();
		TreeNode current = a;
		while (current != null) {
			stck.push(current);
			current = current.left;
		}
		while (stck.size() != 0) {
			current = stck.pop();
			ans.add(current.val);
			if (current.right != null) {
				current = current.right;
				
				// the next node to be visited is the leftmost
				while (current != null) {
					stck.push(current);
					current = current.left;
				}
			}
		}
		return ans;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}