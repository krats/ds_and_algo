package interviewbit.Strings.ATOI;

/**
 * Created by karthikb on 30-06-2017.
 */
public class Solution {
	public int atoi(final String a) {
		long ans = 0;
		boolean isNegative = false;
		int i=0;
		while(i < a.length() && a.charAt(i) == ' ')
			i++;
		if(i < a.length() && a.charAt(i) == '-')
		{
			i++;
			isNegative = true;
		}
		else if(i < a.length() && a.charAt(i) == '+')
		{
			i++;
		}
		for(;i<a.length(); i++)
		{
			if(Character.isDigit(a.charAt(i)))
			{
				ans = ans*10 + (a.charAt(i) - '0');
			}
			else
			{
				if(isNegative)
					return (-1*((int) ans));
				return (int) ans;
			}
			if(ans >= Integer.MAX_VALUE)
			{
				if(isNegative)
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
		}
		if(isNegative)
			return (-1*((int) ans));
		return (int) ans;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		System.out.println(sol.atoi("-123123123"));
	}
}
