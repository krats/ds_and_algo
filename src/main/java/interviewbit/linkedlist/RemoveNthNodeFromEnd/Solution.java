package interviewbit.linkedlist.RemoveNthNodeFromEnd;

/**
 * Created by karthikb on 05-07-2017.
 */
public class Solution {
	
	public ListNode removeNthFromEnd(ListNode a, int b) {
		int len = 0;
		ListNode current = a;
		while (current != null)
		{
			len++;
			current = current.next;
		}
		if(b >= len)
		{
			return a.next;
		}
		else
		{
			current = a;
			b = len-b-1;
			while(b > 0)
			{
				current = current.next;
				b--;
			}
			current.next = current.next.next;
			return a;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode current;
		current = new ListNode(1);
		current.next = new ListNode(2);
		current.next.next = new ListNode(2);
		current.next.next.next = new ListNode(3);
		current.next.next.next.next = new ListNode(3);
		System.out.println(sol.removeNthFromEnd(current, 4));
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