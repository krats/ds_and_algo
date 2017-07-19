package interviewbit.hashing.FourSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by karthikb on 12-07-2017.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<a.size(); i++)
		{
			for(int j=i+1; j<a.size(); j++)
			{
				int sum = a.get(i)+a.get(j);
				int target = b-sum;
				int k = j+1;
				int l = a.size()-1;
				while (k < l)
				{
					int c = a.get(k) + a.get(l);
					if(c == target)
					{
						int k1 = k;
						int l1 = l;
						while (k1 < l1 && c == target)
						{
							ArrayList<Integer> current = new ArrayList<>(4);
							current.add(a.get(i));
							current.add(a.get(j));
							current.add(a.get(k));
							current.add(a.get(l));
							Collections.sort(current);
							ans.add(current);
							l1--;
							c = a.get(k1) + a.get(l1);
						}
						k++;
					}
					else if(c > target)
					{
						l--;
					}
					else
					{
						k++;
					}
				}
			}
		}
		Comparator<ArrayList<Integer>> comp = new ArrayListComparator();
		Collections.sort(ans, comp);
		ArrayList<ArrayList<Integer>> aaa = new ArrayList<>(ans.size());
		if(ans.size() > 0)
			aaa.add(ans.get(0));
		int current = 0;
		for(int i=1; i<ans.size(); i++)
		{
			if(comp.compare(aaa.get(current), ans.get(i)) != 0)
			{
				current++;
				aaa.add(ans.get(i));
			}
		}
		return aaa;
	}
	
	class ArrayListComparator implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
		{
			if(a.get(0) != b.get(0))
			{
				return a.get(0) - b.get(0);
			}
			else if(a.get(1) != b.get(1))
			{
				return a.get(1) - b.get(1);
			}
			else if(a.get(2) != b.get(2))
			{
				return a.get(2) - b.get(2);
			}
			else
			{
				return a.get(3) - b.get(3);
			}
		}
	}
}
