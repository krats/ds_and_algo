package interviewbit.Strings.MultiplyStrings;

/**
 * Created by karthikb on 01-07-2017.
 */
public class Solution {
	public String multiply(String a, String b) {
		a = a.trim();
		b = b.trim();
		int i=0;
		while(a.length() > i && a.charAt(i) == '0')
			i++;
		if(i > 0)
			a = a.substring(i, a.length());
		i=0;
		while(b.length() > i && b.charAt(i) == '0')
			i++;
		if(i > 0)
			b = b.substring(i, b.length());
		int sign = 1;
		if(a.length() > 0 && a.charAt(0) == '+')
			a = a.substring(1,a.length());
		else if(a.length() > 0 && a.charAt(0) == '-')
		{
			a = a.substring(1,a.length());
			sign *= -1;
		}
		if(b.length() > 0 && b.charAt(0) == '+')
			b = b.substring(1,b.length());
		else if(b.length() > 0 && b.charAt(0) == '-')
		{
			a = a.substring(1,a.length());
			sign *= -1;
		}
		if(a.length() == 0 || b.length() == 0)
			return "0";
		StringBuilder ans = new StringBuilder();
		for(i=0; i<a.length(); i++)
		{
			StringBuilder current = new StringBuilder();
			int ac = a.charAt(i)-'0';
			int carry = 0;
			for(int j=b.length()-1; j >= 0; j--)
			{
				int bc = b.charAt(j)-'0';
				current.append(Integer.toString((ac*bc+carry)%10));
				carry = (ac*bc+carry)/10;
			}
			if(carry > 0)
			{
				current.append(Integer.toString(carry));
			}
			ans.append('0');
			ans = add(ans, current.reverse());
		}
		return ans.toString();
	}
	
	public StringBuilder add(StringBuilder a, StringBuilder b)
	{
		StringBuilder ans = new StringBuilder();
		int n = a.length()-1;
		int m = b.length()-1;
		int carry = 0;
		while(n >= 0 && m >= 0)
		{
			int aa = a.charAt(n)-'0';
			int bb = b.charAt(m)-'0';
			int current = aa+bb+carry;
			ans.append(current%10);
			carry = current/10;
			n--;
			m--;
		}
		while(n >= 0)
		{
			int aa = a.charAt(n)-'0';
			int current = aa+carry;
			ans.append(current%10);
			carry = current/10;
			n--;
		}
		while(m >= 0)
		{
			int bb = b.charAt(m)-'0';
			int current = bb+carry;
			ans.append(current%10);
			carry = current/10;
			m--;
		}
		if(carry != 0)
		{
			ans.append(carry);
		}
		return ans.reverse();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.multiply("0", "1212123123"));
	}
}
