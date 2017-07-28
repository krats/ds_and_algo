package interviewbit.amazon.BestTimetoBuyandSellStocksIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public int maxProfit(final List<Integer> a) {
		int n = a.size();
		if(n <= 1)
			return 0;
		int[] right = new int[n];
		int[] left = new int[n];
		int minimum = a.get(0);
		for(int i=1; i<n; i++) {
			minimum = Math.min(minimum, a.get(i));
			left[i] = Math.max(left[i-1], a.get(i) - minimum);
		}
		int maximum = a.get(n-1);
		for(int i=n-2; i>=0; i--) {
			maximum = Math.max(maximum, a.get(i));
			right[i] = Math.max(right[i+1], maximum - a.get(i));
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(ans < left[i] + right[i]) {
				ans = left[i] + right[i];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		System.out.println(sol.maxProfit(a));
	}
}
