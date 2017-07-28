package interviewbit.trees.SymmetricBinaryTrees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public int isSymmetric(TreeNode a) {
		if(a == null)
			return 0;
		else {
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			addToStack(stack1, a, true);
			addToStack(stack2, a, false);
			while (stack1.size() > 0 && stack2.size() > 0) {
				TreeNode a1 = stack1.pop();
				TreeNode a2 = stack2.pop();
				if((a1 == null || a2 == null) && a1 != a2) {
					return 0;
				}
				else if(a1 != null && a2 != null && a1.val != a2.val)
					return 0;
			}
			return 1;
		}
	}
	
	void addToStack(Stack<TreeNode> stack, TreeNode a, boolean inorder) {
		stack.add(a);
		if(a == null)
			return;
		if(inorder) {
			addToStack(stack, a.left, inorder);
			addToStack(stack, a.right, inorder);
		}
		else {
			addToStack(stack, a.right, inorder);
			addToStack(stack, a.left, inorder);
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeNode[] a = new TreeNode[n];
		for (int i=0; i<n; i++) {
			int val = in.nextInt();
			if(val != -1) {
				a[i] = new TreeNode(val);
			}
		}
		for (int i=0; i<n; i++) {
			int left = 2*i + 1;
			int right = 2*i + 2;
			if(a[i] != null && left < n && right < n) {
				a[i].left = a[left];
				a[i].right = a[right];
			}
		}
		System.out.println(sol.isSymmetric(a[0]));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
