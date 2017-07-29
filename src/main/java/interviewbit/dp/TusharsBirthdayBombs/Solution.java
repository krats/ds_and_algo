package interviewbit.dp.TusharsBirthdayBombs;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> S1 = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<B.size(); i++) {
			if(B.get(i) < min) {
				min = B.get(i);
				S.add(B.get(i));
				S1.add(i);
			}
		}
		int count = A/min;
		int extra = A%min;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<S.size() && A >= min; i++) {
			if(S.get(i) <= min + extra){
				extra -= S.get(i) - min;
				ans.add(S1.get(i));
				A -= S.get(i);
				i--;
			}
		}
		while (ans.size() < count) {
			ans.add(S1.get(S1.size()-1));
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int N = in.nextInt();
		ArrayList<Integer> B = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			B.add(in.nextInt());
		}
		System.out.println(sol.solve(A, B));
	}
}
