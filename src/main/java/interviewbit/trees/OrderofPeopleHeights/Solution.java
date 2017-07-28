package interviewbit.trees.OrderofPeopleHeights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
		int n = heights.size();
		ArrayList<Integer> ans = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			ans.add(-1);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(heights.get(i), infronts.get(i));
		}
		Collections.sort(heights);
		for(int i=0; i<n; i++) {
			int current = heights.get(i);
			int left = map.get(i);
			int j=0;
			while (left >= 0){
				if(ans.get(j) == -1) {
					left--;
				}
				j++;
			}
			ans.set(j, current);
		}
		return ans;
	}
}
