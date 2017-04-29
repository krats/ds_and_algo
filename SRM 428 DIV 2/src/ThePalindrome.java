import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ThePalindrome {
	
	public int find(String s) {
		int N = s.length();
		if(N==0 || N==1)
		{
			return N;
		}
		boolean isPalindrome[][] = new boolean[N][N];
		for(int len=1; len<=N; len++)
		{
			for(int i=0; i<N-len+1; i++)
			{
				int j = i+len-1;
				if(i==j)
				{
					isPalindrome[i][j] = true;
				}
				else
				{
					if(s.charAt(i) == s.charAt(j))
					{
						if(i+1 <= j-1)
						{
							isPalindrome[i][j] = isPalindrome[i+1][j-1];
						}
						else
						{
							isPalindrome[i][j] = true;
						}
					}
				}
			}
		}
		char last = s.charAt(N-1);
		for(int i=0; i+1<N; i++)
		{
			if(s.charAt(i) == last)
			{
				if(isPalindrome[i+1][N-2])
				{
					return N+i;
				}
			}
		}
		return 2*N-1;
	}
}
