package interviewbit.trees.KthSmallestElementInTree;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	
	public int kthsmallest(TreeNode root, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
		addtoqueue(queue, root, k);
		return queue.poll();
	}
	
	void addtoqueue(PriorityQueue<Integer> queue, TreeNode root, int k) {
		if(root == null)
			return;
		if(queue.size() == k) {
			if(queue.peek() > root.val) {
				queue.poll();
				queue.offer(root.val);
			}
		}
		else {
			queue.offer(root.val);
		}
		addtoqueue(queue, root.left, k);
		addtoqueue(queue, root.right, k);
	}
	
	int ans = 0;
	public int kthsmallest2(TreeNode root, int k) {
		solve(root, k);
		return ans;
	}
	
	int solve(TreeNode root, int k) {
		if(root == null)
			return 0;
		int left = solve(root.left, k);
		if(left >= k)
			return left;
		if(left + 1 == k)
		{
			ans = root.val;
			return k;
		}
		int right = solve(root.right, k-left-1);
		return left+right+1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}