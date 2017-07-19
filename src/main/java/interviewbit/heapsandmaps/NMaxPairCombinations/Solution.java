package interviewbit.heapsandmaps.NMaxPairCombinations;

import java.util.*;

/**
 * Created by karthikb on 17-07-2017.
 */
public class Solution {
	class Pair {
		int L;
		int R;
		int val;
		public Pair(int L, int R) {
			this.L = L;
			this.R = R;
			this.val = 1;
		}
	}
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		Collections.sort(A);
		Collections.sort(B);
		int N = A.size();
		ArrayList<Pair> c = new ArrayList<>();
		c.add(new Pair(N-1, N-1));
		map.put(A.get(N-1)+B.get(N-1), c);
		int count = 0;
		HashSet<Long> visited = new HashSet<>(N);
		while (count < N) {
			int key = map.lastKey();
			ans.add(key);
			Pair p = map.get(key).get(0);
			map.get(key).remove(0);
			if(map.get(key).size() == 0)
				map.remove(key);
			int L = p.L;
			int R = p.R;
			count++;
			long k = L-1;
			k = k << 32;
			k += R;
			if(L > 0 && !visited.contains(k)){
				int k1 = A.get(L - 1) + B.get(R);
				if (map.containsKey(k1)) {
					map.get(k1).add(new Pair(L - 1, R));
				} else {
					c = new ArrayList<>();
					c.add(new Pair(L - 1, R));
					map.put(k1, c);
				}
				visited.add(k);
			}
			k = L;
			k = k << 32;
			k += R-1;
			if(R > 0 && !visited.contains(k)) {
				int k2 = A.get(L)+B.get(R-1);
				if (map.containsKey(k2)) {
					map.get(k2).add(new Pair(L, R-1));
				} else {
					c = new ArrayList<>();
					c.add(new Pair(L, R-1));
					map.put(k2, c);
				}
				visited.add(k);
			}
		}
		return ans;
	}
}
