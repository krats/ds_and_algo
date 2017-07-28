package interviewbit.trees.ZigZagLevelOrderTraversalBT;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
		Stack<TreeNode> stacks0 = new Stack<>();
		Stack<TreeNode> stacks1 = new Stack<>();
		TreeNode current;
		int index = 0;
		stacks0.push(a);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> c = new ArrayList<>();
		while (stacks0.size() != 0 || stacks1.size() != 0) {
			if(index == 0){
				current = stacks0.pop();
				c.add(current.val);
				if(current.left != null) {
					stacks1.push(current.left);
				}
				if(current.right != null) {
					stacks1.push(current.right);
				}
				if(stacks0.size() == 0){
					ans.add(c);
					index = 1;
					c = new ArrayList<>();
				}
			}
			else {
				current = stacks1.pop();
				c.add(current.val);
				if(current.right != null) {
					stacks0.push(current.right);
				}
				if(current.left != null) {
					stacks0.push(current.left);
				}
				if(stacks1.size() == 0){
					ans.add(c);
					index = 0;
					c = new ArrayList<>();
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
