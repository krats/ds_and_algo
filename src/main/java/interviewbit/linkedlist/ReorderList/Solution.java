package interviewbit.linkedlist.ReorderList;

import dp.LIS;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	public ListNode reorderList(ListNode a) {
		int len = 0;
		ListNode current = a, temp1, temp2;
		while(current != null)
		{
			len++;
			current = current.next;
		}
		if(len <= 2)
			return a;
		ListNode right = a;
		int mid = (len+1)/2;
		for(int i=1; i<mid; i++)
		{
			right = right.next;
		}
		current = right;
		right = right.next;
		current.next = null;
		right = reverse(right);
		current = a;
		ListNode prev = current;
		while(right != null)
		{
			temp1 = current.next;
			temp2 = right.next;
			current.next = right;
			right.next = temp1;
			prev = right;
			current = temp1;
			right = temp2;
		}
		if(len %2 == 0)
			prev.next = null;
		else
			current.next = null;
		return a;
	}
	
	public ListNode reverse (ListNode head)
	{
		ListNode current,next,temp;
		current = head;
		next = current.next;
		while(next != null)
		{
			temp = next.next;
			next.next = current;
			current = next;
			next = temp;
		}
		head.next = null;
		return current;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ListNode head = null, next = null;
		for(int i=0; i<n; i++)
		{
			if(next == null) {
				next = new ListNode(in.nextInt());
				head = next;
			}
			else
			{
				next.next = new ListNode(in.nextInt());
				next = next.next;
			}
		}
		System.out.println(sol.reorderList(head));
	}
}

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
	public String toString()
	{
		ListNode current = this;
		StringBuilder ans = new StringBuilder();
		while(current != null)
		{
			ans.append(current.val + "->");
			current = current.next;
		}
		ans.delete(ans.length()-2, ans.length());
		return ans.toString();
	}
}