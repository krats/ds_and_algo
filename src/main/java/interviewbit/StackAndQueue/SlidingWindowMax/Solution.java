package interviewbit.StackAndQueue.SlidingWindowMax;

import java.util.*;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
		ArrayList<Integer> ans = new ArrayList<>(a.size()-b+1);
		Deque<Integer> que = new LinkedList<Integer>();
		for(int i=0; i<b; i++)
		{
			while(!que.isEmpty() && a.get(i) >= a.get(que.peekLast()))
				que.removeLast();
			que.addLast(i);
		}
		ans.add(a.get(que.peekFirst()));
		for(int i=1; i<a.size()-b+1; i++)
		{
			if(que.peekFirst() == i-1)
			{
				que.removeFirst();
			}
			while(!que.isEmpty() && a.get(i+b-1) >= a.get(que.peekLast()))
				que.removeLast();
			que.addLast(i+b-1);
			ans.add(a.get(que.peekFirst()));
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> arr = new ArrayList<>(n);
		for(int i=0; i<n; i++)
			arr.add(in.nextInt());
		System.out.println(sol.slidingMaximum(arr, in.nextInt()));
	}
}
