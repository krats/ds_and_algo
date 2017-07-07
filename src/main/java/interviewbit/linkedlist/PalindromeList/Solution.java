package interviewbit.linkedlist.PalindromeList;

/**
 * Created by karthikb on 05-07-2017.
 */
public class Solution {
	public int lPalin(ListNode A) {
		int len = 0;
		ListNode current = A;
		while(current != null)
		{
			len++;
			current = current.next;
		}
		if(len <= 1)
			return 1;
		int midNode = (len+1)/2;
		current = A;
		while(midNode > 0)
		{
			current = current.next;
			midNode--;
		}
		current = reverse(current);
		ListNode left,right;
		left = A;
		right = current;
		for(int i=0; i<len/2; i++)
		{
			if(left.val != right.val)
				return 0;
			left = left.next;
			right = right.next;
		}
		reverse(current);
		return 1;
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
		ListNode current;
		current = new ListNode(1);
		current.next = new ListNode(2);
		current.next.next = new ListNode(3);
		current.next.next.next = new ListNode(2);
		current.next.next.next.next = new ListNode(1);
		System.out.println(sol.lPalin(current));
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
