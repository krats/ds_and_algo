package interviewbit.heapsandmaps.DistinctNumbersInWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by karthikb on 18-07-2017.
 */
public class Solution {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		int N = A.size();
		if(B > N)
			return new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>(N - B + 1);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<B; i++) {
			if(map.containsKey(A.get(i))) {
				map.put(A.get(i), map.get(A.get(i))+1);
			}
			else {
				map.put(A.get(i), 1);
			}
		}
		ans.add(map.size());
		for(int i=1; i<N-B+1; i++) {
			if(map.get(A.get(i-1)) == 1) {
				map.remove(A.get(i-1));
			}
			else {
				map.put(A.get(i-1), map.get(A.get(i-1))-1);
			}
			if(!map.containsKey(A.get(i+B-1))) {
				map.put(A.get(i+B-1), 1);
			}
			else {
				map.put(A.get(i+B-1), map.get(A.get(i+B-1))+1);
			}
			ans.add(map.size());
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			a.add(in.nextInt());
		}
		System.out.println(sol.dNums(a, in.nextInt()));
	}
}
