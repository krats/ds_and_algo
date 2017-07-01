package interviewbit.Strings.PowerOfTwo;

/**
 * Created by karthikb on 01-07-2017.
 */
public class Solution {
	public int power(String aa) {
		aa = aa.trim();
		while(aa.length() > 0 && aa.charAt(0) == '0')
		{
			aa = aa.substring(1,aa.length());
		}
		if(aa.equals("") || aa.equals("1"))
		{
			return 0;
		}
		char[][] a = new char[2][aa.length()];
		for(int i=0; i<aa.length(); i++)
		{
			a[0][i] = aa.charAt(i);
		}
		int n = aa.length();
		int index = 0;
		boolean num_gt_1 = true;
		boolean isPower = true;
		String numbers = "0123456789";
		if((a[index][n-1] - '0')%2 == 1)
		{
			return 0;
		}
		while(num_gt_1)
		{
			index ^= 1;
			int i=0;
			int remainder = 0;
			int m = 0;
			while( i < n)
			{
				int current = remainder*10 + (a[index^1][i] - '0');
				while(current < 2 && i<n-1)
				{
					i++;
					current = current*10 + (a[index^1][i] - '0');
					if(m != 0) {
						a[index][m] = '0';
						m++;
					}
				}
				a[index][m] = numbers.charAt(current / 2);
				m++;
				remainder = current % 2;
				i++;
			}
			if(m == 1 && a[index][0] == '1')
			{
				num_gt_1 = false;
			}
			else if((a[index][m-1] - '0')%2 == 1)
			{
				return 0;
			}
			n = m;
		}
		return 1;
	}
	 public static void main(String[] args)
	 {
	 	Solution sol = new Solution();
	 	System.out.println(sol.power("147573952589676412928"));
	 }
}

