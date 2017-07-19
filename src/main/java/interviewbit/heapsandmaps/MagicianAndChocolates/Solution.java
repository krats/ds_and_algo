package interviewbit.heapsandmaps.MagicianAndChocolates;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by karthikb on 17-07-2017.
 */
public class Solution {
	public int nchoc(int A, ArrayList<Integer> B) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i=0; i<B.size(); i++) {
			if(map.containsKey(B.get(i))) {
				map.put(B.get(i), map.get(B.get(i))+1);
			}
			else{
				map.put(B.get(i), 1);
			}
		}
		long ans = 0;
		int MOD = 1000000007;
		while (A > 0) {
			A--;
			int key = map.lastKey();
			ans += key;
			ans = ans%MOD;
			if(map.get(key) == 1) {
				map.remove(key);
			}
			else {
				map.put(key, map.get(key)-1);
			}
			if(map.containsKey(key/2))
			{
				map.put(key/2, map.get(key/2)+1);
			}
			else
			{
				map.put(key/2, 1);
			}
		}
		return (int) ans;
	}
}
