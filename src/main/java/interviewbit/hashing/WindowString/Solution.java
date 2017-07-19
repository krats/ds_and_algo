package interviewbit.hashing.WindowString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karthikb on 15-07-2017.
 */
public class Solution {
	public String minWindow(String S, String T) {
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		for(int i=0; i<T.length(); i++)
		{
			set.add(T.charAt(i));
			if(map.containsKey(T.charAt(i)))
				map.put(T.charAt(i), map.get(T.charAt(i))+1);
			else
				map.put(T.charAt(i), 1);
		}
		int ans = Integer.MAX_VALUE;
		int start = -1;
		int starti = -1;
		int endi = -1;
		HashMap<Character, Integer> counts = new HashMap<>();
		for(int i=0; i<S.length(); i++)
		{
			if(set.contains(S.charAt(i)) && !map.containsKey(S.charAt(i)))
			{
				if(counts.containsKey(S.charAt(i)))
					counts.put(S.charAt(i), counts.get(S.charAt(i))+1);
				else
					counts.put(S.charAt(i), 1);
			}
			if(map.containsKey(S.charAt(i)))
			{
				if(start == -1)
					start = i;
				int count = map.get(S.charAt(i));
				if(count == 1)
					map.remove(S.charAt(i));
				else
					map.put(S.charAt(i), map.get(S.charAt(i))-1);
			}
			if(map.size() == 0)
			{
				while (counts.size() != 0 || !set.contains(S.charAt(start)))
				{
					Character c = S.charAt(start);
					if(counts.containsKey(c)) {
						counts.put(c, counts.get(c)-1);
						if(counts.get(c) == 0)
						{
							counts.remove(c);
						}
					}
					else if(set.contains(c))
						break;
					start++;
				}
				if(ans > i - start + 1) {
					ans = i - start + 1;
					starti = start;
					endi = i;
				}
				map.put(S.charAt(start), 1);
				start = start+1;
			}
		}
		if(starti != -1)
			return S.substring(starti, endi+1);
		return "";
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
	}
}
