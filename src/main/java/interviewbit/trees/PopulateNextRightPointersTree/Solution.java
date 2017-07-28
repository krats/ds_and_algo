package interviewbit.trees.PopulateNextRightPointersTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public void connect(TreeLinkNode a) {
		Queue<TreeLinkNode> stacks0 = new LinkedList<>();
		Queue<TreeLinkNode> stacks1 = new LinkedList<>();
		TreeLinkNode current;
		int index = 0;
		stacks0.add(a);
		while (stacks0.size() != 0 || stacks1.size() != 0) {
			if(index == 0){
				current = stacks0.poll();
				if(stacks0.size() != 0) {
					current.next = stacks0.peek();
				}
				else {
					current.next = null;
				}
				if(current.left != null) {
					stacks1.add(current.left);
				}
				if(current.right != null) {
					stacks1.add(current.right);
				}
				if(stacks0.size() == 0){
					index = 1;
				}
			}
			else {
				current = stacks1.poll();
				if(stacks1.size() != 0) {
					current.next = stacks1.peek();
				}
				else {
					current.next = null;
				}
				if(current.left != null) {
					stacks0.add(current.left);
				}
				if(current.right != null) {
					stacks0.add(current.right);
				}
				if(stacks1.size() == 0){
					index = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeLinkNode[] a = new TreeLinkNode[n];
		for (int i=0; i<n; i++) {
			int val = in.nextInt();
			if(val != -1) {
				a[i] = new TreeLinkNode(val);
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
		sol.connect(a[0]);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	TreeLinkNode(int x) { val = x; }
}
