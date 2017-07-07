package interviewbit.twopointer.NUMRANGE;

import java.util.ArrayList;

/**
 * Created by karthikb on 04-07-2017.
 */
public class Solution {
	public int numRange(ArrayList<Integer> a, int b, int c) {
		int i = 0;
		int j = 0;
		int ans = 0;
		int N = a.size();
		int sum = a.get(i);
		for(i=0; i<N; i++)
		{
			sum = 0;
			for(j=i; j<N && sum < c; j++)
			{
				sum += a.get(j);
				if(sum >=b && sum <= c)
				{
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int arr[];
		ArrayList<Integer> mylist;
		
		arr = new int[] {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};
		mylist = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
			mylist.add(arr[i]);
		System.out.println("Expected = 58 and Actual = " + sol.numRange(mylist, 99, 269));
	}
}
