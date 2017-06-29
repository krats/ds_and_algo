package interviewbit.binarysearch.Power;

/**
 * Created by karthikb on 29-06-2017.
 */
public class Solution {
	public int pow(int x, int n, int d) {
		if(x == 0)
			return 0;
		if(n == 0)
			return 1;
		if(n == 1)
		{
			while(x < 0)
				x+=d;
			return x;
		}
		long ans=0;
		int aa = n;
		long j = x%d;
		while(aa > 0)
		{
			if(aa%2 != 0)
				ans = (ans + j)%d;
			j = ((j%d)*(j%d))%d;
			j = j%d;
			aa/=2;
		}
		while(ans < 0)
			ans += d;
		return (int) ans;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		System.out.println(sol.pow(71045970, 41535484, 64735492));
	}
}
