import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NumbersChallenge {
	
	public int MinNumber(int[] S) {
		Arrays.sort(S);
		int N = S.length;
		int sum = 0;
		for(int i=0; i<N; i++)
		{
			sum += S[i];
		}
		boolean dp[][] = new boolean[N+1][sum+2];
		for(int i=0; i<=N; i++)
		{
			dp[i][0] = true;
		}
		for(int i=1; i<=sum+1; i++)
		{
			for(int j=1; j<=N; j++)
			{
				dp[j][i] = dp[j][i] || dp[j-1][i];
				if(S[j-1] <= i)
					dp[j][i] = dp[j][i] || dp[j-1][i-S[j-1]];
			}
			if(!dp[N][i])
				return i;
		}
		return 1;
	}
}
