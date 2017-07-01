package interviewbit.Strings.AddBinaryStrings;

/**
 * Created by karthikb on 01-07-2017.
 */
public class Solution {
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		int count = 0;
		while(i >= 0 && j >= 0)
		{
			count = 0;
			if(a.charAt(i) == '1')
				count++;
			if(b.charAt(j) == '1')
				count++;
			if(carry == 1)
				count++;
			if(count == 0)
			{
				ans.append('0');
			}
			else if(count == 1)
			{
				carry = 0;
				ans.append('1');
			}
			else if(count == 2)
			{
				carry = 1;
				ans.append('0');
			}
			else
			{
				carry = 1;
				ans.append('1');
			}
			i--;
			j--;
		}
		while(i >= 0)
		{
			count = 0;
			if(a.charAt(i) == '1')
				count++;
			if(carry == 1)
				count++;
			if(count == 0)
				ans.append('0');
			else if(count == 1)
			{
				carry = 0;
				ans.append('1');
			}
			else if(count == 2)
			{
				carry = 1;
				ans.append('0');
			}
			i--;
		}
		while(j >= 0)
		{
			count = 0;
			if(b.charAt(j) == '1')
				count++;
			if(carry == 1)
				count++;
			if(count == 0)
				ans.append('0');
			else if(count == 1)
			{
				carry = 0;
				ans.append('1');
			}
			else if(count == 2)
			{
				carry = 1;
				ans.append('0');
			}
			j--;
		}
		if(carry == 1)
			ans.append('1');
		return ans.reverse().toString();
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		System.out.println(sol.addBinary("1010110111001101101000", "1000011011000000111100110"));
	}
}

