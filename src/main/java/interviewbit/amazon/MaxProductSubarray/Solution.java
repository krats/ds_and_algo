package interviewbit.amazon.MaxProductSubarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public int maxProduct(final List<Integer> a) {
		int n = a.size();
		int ans = 0;
		int max_ending_here = 1;
		int min_ending_here = 1;
		for(int i=0; i<n; i++) {
			if(a.get(i) > 0) {
				max_ending_here = max_ending_here*a.get(i);
				min_ending_here = Math.min(min_ending_here*a.get(i), 1);
			}
			else if(a.get(i) < 0) {
				int temp = max_ending_here;
				max_ending_here = min_ending_here*a.get(i);
				min_ending_here = temp*a.get(i);
			}
			else {
				max_ending_here = 1;
				min_ending_here = 1;
			}
			if(a.get(i) != 0 && ans < max_ending_here)
				ans = max_ending_here;
			max_ending_here = Math.max(max_ending_here, 1);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		for (int i=0; i<n; i++) {
			a.add(in.nextInt());
		}
		System.out.println(sol.maxProduct(a));
	}
}
