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
		if(ans.size() == 1){
			Stack<TreeNode> stack2 = new Stack<>();
			a = root;
			int c = ans.get(0);
			while (a != null)
			{
				stack.push(a);
				a = a.left;
			}
			while (stack.size() != 0){
				a = stack.pop();
				if(a.val > c) {
					ans.add(a.val);
				}
				if(ans.size() == 2) {
					return ans;
				}
				if(a.right != null) {
					a = a.right;
					while (a != null) {
						stack.push(a);
						a = a.left;
					}
				}
			}
		}
		else if(ans.size() == 2) {
			Stack<TreeNode> stack2 = new Stack<>();
			a = root;
			int c = ans.get(0);
			while (a != null)
			{
				stack.push(a);
				a = a.left;
			}
			while (stack.size() != 0){
				a = stack.pop();
				if(a.val > c) {
					ans.set(0, a.val);
					return ans;
				}
				if(a.right != null) {
					a = a.right;
					while (a != null) {
						stack.push(a);
						a = a.left;
					}
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