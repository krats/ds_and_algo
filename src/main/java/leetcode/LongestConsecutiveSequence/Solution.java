package leetcode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> minMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> maxMap = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(!set.contains(nums[i])) {
                if (minMap.containsKey(nums[i] + 1)) {
                    int max = minMap.get(nums[i] + 1);

                    minMap.remove(nums[i] + 1);
                    maxMap.remove(max);

                    maxMap.put(max, nums[i]);
                    minMap.put(nums[i], max);

                    if (maxMap.containsKey(nums[i] - 1)) {
                        int newMin = maxMap.get(nums[i] - 1);
                        int newMax = minMap.get(nums[i]);

                        minMap.remove(nums[i]);
                        minMap.remove(newMin);

                        maxMap.remove(nums[i] - 1);
                        maxMap.remove(newMax);

                        minMap.put(newMin, newMax);
                        maxMap.put(newMax, newMin);
                    }

                } else if (maxMap.containsKey(nums[i] - 1)) {
                    int min = maxMap.get(nums[i] - 1);

                    maxMap.remove(nums[i] - 1);
                    minMap.remove(min);

                    minMap.put(min, nums[i]);
                    maxMap.put(nums[i], min);

                    if (minMap.containsKey(nums[i] + 1)) {
                        int newMax = minMap.get(nums[i] + 1);
                        int newMin = maxMap.get(nums[i]);

                        minMap.remove(nums[i] + 1);
                        minMap.remove(newMin);

                        maxMap.remove(nums[i]);
                        maxMap.remove(newMax);

                        minMap.put(newMin, newMax);
                        maxMap.put(newMax, newMin);
                    }
                } else {
                    minMap.put(nums[i], nums[i]);
                    maxMap.put(nums[i], nums[i]);
                }
            }
            set.add(nums[i]);
        }

        int len = 0;
        for(int item : minMap.keySet()) {
            int newLen = minMap.get(item) - item + 1;
            if(newLen > len) {
                len = newLen;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7}));
    }
}
