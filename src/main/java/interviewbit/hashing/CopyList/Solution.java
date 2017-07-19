package interviewbit.hashing.CopyList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by karthikb on 14-07-2017.
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		RandomListNode current = head;
		ArrayList<RandomListNode> newList = new ArrayList<>();
		HashMap<RandomListNode, Integer> map = new HashMap<>();
		int count = 0;
		while (current != null)
		{
			RandomListNode newNode = new RandomListNode(current.label);
			map.put(current, count);
			current = current.next;
			newList.add(newNode);
			count++;
		}
		current  = head;
		for(int i=0; i<count; i++)
		{
			if(current.random != null)
				newList.get(i).random = newList.get(map.get(current.random));
			current = current.next;
			if(i > 0)
			{
				newList.get(i-1).next = newList.get(i);
			}
		}
		return newList.get(0);
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};
