package leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Integer, Character> map2 = new HashMap<>();
        int ans = 0;
        int lastIndex = -1;
        for(int i=0; i<s.length(); i++) {
            if(map1.containsKey(s.charAt(i))) {
                int index = map1.get(s.charAt(i));
                for(int j = index; j > lastIndex; j--) {
                    Character c = map2.get(j);
                    map1.remove(c);
                    map2.remove(j);
                }
                lastIndex = index-1;
            }
            map1.put(s.charAt(i), i);
            map2.put(i, s.charAt(i));
            int len = map1.size();
            if(len > ans) {
                ans = len;
            }
        }
        return ans;
    }
}
