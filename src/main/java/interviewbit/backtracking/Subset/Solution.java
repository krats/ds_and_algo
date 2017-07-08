package interviewbit.backtracking.Subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		Collections.sort(a);
		int N = a.size();
		int pow = (int) Math.pow(2,N);
		ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>(pow);
		for(int i=0; i<pow; i++)
		{
			ArrayList<Integer> current = new ArrayList<>(N);
			int c = i;
			int j = 0;
			while(c > 0)
			{
				if(c%2 == 1)
				{
					current.add(a.get(j));
				}
				j++;
				c/=2;
			}
			ans.add(current);
		}
		Collections.sort(ans, new ArrayListComparator());
		return ans;
	}
	
	class ArrayListComparator implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
		{
			int n = Math.min(a.size(), b.size());
			for(int i=0; i<n; i++)
			{
				if(a.get(i) != b.get(i))
					return a.get(i)-b.get(i);
			}
			return a.size() - b.size();
		}
	}
}
