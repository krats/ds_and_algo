import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SRMCards {
	
	public int maxTurns(int[] cards) {
		Arrays.sort(cards);
		int N = cards.length;
		int weights[] = new int[N];
		int ans = 0;
		boolean isRemoved[] = new boolean[N];
		for(int i=0; i<N; i++)
		{
			int test = 1;
			if(i-1>=0 && cards[i-1] == cards[i]-1)
			{
				test += 1;
			}
			if(i+1<N && cards[i+1] == cards[i]+1)
			{
				test += 1;
			}
			weights[i] = test;
		}
		for(int k=1; k<=3; k++)
		{
			for(int i=0; i<N; i++)
			{
				if(weights[i] == k && !isRemoved[i])
				{
					isRemoved[i] = true;
					if(k >= 2)
					{
						if(i-1>=0 && cards[i-1] == cards[i]-1 && !isRemoved[i-1])
						{
							isRemoved[i-1] = true;
						}
						if(i+1<N && cards[i+1] == cards[i]+1 && !isRemoved[i+1])
						{
							isRemoved[i+1] = true;
						}
					}
					ans += 1;
				}
			}
		}
		return ans;
	}
}
