package interviewbit.linkedlist.InsertionSortList;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode insertionSortList(ListNode a) {
		ListNode prev = a, current = a.next;
		while(current != null)
		{
			if(current.val >= prev.val)
			{
				prev = current;
				current = current.next;
				continue;
			}
			prev.next = current.next;
			if(current.val < a.val)
			{
				current.next = a;
				a = current;
			}
			else
			{
				ListNode c = a;
				while(c.next.val < current.val)
				{
					c = c.next;
				}
				ListNode temp = c.next;
				c.next = current;
				current.next = temp;
			}
			current = prev.next;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = ListNode.readFromSTDIN();
		System.out.println(sol.insertionSortList(head));
	}
}

class ListNode {
	public int val;
	public ListNode next;
	
	ListNode(int x)
	{
		val = x; next = null;
	}
	
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
	
	public int length()
	{
		ListNode current = this;
		int ans = 0;
		while(current != null)
		{
			ans++;
			current = current.next;
		}
		return ans;
	}
	
	public static ListNode readFromSTDIN()
	{
		Scanner in = new Scanner(System.in);
		ListNode head = null, next = null;
		int n = in.nextInt();
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
		return head;
	}
}