package interviewbit.trees.RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
	public ArrayList<Integer> recoverTree(TreeNode a) {
		ArrayList<Integer> ans = new ArrayList<>(2);
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = a;
		while (a != null)
		{
			stack.push(a);
			a = a.left;
		}
		int prev = -1;
		while (stack.size() != 0){
			a = stack.pop();
			if(a.val < prev) {
				ans.add(prev);
				ans.add(a.val);
			}
			prev = a.val;
			if(a.right != null) {
				a = a.right;
				while (a != null) {
					stack.push(a);
					a = a.left;
				}
			}
		}
		while(ans.size() > 2){
			ans.remove(1);
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