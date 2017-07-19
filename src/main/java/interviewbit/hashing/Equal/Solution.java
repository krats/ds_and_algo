package interviewbit.hashing.Equal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by karthikb on 13-07-2017.
 */
public class Solution {
	public ArrayList<Integer> equal(ArrayList<Integer> a) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<a.size(); i++)
		{
			if(!map.containsKey(a.get(i)))
			{
				map.put(a.get(i), new ArrayList<>());
			}
			map.get(a.get(i)).add(i);
		}
		ArrayList<Integer> ans = new ArrayList<>(4);
		for(int i=0; i<a.size(); i++)
		{
			for(int j=0; j<a.size(); j++)
			{
				for(int k=0; k<a.size(); k++)
				{
					if(i != k && j != k && i != j)
					{
						int sum = a.get(i)+a.get(j)-a.get(k);
						if(map.containsKey(sum))
						{
							ArrayList<Integer> c = map.get(sum);
							for(int s=0; s<c.size(); s++) {
								int l = c.get(s);
								if (l != i && l != j && l != k) {
									ans.add(i);
									ans.add(j);
									ans.add(k);
									ans.add(l);
									return ans;
								}
							}
						}
					}
				}
			}
		}
		return ans;
	}
}
