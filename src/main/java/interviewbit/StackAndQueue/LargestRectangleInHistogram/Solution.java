package interviewbit.StackAndQueue.LargestRectangleInHistogram;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	
	public int largestRectangleArea(ArrayList<Integer> a) {
		Stack<Pair> stck = new Stack<>();
		int ans = 0;
		for(int i=0; i<a.size(); i++) {
			if(stck.empty() || stck.peek().height <= a.get(i))
				stck.push(new Pair(i, a.get(i)));
			else
			{
				Pair current = stck.pop();
				ans = Math.max(ans, (stck.empty() ? i : i - stck.peek().index - 1)*current.height);
				i--;
			}
		}
		while (!stck.empty())
		{
			Pair current = stck.pop();
			ans = Math.max(ans, (stck.empty() ? a.size(): a.size() - stck.peek().index - 1)*current.height);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// 94 47 69 67 97 86 34 98 16 65 95 66 69 18 1 99 56 35 9 48 72 49 47 1 72 87 52 13 23 95 55 21 92 36 88 48 39 84 16 15 65 7 58 2 21 54 2 71 92 96 100 28 31 24 10 94 5 81 80 43 35 67 33 39 81 69 12 66 87 86 11 49 94 38 44 72 44 18 97 23 11 30 72 51 61 56 41 30 71 12 44 81 43 43 27
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			arr.add(in.nextInt());
		}
		System.out.println(sol.largestRectangleArea(arr));
	}
}

class Pair {
	int height;
	int index;
	public Pair(int index, int height)
	{
		this.index = index;
		this.height = height;
	}
}
