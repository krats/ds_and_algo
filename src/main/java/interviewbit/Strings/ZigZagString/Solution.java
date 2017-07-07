package interviewbit.Strings.ZigZagString;

/**
 * Created by karthikb on 02-07-2017.
 */
public class Solution {
	public String convert(String a, int b) {
		if(b == 1)
			return a;
		StringBuilder ans = new StringBuilder();
		int linesBelow, linesAbove;
		for(int i=0; i<b; i++)
		{
			linesBelow = b - i - 1;
			linesAbove = b - linesBelow - 1;
			int increment1 = 2*linesBelow;
			int	increment2 = 2*linesAbove;
			int j = i;
			boolean zig = true;
			if(increment1 == 0)
			{
				while(j<a.length()) {
					ans.append(a.charAt(j));
					j += increment2;
				}
			}
			else if(increment2 == 0)
			{
				while(j<a.length()) {
					ans.append(a.charAt(j));
					j += increment1;
				}
			}
			else
			{
				while(j<a.length())
				{
					ans.append(a.charAt(j));
					if(zig)
					{
						zig = false;
						j += increment1;
					}
					else
					{
						zig = true;
						j += increment2;
					}
				}
			}
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.convert("ABCDEFGHIJKLMNOPQRS", 6));
	}
}