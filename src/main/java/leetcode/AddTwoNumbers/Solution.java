package leetcode.AddTwoNumbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = null;
        ListNode prev = null;
        while (l1 != null && l2 !=null) {
            int current = l1.val + l2.val + carry;
            carry = current/10;
            current = current % 10;
            ListNode currentNode = new ListNode(current);
            if(prev == null) {
                prev = currentNode;
                ans = currentNode;
            } else {
                prev.next = currentNode;
                prev = currentNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            int current = l1.val + carry;
            carry = current/10;
            current = current % 10;
            ListNode currentNode = new ListNode(current);
            if(prev == null) {
                prev = currentNode;
                ans = currentNode;
            } else {
                prev.next = currentNode;
                prev = currentNode;
            }
            l1 = l1.next;
        }
        if(carry > 0) {
            ListNode currentNode = new ListNode(carry);
            prev.next = currentNode;
        }
        return ans;
    }
}
