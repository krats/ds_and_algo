package interviewbit.trees.SortedArrayToBalancedBinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		int n = a.size();
		if(n == 0)
			return null;
		TreeNode[] arr = new TreeNode[n];
		for(int i=0; i<n; i++) {
			arr[i] = new TreeNode(a.get(i));
		}
		return solve(arr, 0, n-1);
	}
	
	TreeNode solve(TreeNode[] arr, int start, int end) {
		if(start > end)
			return null;
		if(start == end) {
			return arr[start];
		}
		int n = end - start + 1;
		int height = (int) (Math.log(n)/Math.log(2));
		int left = (int) Math.pow(2, height-1);
		left -= 1;
		int remaining = n - 1 - left - left;
		int possibleInLeft = (int) (Math.pow(2, height-1));
		if(remaining > possibleInLeft){
			left += possibleInLeft;
		}
		else {
			left += remaining;
		}
		int mid = start + left;
		arr[mid].left = solve(arr, start, mid-1);
		arr[mid].right = solve(arr, mid+1, end);
		return arr[mid];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> a = new ArrayList<>(n);
		for(int i=0; i<n; i++)
			a.add(in.nextInt());
		TreeNode ans = sol.sortedArrayToBST(a);
		System.out.println(ans);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
