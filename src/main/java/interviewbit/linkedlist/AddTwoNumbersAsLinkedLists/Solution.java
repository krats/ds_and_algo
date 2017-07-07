package interviewbit.linkedlist.AddTwoNumbersAsLinkedLists;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode ans = a, aprev = a;
		int carry = 0;
		while(a!= null && b != null)
		{
			a.val += b.val+carry;
			carry = 0;
			if(a.val >= 10)
			{
				carry = 1;
				a.val %= 10;
			}
			aprev = a;
			a = a.next;
			b = b.next;
		}
		if(b != null)
		{
			aprev.next = b;
			a = b;
		}
		while(a != null && carry == 1)
		{
			a.val += carry;
			carry = 0;
			if(a.val >= 10)
			{
				carry = 1;
				a.val %= 10;
			}
			aprev = a;
			a = a.next;
		}
		if(carry == 1)
		{
			aprev.next = new ListNode(1);
		}
		return ans;
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
		int n1 = in.nextInt();
		ListNode head1 = null, next = null;
		for(int i=0; i<n1; i++)
		{
			if(next == null) {
				next = new ListNode(in.nextInt());
				head1 = next;
			}
			else
			{
				next.next = new ListNode(in.nextInt());
				next = next.next;
			}
		}
		int n2 = in.nextInt();
		ListNode head2 = null;
		next = null;
		for(int i=0; i<n2; i++)
		{
			if(next == null) {
				next = new ListNode(in.nextInt());
				head2 = next;
			}
			else
			{
				next.next = new ListNode(in.nextInt());
				next = next.next;
			}
		}
		head1 = sol.reverse(head1);
		head2 = sol.reverse(head2);
		System.out.println(sol.addTwoNumbers(head1, head2));
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
