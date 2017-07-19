package interviewbit.hashing.Fraction;

import java.util.HashMap;

/**
 * Created by karthikb on 15-07-2017.
 */
public class Solution {
	public String fractionToDecimal(int n, int d) {
		long numerator = n;
		long denominator = d;
		int sign = 1;
		if(numerator < 0) {
			sign*= -1;
			numerator *= -1;
		}
		if(denominator < 0) {
			sign *= -1;
			denominator *= -1;
		}
		StringBuilder ans = new StringBuilder();
		if(sign < 0 && numerator != 0)
			ans.append('-');
		ans.append(Long.toString(numerator/denominator));
		numerator %= denominator;
		HashMap<String, Integer> map = new HashMap<>();
		if(numerator != 0)
		{
			ans.append('.');
		}
		int current = ans.length();
		numerator *= 10;
		while (numerator!= 0 && numerator < denominator) {
			ans.append('0');
			String k = Long.toString(0)+" "+ Long.toString(numerator);
			numerator *= 10;
			map.put(k,current);
			current++;
		}
		while (numerator != 0) {
			long fraction = (numerator)/denominator;
			numerator = (numerator)%denominator;
			String k = Long.toString(fraction)+" "+ Long.toString(numerator);
			String c = Long.toString(fraction);
			if(map.containsKey(k)) {
				ans.insert(map.get(k), "(");
				ans.append(')');
				break;
			}
			else {
				ans.append(c);
				map.put(k,current);
			}
			current++;
			numerator*=10;
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.fractionToDecimal(857, 413));
	}
}
