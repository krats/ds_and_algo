import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FoxAndSightseeing {
	
	public int getMin(int[] position) {
		int N = position.length;
		int savings = 0;
		int sum = 0;
		for(int i=1; i<N-1; i++)
		{
			int current = Math.abs(position[i-1]-position[i]) + Math.abs(position[i+1]-position[i]) - Math.abs(position[i-1]-position[i+1]);
			if(savings < current)
				savings = current;
			sum += Math.abs(position[i-1]-position[i]);
		}
		sum += Math.abs(position[N-1]-position[N-2]);
		return sum-savings;
	}
}
