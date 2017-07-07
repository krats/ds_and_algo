package interviewbit.twopointer.MaxContinuosArrayOfOnes;

import java.util.ArrayList;

/**
 * Created by karthikb on 04-07-2017.
 */
public class Solution {
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
		int i = -1;
		int j = -1;
		int n = a.size();
		int indexi = i;
		int indexj = j;
		int ans = 0;
		int k = 0;
		while(i < n && j < n)
		{
			i++;
			j++;
			if(i-1 >= 0 && k > 0 && a.get(i-1) == 0)
			{
				k--;
			}
			if(j < i)
			{
				j = i;
			}
			while(j < n && k <= b)
			{
				if(k == b && a.get(j) == 0)
					break;
				if(a.get(j) == 0)
					k++;
				j++;
			}
			j--;
			if(ans < j-i+1)
			{
				ans = j-i+1;
				indexi = i;
				indexj = j;
			}
		}
		ArrayList<Integer> ansArr = new ArrayList<Integer>(ans);
		for(int l=indexi; l<=indexj; l++)
		{
			ansArr.add(l);
		}
		return ansArr;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0};
		ArrayList<Integer> mylist = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
			mylist.add(arr[i]);
		System.out.println(sol.maxone(mylist, 7));
	}
}
