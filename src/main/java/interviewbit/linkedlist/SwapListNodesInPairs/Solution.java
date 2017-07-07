package interviewbit.linkedlist.SwapListNodesInPairs;

import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	
	public ListNode swapPairs(ListNode a) {
		ListNode current = a, ans=a, temp;
		while(current != null && current.next != null)
		{
			temp = current.next.next;
			current.next.next = current;
			if(ans == a)
			{
				ans = current.next;
			}
			current.next = temp;
			if(temp != null && temp.next != null)
				current.next = temp.next;
			current = temp;
		}
		return ans;
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
		System.out.println(sol.swapPairs(head));
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
