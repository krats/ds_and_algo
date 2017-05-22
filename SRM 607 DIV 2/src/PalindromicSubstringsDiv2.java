import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PalindromicSubstringsDiv2 {
	
	public int count(String[] S1, String[] S2) {
		char[] A= new char[5000];
		int count = 0;
		for(int i=0; i<S1.length; i++)
		{
			for(int j=0; j<S1[i].length(); j++)
			{
				A[count] = S1[i].charAt(j);
				count += 1;
			}
		}
		for(int i=0; i<S2.length; i++)
		{
			for(int j=0; j<S2[i].length(); j++)
			{
				A[count] = S2[i].charAt(j);
				count += 1;
			}
		}
		boolean dp[][] = new boolean[count][count];
		int ans = 0;
		for(int i=0; i<count; i++)
		{
			dp[i][i] = true;
			ans += 1;
		}
		for(int len=2; len<=count; len++)
		{
			for(int i=0; i<=count-len; i++)
			{
				int j = i+len-1;
				if(i+1 < j-1)
					dp[i][j] = (A[i] == A[j] && dp[i+1][j-1]);
				else
					dp[i][j] = (A[i] == A[j]);
				if(dp[i][j])
					ans += 1;
			}
		}
		return ans;
	}
}
