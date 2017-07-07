package interviewbit.linkedlist.RemoveDuplicatesFromSortedList;

/**
 * Created by karthikb on 05-07-2017.
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
		if(a == null)
			return a;
		ListNode ans = a,current = a;
		current = current.next;
		while (current != null)
		{
			if(current.val != a.val)
			{
				a.next = current;
				a = a.next;
			}
			current = current.next;
		}
		a.next = null;
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
