package interviewbit.linkedlist.ListCycle;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode detectCycle(ListNode a) {
		ListNode current1=a,current2=a;
		boolean hasCycle = false;
		while(current1 != null && current2 != null && current2.next != null)
		{
			current1 = current1.next;
			current2 = current2.next.next;
			if(current1 == current2)
			{
				hasCycle = true;
				break;
			}
		}
		if(!hasCycle)
			return null;
		else
		{
			current1 = current1.next;
			int cycleLength = 1;
			while(current1 != current2)
			{
				cycleLength++;
				current1 = current1.next;
			}
			current1 = a;
			
			for(int i=0; i<cycleLength; i++)
			{
				current1 = current1.next;
			}
			while(a != current1)
			{
				a = a.next;
				current1 = current1.next;
			}
			return a;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = ListNode.readFromSTDIN();
		System.out.println(sol.detectCycle(head));
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
