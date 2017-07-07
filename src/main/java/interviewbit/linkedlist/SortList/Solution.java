package interviewbit.linkedlist.SortList;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode sortList(ListNode a) {
		if(a == null || a.next == null)
			return a;
		ListNode current = a;
		int len = 0;
		while (current != null){
			current = current.next;
			len++;
		}
		a = mergeSort(a, len);
		return a;
	}
	
	public ListNode mergeSort(ListNode a, int len)
	{
		if(len == 0 || len == 1)
			return a;
		else
		{
			ListNode current = a;
			ListNode prev = a;
			int mid = len/2;
			while(mid > 0)
			{
				prev = current;
				current = current.next;
				mid--;
			}
			prev.next = null;
			current = mergeSort(current, len-len/2);
			a = mergeSort(a, len/2);
			a = merge(current, a);
			return a;
		}
	}
	
	public ListNode merge(ListNode a, ListNode b)
	{
		if(a == null)
			return b;
		if(b == null)
			return a;
		ListNode head = null;
		ListNode current = null;
		while (a != null && b != null) {
			if (a.val < b.val) {
				if(current == null) {
					head = a;
					current = a;
					a = a.next;
				}
				else
				{
					current.next = a;
					a = a.next;
					current = current.next;
				}
			} else {
				if(current == null) {
					head = b;
					current = b;
					b = b.next;
				}
				else
				{
					current.next = b;
					b = b.next;
					current = current.next;
				}
			}
		}
		if(a != null)
			current.next = a;
		if(b != null)
			current.next = b;
		return head;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = ListNode.readFromSTDIN();
		System.out.println(sol.sortList(head));
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