package interviewbit.linkedlist.ReverseList2;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
		ListNode i,current,temp,reversedHead,next;
		current = a;
		n -= m;
		while(m-1 > 1)
		{
			current = current.next;
			m--;
		}
		i = current;
		if(m>1)
		{
			current = current.next;
		}
		next = current.next;
		reversedHead = current;
		while(n > 0)
		{
			temp = next.next;
			next.next = current;
			current = next;
			next = temp;
			n--;
		}
		if(m > 1)
		{
			i.next = current;
			reversedHead.next = next;
			return a;
		}
		else
		{
			a.next = next;
			return current;
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
		System.out.println(sol.reverseBetween(current, 1, 4));
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
