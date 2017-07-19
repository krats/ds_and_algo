package interviewbit.heapsandmaps.WaysToFormMaxHeap;

/**
 * Created by karthikb on 18-07-2017.
 */
public class Solution {
	int MOD = 1000000007;
	public int solve(int A) {
		long[] ans = new long[101];
		ans[1] = 1;
		ans[0] = 1;
		for(int i=2; i<=A; i++)
		{
			int levels = binlog(i);
			int maxNumOfLeafs = (int) Math.pow(2, levels);
			int actualLeafs = i - (maxNumOfLeafs-1);
			int left = actualLeafs >= maxNumOfLeafs/2 ? maxNumOfLeafs-1: maxNumOfLeafs-1-(maxNumOfLeafs/2 - actualLeafs);
			ans[i] = (ncr(i-1, left)*ans[left])%MOD;
			ans[i] = (ans[i]*ans[i-1-left])%MOD;
		}
		return (int) ans[A];
	}
	
	public static int binlog( int bits ) // returns 0 for bits=0
	{
		int log = 0;
		if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
		if( bits >= 256 ) { bits >>>= 8; log += 8; }
		if( bits >= 16  ) { bits >>>= 4; log += 4; }
		if( bits >= 4   ) { bits >>>= 2; log += 2; }
		return log + ( bits >>> 1 );
	}
	
	long ncr(int m, int k)
	{
		if(k == 0) return 1;
		if(m == k) return 1;
		long num = 1;
		for(int i=m-k+1; i<=m; i++)
		{
			num = (num * i)%MOD;
		}
		long den = 1;
		for(int i=1; i<=k; i++)
		{
			den= (den*i)%MOD;
		}
		long ans = (num*inverse(den))%MOD;
		return ans;
	}
	
	long inverse(long num)
	{
		int pow = MOD-2;
		long ans = 1;
		long base = num;
		while(pow > 0)
		{
			if(pow == 1)
				return (ans*base)%MOD;
			if(pow % 2 == 0)
			{
				base = (base*base)%MOD;
				pow/=2;
			}
			else
			{
				ans = (base*ans)%MOD;
				pow--;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solve(10));
	}
}
