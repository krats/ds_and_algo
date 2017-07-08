package interviewbit.backtracking.Subset2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by karthikb on 08-07-2017.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		Collections.sort(a);
		int N = a.size();
		int pow = (int) Math.pow(2,N);
		ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>(pow);
		Comparator<ArrayList<Integer>> comp = new ArrayListComparator();
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
		Collections.sort(ans, comp);
		ArrayList<ArrayList<Integer>> ans1 = new ArrayList<ArrayList<Integer>>(pow);
		ans1.add(new ArrayList<>());
		for(int i=1; i<ans.size(); i++)
		{
			if(comp.compare(ans.get(i),ans1.get(ans1.size()-1)) != 0)
				ans1.add(ans.get(i));
		}
		return ans1;
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
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			arr.add(in.nextInt());
		}
		System.out.println(sol.subsetsWithDup(arr));
	}
}
