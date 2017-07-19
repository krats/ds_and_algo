package interviewbit.heapsandmaps.MergeKSortedLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by karthikb on 17-07-2017.
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		TreeMap<Integer, ArrayList<ListNode>> map = new TreeMap<>();
		ListNode ans = null;
		ListNode current = null;
		for(int i=0; i<a.size(); i++) {
			if(map.containsKey(a.get(i).val))
				map.get(a.get(i).val).add(a.get(i));
			else {
				ArrayList<ListNode> c = new ArrayList<>();
				c.add(a.get(i));
				map.put(a.get(i).val, c);
			}
		}
		while (map.size() != 0) {
			int key = map.firstKey();
			ListNode l = map.get(key).get(0);
			map.get(key).remove(0);
			if(map.get(key).size() == 0)
				map.remove(key);
			if(l.next != null) {
				if(map.containsKey(l.next.val)) {
					map.get(l.next.val).add(l.next);
				}
				else {
					ArrayList<ListNode> c = new ArrayList<>();
					c.add(l.next);
					map.put(l.next.val, c);
				}
			}
			if(current == null) {
				ans = l;
				current = l;
			}
			else {
				current.next = l;
				current = current.next;
			}
		}
		return ans;
	}
}

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}
