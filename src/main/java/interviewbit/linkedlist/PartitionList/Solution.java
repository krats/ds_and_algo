package interviewbit.linkedlist.PartitionList;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode partition(ListNode a, int b) {
		int count = 0;
		ListNode current = a;
		ListNode ans = a;
		ListNode currentAns = null;
		if(ans.val < b)
			currentAns = ans;
		while(current != null && current.next != null)
		{
			if(current.next.val < b)
			{
				if(currentAns == null)
				{
					if(ans.val < b)
					{
						ListNode temp = ans.next;
						ans.next = current.next;
						current.next = current.next.next;
						ans.next.next = temp;
						currentAns = ans.next;
					}
					else
					{
						ListNode temp = current.next;
						current.next = current.next.next;
						temp.next = ans;
						ans = temp;
						currentAns = temp;
					}
				}
				else if(currentAns != current)
				{
					while(currentAns.next.val < b)
						currentAns = currentAns.next;
					ListNode temp = currentAns.next;
					currentAns.next = current.next;
					current.next = current.next.next;
					currentAns.next.next = temp;
					currentAns = currentAns.next;
				}
				else
				{
					current = current.next;
					currentAns = currentAns.next;
				}
			}
			else
			{
				current = current.next;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		ListNode head = ListNode.readFromSTDIN(in);
		System.out.println(sol.partition(head,in.nextInt()));
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
	
	public static ListNode readFromSTDIN(Scanner in)
	{
		if(in == null)
			in = new Scanner(System.in);
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