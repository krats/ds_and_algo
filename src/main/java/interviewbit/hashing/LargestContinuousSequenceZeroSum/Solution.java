package interviewbit.hashing.LargestContinuousSequenceZeroSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by karthikb on 11-07-2017.
 */
public class Solution {
	public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		ArrayList<Integer> ans = new ArrayList<>(2);
		int maxSize = 0;
		int indexi = -1;
		int indexj = -1;
		int sum = 0;
		for(int i=1; i<a.size(); i++)
		{
			a.set(i,a.get(i-1)+a.get(i));
		}
		a.add(0,0);
		HashMap<Integer, Integer> map = new HashMap();
		for(int i=0; i<a.size(); i++)
		{
			if(map.containsKey(a.get(i)))
			{
				if(maxSize < i - map.get(a.get(i))+1)
				{
					maxSize = i - map.get(a.get(i))+1;
					indexi = map.get(a.get(i));
					indexj = i-1;
				}
			}
			else {
				map.put(a.get(i), i);
			}
		}
		a.remove(0);
		for(int i=a.size()-1; i>=1; i--)
		{
			a.set(i,a.get(i)-a.get(i-1));
		}
		if(indexi != -1)
		{
			for(int i=indexi; i<=indexj; i++)
			{
				ans.add(a.get(i));
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for (int i=0; i<n; i++)
			arr.add(in.nextInt());
		System.out.println(sol.lszero(arr));
	}
}
