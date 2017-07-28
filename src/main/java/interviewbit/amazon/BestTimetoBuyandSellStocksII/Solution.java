package interviewbit.amazon.BestTimetoBuyandSellStocksII;

import java.util.List;

public class Solution {
	public int maxProfit(final List<Integer> a) {
		int ans = 0;
		int n = a.size();
		for(int i=1; i < n; i++) {
			if(a.get(i-1) < a.get(i)) {
				ans += a.get(i) - a.get(i-1);
			}
		}
		return ans;
	}
}
