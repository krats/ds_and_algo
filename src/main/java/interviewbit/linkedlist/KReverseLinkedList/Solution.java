package interviewbit.linkedlist.KReverseLinkedList;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode reverseList(ListNode A, int B) {
		if(B == 1)
			return A;
		ListNode ans = null, currentAns = null;
		ListNode next = A;
		while (next != null)
		{
			ListNode nextNext = next;
			ListNode prev = next;
			for(int i=0; i<B; i++)
			{
				prev = nextNext;
				nextNext = nextNext.next;
			}
			prev.next = null;
			ListNode newHead = reverse(next);
			if(ans == null)
			{
				ans = newHead;
				currentAns = next;
			}
			else
			{
				currentAns.next = newHead;
				currentAns = next;
			}
			next = nextNext;
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
		System.out.println(sol.reverseList(head, 2));
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