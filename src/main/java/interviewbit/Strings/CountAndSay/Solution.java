package interviewbit.Strings.CountAndSay;

/**
 * Created by karthikb on 29-06-2017.
 */
public class Solution {
	public String countAndSay(int a) {
		String ans = "1";
		if(a == 1)
			return ans;
		for(int i=2; i<=a; i++)
		{
			String current = "";
			int count;
			int n = ans.length();
			int j = 0;
			while(j<n)
			{
				count = 1;
				j++;
				while(j < n)
				{
					if(ans.charAt(j) != ans.charAt(j-1))
						break;
					count++;
					j++;
				}
				current += Integer.toString(count) +Character.toString(ans.charAt(j-1));
			}
			ans = current;
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		Solution sol = new Solution();
		System.out.println(sol.countAndSay(4));
	}
}

