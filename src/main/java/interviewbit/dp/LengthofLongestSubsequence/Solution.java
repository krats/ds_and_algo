package interviewbit.dp.LengthofLongestSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public int longestSubsequenceLength(final List<Integer> A) {
		int n = A.size();
		ArrayList<Integer> left = new ArrayList<>(n);
		for(int i=0; i<n; i++) {
			int current = A.get(i);
			int val = 1;
			for(int j=i-1; j >=0; j--) {
				if(current > A.get(j)) {
					val = Math.max(val, left.get(j)+1);
				}
			}
			left.add(val);
		}
		ArrayList<Integer> right = new ArrayList<>(n);
		for(int i=n-1; i>=0; i--) {
			int current = A.get(i);
			int val = 1;
			for(int j=i+1; j < n; j++) {
				if(current > A.get(j)) {
					val = Math.max(val, right.get(n - j - 1)+1);
				}
			}
			right.add(val);
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans = Math.max(left.get(i) + right.get(n - i - 1) - 1, ans);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			arr.add(in.nextInt());
		}
		System.out.println(sol.longestSubsequenceLength(arr));
	}
}
