import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CuttingBitString {
	
	public int getmin(String S) {
		int N = S.length();
		int dp[][] = new int[N][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				dp[i][j] = Integer.MAX_VALUE;
			}
			if(S.charAt(i) == '1')
				dp[i][i] = 1;
		}
		for(int len = 2; len <=N; len++)
		{
			for(int i=0; i<N-len+1; i++)
			{
				int j = i+len-1;
				String sub = S.substring(i,j+1);
				if(sub.charAt(0)!= '0' && isPowerOf5(new BigInteger(sub,2)))
					dp[i][j] = 1;
				else
					for(int k=i; k<j; k++)
					{
						if(dp[i][k] != Integer.MAX_VALUE && dp[k+1][j] != Integer.MAX_VALUE)
							dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
					}
			}
		}
		return dp[0][N-1] == Integer.MAX_VALUE ? -1 : dp[0][N-1];
	}
	
	boolean isPowerOf5(BigInteger k)
	{
		if(k.intValue() == 0)
			return false;
		BigInteger why = new BigInteger("5");
		while(k.mod(why).intValue() == 0)
			k = k.divide(why);
		return k.intValue() == 1;
	}
}
