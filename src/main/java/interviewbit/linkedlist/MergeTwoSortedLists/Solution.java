package interviewbit.linkedlist.MergeTwoSortedLists;

/**
 * Created by karthikb on 05-07-2017.
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if(a == null)
			return b;
		if(b == null)
			return a;
		ListNode ans = null, currentAns = null;
		if(a.val < b.val)
		{
			ans = a;
			currentAns = a;
			a = a.next;
		}
		else
		{
			ans = b;
			currentAns = b;
			b = b.next;
		}
		while(a != null && b != null)
		{
			if(a.val < b.val)
			{
				currentAns.next = a;
				a = a.next;
				currentAns = currentAns.next;
			}
			else
			{
				currentAns.next = b;
				b = b.next;
				currentAns = currentAns.next;
			}
		}
		if(a != null)
			currentAns.next = a;
		if(b != null)
			currentAns.next = b;
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
		ListNode current1;
		current1 = new ListNode(1);
		current1.next = new ListNode(2);
		current1.next.next = new ListNode(2);
		current1.next.next.next = new ListNode(3);
		current1.next.next.next.next = new ListNode(3);
		System.out.println(sol.mergeTwoLists(current, current1));
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