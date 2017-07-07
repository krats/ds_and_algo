package interviewbit.StackAndQueue.RainWaterTrapped;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by karthikb on 07-07-2017.
 */
public class Solution {
	
	public int trap(final List<Integer> a) {
		int before[] = new int[a.size()];
		int current = 0;
		for(int i=0; i<a.size(); i++)
		{
			before[i] = current;
			current = Math.max(current, a.get(i));
		}
		current = 0;
		for(int i=a.size()-1; i>=0; i--)
		{
			before[i] = Math.min(before[i], current);
			current = Math.max(current, a.get(i));
		}
		int ans = 0;
		for(int i=0; i<a.size(); i++)
		{
			if(a.get(i) < before[i])
				ans += before[i]-a.get(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> arr = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			arr.add(in.nextInt());
		}
		System.out.println(sol.trap(arr));
	}
}
