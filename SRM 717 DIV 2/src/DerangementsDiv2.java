import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DerangementsDiv2 {
	
	int MOD = 1000000007;
	public int count(int n, int m)
	{
		long ans = 0;
		long current1 = 1;
		long current2 = fact(n);
		for(int i=0; i<=m; i++)
		{
			current1 = mck(m,m-i);
			if((m-i)%2 == 0)
			{
				ans = (ans+((current1*current2)%MOD))%MOD;
			}
			else
			{
				ans = (ans-((current1*current2)%MOD))%MOD;
			}
			current2 = (current2*(n+i+1))%MOD;
		}
		if(ans < 0)
			ans += MOD;
		return (int) ans%MOD;
	}
	
	long mck(int m, int k)
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
		return (num*inverse(den))%MOD;
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
	
	long fact(long k)
	{
		if(k == 0)
			return 1;
		long ans = 1;
		while(k > 0)
		{
			ans = (ans*k)%MOD;
			k--;
		}
		return ans;
	}
}
