package interviewbit.hashing.LongestSubStringWithoutRepeat;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karthikb on 14-07-2017.
 */
public class Solution {
	public int lengthOfLongestSubstring(String a) {
		HashMap<Character, Integer> map = new HashMap<>();
		int ans = 0;
		int current = 0;
		for(int i=0; i<a.length(); i++) {
			Character c = a.charAt(i);
			if(map.containsKey(c)) {
				int index = map.get(c);
				map = new HashMap<>();
				i = index;
				current = 0;
			}
			else {
				current++;
				if(current > ans)
					ans = current;
				map.put(c,i);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLongestSubstring("dadbc"));
	}
}
