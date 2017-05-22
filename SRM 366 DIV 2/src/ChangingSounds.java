import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ChangingSounds {
	HashMap<Integer, Integer> dp;
	public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel) {
		dp = new HashMap<Integer, Integer>(changeIntervals.length);
		return solve(changeIntervals, 0, beginLevel, maxLevel);
	}
	
	public int solve(int[] changeIntervals, int index, int beginLevel, int maxLevel) {
		if(dp.get(index + beginLevel*1024) != null)
			return dp.get(index + beginLevel*1024);
		if(index == changeIntervals.length)
			return beginLevel;
		int ans = -1;
		if(maxLevel >= beginLevel + changeIntervals[index]) {
			int level1 = solve(changeIntervals, index+1, beginLevel+changeIntervals[index], maxLevel);
			ans = Math.max(ans, level1);
		}
		if(0 <= beginLevel - changeIntervals[index]) {
			int level2 = solve(changeIntervals, index+1, beginLevel-changeIntervals[index], maxLevel);
			ans = Math.max(ans, level2);
		}
		dp.put(index + beginLevel*1024, ans);
		return ans;
	}
}
