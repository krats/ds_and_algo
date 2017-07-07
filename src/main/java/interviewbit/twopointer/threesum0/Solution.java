package interviewbit.twopointer.threesum0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by karthikb on 03-07-2017.
 */
public class Solution {
	
	class Mycomparator implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
		{
			if(a.get(0) != b.get(0))
				return a.get(0)-b.get(0);
			if(a.get(1) != b.get(1))
				return a.get(1)-b.get(1);
			return a.get(2)-b.get(2);
		}
	}
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(a.size());
		Collections.sort(a);
		for(int i=0; i<a.size()-2; i++)
		{
			int j = i+1;
			int k = a.size()-1;
			int x = 0 - a.get(i);
			while(j < k)
			{
				int current = a.get(j)+a.get(k);
				if(current == x)
				{
					ArrayList<Integer> triplet = new ArrayList<Integer>(3);
					triplet.add(a.get(i));
					triplet.add(a.get(j));
					triplet.add(a.get(k));
					ans.add(triplet);
					j++;
					k--;
				}
				else if(current < x)
				{
					j++;
				}
				else
				{
					k--;
				}
			}
		}
		Comparator comp = new Mycomparator();
		Collections.sort(ans, comp);
		ArrayList<ArrayList<Integer>> newans = new ArrayList<ArrayList<Integer>>(ans.size());
		for(int i=0; i<ans.size(); i++)
		{
			if(newans.size() > 0 && comp.compare(newans.get(newans.size()-1),ans.get(i)) != 0)
			{
				newans.add(ans.get(i));
			}
			else if(newans.size() == 0)
				newans.add(ans.get(i));
		}
		return newans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = new int[]{1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
		ArrayList<Integer> mylist = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
			mylist.add(arr[i]);
		System.out.println(sol.threeSum(mylist));
	}
}

