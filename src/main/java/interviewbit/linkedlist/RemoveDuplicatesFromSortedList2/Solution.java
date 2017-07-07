package interviewbit.linkedlist.RemoveDuplicatesFromSortedList2;

import java.util.HashMap;

/**
 * Created by karthikb on 05-07-2017.
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
		ListNode ans=null,currentAns=null, temp;
		ListNode current = a;
		ListNode prev = null;
		while(current != null)
		{
			if(current.next != null && current.val == current.next.val)
			{
				temp = current;
				while(temp!=null && temp.val == current.val)
				{
					temp = temp.next;
				}
				current = temp;
			}
			else
			{
				if(ans == null)
				{
					ans = current;
					currentAns = current;
				}
				else
				{
					currentAns.next = current;
					currentAns = currentAns.next;
				}
				current = current.next;
			}
		}
		if(currentAns != null)
			currentAns.next = null;
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode current;
		current = new ListNode(1);
		current.next = new ListNode(2);
		current.next.next = new ListNode(2);
		current.next.next.next = new ListNode(3);
		current.next.next.next.next = new ListNode(3);
		System.out.println(sol.deleteDuplicates(current));
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