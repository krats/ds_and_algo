package interviewbit.hashing.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by karthikb on 11-07-2017.
 */
public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		ArrayList<Integer> ans = new ArrayList<Integer>(2);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<a.size(); i++)
		{
			if(map.containsKey(b-a.get(i)))
			{
				ans.add(map.get(b-a.get(i))+1);
				ans.add(i+1);
				break;
			}
			else if(!map.containsKey(a.get(i)))
			{
				map.put(a.get(i), i);
			}
		}
		return ans;
	}
}
