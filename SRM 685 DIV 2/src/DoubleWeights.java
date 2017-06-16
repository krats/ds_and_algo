import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DoubleWeights {
	
	public int minimalCost(String[] weight1, String[] weight2) {
		int[] ans = djkistra(weight1, weight2, 0);
		return ans[1] == 9999*9999? -1 : ans[1];
	}
	
	int[] djkistra(String[] weights1, String[] weights2, int src)
	{
		int N = weights1.length;
		int[] ans1 = new int[N];
		int[] ans2 = new int[N];
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++)
		{
			ans1[i] = 9999;
			ans2[i] = 9999;
		}
		ans1[src] = 0;
		ans2[src] = 0;
		for(int i=0; i<N; i++)
		{
			int current = -1;
			int current_min = 9999*9999;
			for(int j=0; j<N; j++)
			{
				if(current_min > ans1[j]*ans2[j] && !visited[j]) {
					current_min = ans1[j]*ans2[j];
					current = j;
				}
			}
			if(current == -1)
				break;
			visited[current] = true;
			for(int j=0; j<N; j++)
			{
				if(weights1[current].charAt(j) != '.' && !visited[j])
				{
					int a = weights1[current].charAt(j) - '0';
					int b = weights2[current].charAt(j) - '0';
					if(ans1[j]*ans2[j] > (ans1[current]+a)*(ans2[current]+b))
					{
						ans1[j] = ans1[current]+a;
						ans2[j] = ans2[current]+b;
					}
				}
			}
			if(current == 1)
				break;
		}
		for(int i=0; i<N; i++)
		{
			ans1[i] = ans1[i]*ans2[i];
		}
		return ans1;
	}
}
