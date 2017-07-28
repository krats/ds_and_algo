package interviewbit.amazon.BestTimetoBuyandSellStocksI;

import java.util.List;

public class Solution {
	public int maxProfit(final List<Integer> a) {
		int n = a.size();
		if(n <= 1)
			return 0;
		int[] left = new int[n];
		int minimum = a.get(0);
		for(int i=1; i<n; i++) {
			minimum = Math.min(minimum, a.get(i));
			left[i] = Math.max(left[i-1], a.get(i) - minimum);
		}
		return left[n-1];
	}
}
