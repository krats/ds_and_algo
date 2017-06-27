package interviewbit.arrays.MergeIntervals;

/**
 * Created by karthikb on 26-06-2017.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int start, end;
		int startIndex, endIndex;
		int i;
		
		start = newInterval.start;
		end = newInterval.end;
		i = 0;
		
		startIndex = endIndex = -1;
		
		for (Interval in : intervals) {
			
			if (start >= in.start && start <= in.end)
				startIndex = i;
			
			if (end >= in.start && end <= in.end)
				endIndex = i;
			
			i++;
		}
		
		if (startIndex == -1 && endIndex == -1) {
			
			startIndex = 0;
			
			for (i = 0; i < intervals.size(); i++) {
				if (start > intervals.get(i).end) {
					startIndex = i + 1;
				}
			}
			
			endIndex = intervals.size() - 1;
			
			for (i = intervals.size() - 1; i >= 0 ; i--) {
				if (end < intervals.get(i).start) {
					endIndex = i - 1;
				}
			}
			
			for (i = startIndex; i <= endIndex; i++) {
				intervals.remove(startIndex);
			}
			
			intervals.add(startIndex, newInterval);
			
			return intervals;
		}
		
		if (startIndex == -1) {
			for (i = intervals.size() - 1; i >= 0 ; i--) {
				if (start <= intervals.get(i).start)
					startIndex = i;
			}
		}
		
		if (endIndex == -1) {
			for (i = 0; i < intervals.size(); i++) {
				if (end >= intervals.get(i).end)
					endIndex = i;
			}
		}
		
		start = Math.min(intervals.get(startIndex).start, start);
		end = Math.max(intervals.get(endIndex).end, end);
		
		intervals.get(startIndex).start = start;
		intervals.get(startIndex).end = end;
		
		for (i = startIndex + 1; i <= endIndex; i++) {
			intervals.remove(startIndex + 1);
		}
		
		return intervals;
		
	}
	
	public static void main(String[] args)
	{
		ArrayList<Interval> intervals = new ArrayList<>(100);
		intervals.add(new Interval(6037774, 6198243));
		intervals.add(new Interval(6726550, 7004541));
		intervals.add(new Interval(8842554, 10866536));
		intervals.add(new Interval(11027721, 11341296));
		intervals.add(new Interval(11972532, 14746848));
		intervals.add(new Interval(16374805, 16706396));
		intervals.add(new Interval(17557262, 20518214));
		intervals.add(new Interval(22139780, 22379559));
		intervals.add(new Interval(27212352, 28404611));
		intervals.add(new Interval(28921768, 29621583));
		intervals.add(new Interval(29823256, 32060921));
		intervals.add(new Interval(33950165, 36418956));
		intervals.add(new Interval(37225039, 37785557));
		intervals.add(new Interval(40087908, 41184444));
		intervals.add(new Interval(41922814, 45297414));
		intervals.add(new Interval(48142402, 48244133));
		intervals.add(new Interval(48622983, 50443163));
		intervals.add(new Interval(50898369, 55612831));
		intervals.add(new Interval(57030757, 58120901));
		intervals.add(new Interval(59772759, 59943999));
		intervals.add(new Interval(61141939, 64859907));
		intervals.add(new Interval(65277782, 65296274));
		intervals.add(new Interval(67497842, 68386607));
		intervals.add(new Interval(70414085, 73339545));
		intervals.add(new Interval(73896106, 75605861));
		intervals.add(new Interval(79672668, 84539434));
		intervals.add(new Interval(84821550, 86558001));
		intervals.add(new Interval(91116470, 92198054));
		intervals.add(new Interval(96147808, 98979097));
		Solution sol = new Solution();
		System.out.println(sol.insert(intervals, new Interval(36210193, 61984219)));
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
