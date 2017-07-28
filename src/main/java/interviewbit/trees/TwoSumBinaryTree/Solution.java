package interviewbit.trees.TwoSumBinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public int t2Sum(TreeNode A, int B) {
		Stack<TreeNode> in = new Stack<>();
		Stack<TreeNode> post = new Stack<>();
		TreeNode current1 = A;
		while (current1 != null) {
			in.push(current1);
			current1 = current1.left;
		}
		TreeNode current2 = A;
		while (current2 != null) {
			post.push(current2);
			current2 = current2.right;
		}
		boolean start = true;
		TreeNode c1=null,c2=null;
		while (in.size() != 0 && post.size() != 0) {
			if(start) {
				c1 = in.pop();
				if (c1.right != null) {
					current1 = c1.right;
					
					while (current1 != null) {
						in.push(current1);
						current1 = current1.left;
					}
				}
				c2 = post.pop();
				if (c2.left != null) {
					current2 = c2.left;
					
					while (current2 != null) {
						post.push(current2);
						current2 = current2.right;
					}
				}
				start = false;
			}
			if(c1.val == c2.val)
				return 0;
			if(c1.val + c2.val == B)
				return 1;
			else if(c1.val + c2.val > B) {
				c2 = post.pop();
				if (c2.left != null) {
					current2 = c2.left;
					
					while (current2 != null) {
						post.push(current2);
						current2 = current2.right;
					}
				}
			}
			else {
				c1 = in.pop();
				if (c1.right != null) {
					current1 = c1.right;
					
					while (current1 != null) {
						in.push(current1);
						current1 = current1.left;
					}
				}
			}
		}
		return 0;
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
		int b = in.nextInt();
		System.out.println(sol.t2Sum(a[0], b));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}