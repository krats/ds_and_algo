package interviewbit.hashing.Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by karthikb on 12-07-2017.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		HashMap<String, Integer> map =  new HashMap<>();
		for(int i=0; i<a.size(); i++)
		{
			char[] current = a.get(i).toCharArray();
			Arrays.sort(current);
			String c = new String(current);
			if(map.containsKey(c))
			{
				ans.get(map.get(c)).add(i+1);
			}
			else
			{
				map.put(c, ans.size());
				ans.add(new ArrayList<>());
				ans.get(ans.size()-1).add(i+1);
			}
		}
		return ans;
	}
}
