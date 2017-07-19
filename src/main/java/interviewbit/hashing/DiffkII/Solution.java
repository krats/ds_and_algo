package interviewbit.hashing.DiffkII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by karthikb on 12-07-2017.
 */
public class Solution {
	public int diffPossible(final List<Integer> a, int b) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<a.size(); i++)
		{
			int c = a.get(i);
			if(set.contains(c-b))
				return 1;
			else if(set.contains(b+c))
				return 1;
			set.add(c);
		}
		return 0;
	}
}
