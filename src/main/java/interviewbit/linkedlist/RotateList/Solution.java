package interviewbit.linkedlist.RotateList;

import javax.swing.plaf.basic.BasicListUI;
import java.util.Scanner;

/**
 * Created by karthikb on 06-07-2017.
 */
public class Solution {
	public ListNode rotateRight(ListNode a, int b) {
		if(a == null)
			return null;
		ListNode ans = null, current = a;
		int len = 0;
		while(current != null)
		{
			len++;
			current = current.next;
		}
		current = a;
		b = b%len;
		if(b == 0)
			return a;
		for(int i=0; i<len-b-1; i++)
		{
			current = current.next;
		}
		ans = current.next;
		current.next = null;
		current = ans;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = a;
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		ListNode head = ListNode.readFromSTDIN(in);
		int k = in.nextInt();
		System.out.println(sol.rotateRight(head,k));
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
