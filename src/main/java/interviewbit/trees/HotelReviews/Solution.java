package interviewbit.trees.HotelReviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		ArrayList<Pair> ansPairs = new ArrayList<>(B.size());
		String[] words = A.split("_");
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<words.length; i++) {
			set.add(words[i]);
		}
		for(int i=0; i<B.size(); i++)
		{
			int c = 0;
			words = B.get(i).split("_");
			for(int j=0; j<words.length; j++) {
				if(set.contains(words[j]))
					c++;
			}
			ansPairs.add(new Pair(c,i));
		}
		Collections.sort(ansPairs);
		ArrayList<Integer> ans = new ArrayList<>(B.size());
		for(int i=0; i<ansPairs.size(); i++)
			ans.add(ansPairs.get(i).index);
		return ans;
	}
	
	class Pair implements Comparable<Pair> {
		int val;
		int index;
		public Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		public int compareTo(Pair b)
		{
			return b.val - this.val;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		String A = in.nextLine();
		String BC = in.nextLine();
		String[] words = BC.split("\\s+");
		ArrayList<String> B = new ArrayList<>(words.length-1);
		for(int i=1; i<words.length; i++) {
			B.add(words[i]);
		}
		System.out.println(sol.solve(A, B));
	}
}
