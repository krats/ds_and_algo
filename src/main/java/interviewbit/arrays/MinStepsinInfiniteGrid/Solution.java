package interviewbit.arrays.MinStepsinInfiniteGrid;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;
/**
 * Created by karthikb on 24-06-2017.
 */
public class Solution {
	public int coverPoints(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		int ans = 0;
		for(int i=1; i<a.size(); i++)
		{
			ans += max(abs(a.get(i)-a.get(i-1)), abs(b.get(i)-b.get(i-1)));
		}
		return ans;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>(n);
		ArrayList<Integer> b = new ArrayList<Integer>(n);
		for(int i=0; i<n; i++)
		{
			a.add(in.nextInt());
		}
		n = in.nextInt();
		for(int i=0; i<n; i++)
		{
			b.add(in.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.coverPoints(a,b));
	}
}
