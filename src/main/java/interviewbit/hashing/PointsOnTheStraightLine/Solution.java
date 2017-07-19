package interviewbit.hashing.PointsOnTheStraightLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by karthikb on 15-07-2017.
 */
public class Solution {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		HashMap<String, HashSet<Integer>> map = new HashMap<>();
		int ans = 0;
		if(a.size() == 1)
			return 1;
		for(int i=0; i<a.size(); i++)
		{
			for(int j=i+1; j<a.size(); j++)
			{
				int x = a.get(j) - a.get(i);
				int y = b.get(j) - b.get(i);
				if(x == 0)
				{
					String key = "INF" + " "+ a.get(i);
					if(!map.containsKey(key))
						map.put(key, new HashSet<>());
					map.get(key).add(i);
					map.get(key).add(j);
					if(ans < map.get(key).size())
						ans = map.get(key).size();
				}
				else
				{
					double m = y/((double) x);
					double c = b.get(i) - m*a.get(i);
					String key = Double.toString(m) + " " + Double.toString(c);
					if(!map.containsKey(key))
						map.put(key, new HashSet<>());
					map.get(key).add(i);
					map.get(key).add(j);
					if(ans < map.get(key).size())
						ans = map.get(key).size();
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		ArrayList<Integer> b = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			a.add(in.nextInt());
			b.add(in.nextInt());
		}
		System.out.println(sol.maxPoints(a,b));
	}
}
