package interviewbit.trees.PathSum;


import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public int hasPathSum(TreeNode a, int b) {
		if(a == null) {
			return b == 0 ? 1 : 0;
		}
		if(a.val == b && a.left == null && a.right == null) {
			return 1;
		}
		if(a.left != null) {
			if(hasPathSum(a.left, b-a.val) == 1) {
				return 1;
			}
		}
		if(a.right != null) {
			if(hasPathSum(a.right, b-a.val) == 1) {
				return 1;
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
		System.out.println(sol.hasPathSum(a[0], b));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}