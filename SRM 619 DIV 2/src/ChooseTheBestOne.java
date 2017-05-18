import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ChooseTheBestOne {
	
	public int countNumber(int N) {
		boolean isEliminated[] = new boolean[N+1];
		int current = 0;
		for(long t=1; t<N; t++)
		{
			long moves = (t*t*t)-1;
			moves = moves%(N-t+1);
			moves += 1;
			long count = 0;
			while(count != moves)
			{
				current += 1;
				if(current == N+1)
				{
					current = 1;
				}
				if(!isEliminated[current])
				{
					count += 1;
				}
			}
			isEliminated[current] = true;
		}
		for(int i=1; i<=N; i++)
		{
			if(!isEliminated[i])
				return i;
		}
		return 0;
	}
}
