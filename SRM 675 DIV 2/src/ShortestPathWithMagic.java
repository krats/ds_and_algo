import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ShortestPathWithMagic {
	
	public double getTime(String[] dist, int k) {
		int N = dist.length;
		double graph[][] = new double[N*(k+1)][N*(k+1)];
		for (int i = 0; i < N*(k+1); i++) {
			for (int j = 0; j < N*(k+1); j++) {
				graph[i][j] = -1.0;
			}
		}
		for(int t=0; t<=k; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i+N*t][j+N*t] = dist[i].charAt(j) - '0';
					graph[j+N*t][i+N*t] = dist[i].charAt(j) - '0';
					if(t>0) {
						graph[i + N * t][j + N * (t - 1)] = ((double) (dist[i].charAt(j) - '0')) / 2;
						graph[j + N * t][i + N * (t - 1)] = ((double) (dist[i].charAt(j) - '0')) / 2;
					}
				}
			}
		}
		return djkistra(graph, 0, N, k);
	}
	
	double djkistra(double[][] graph, int src, int N, int k)
	{
		double[] dist = new double[N*(k+1)];
		for(int i=0; i<N*(k+1); i++)
		{
			dist[i] = Double.MAX_VALUE;
		}
		for(int t=0; t<=k; t++) {
			dist[src+N*t] = 0;
		}
		boolean[] visited = new boolean[N*(k+1)];
		for(int i=0; i<N*(k+1); i++)
		{
			int current = -1;
			double currentMin = Double.MAX_VALUE;
			for(int j=0; j<N*(k+1); j++)
			{
				if(!visited[j] && currentMin > dist[j])
				{
					current = j;
					currentMin = dist[j];
				}
			}
			if(current == -1)
				break;
			visited[current] = true;
			for (int j = 0; j < N*(k+1); j++) {
				if(!visited[j] && graph[current][j] != -1.0)
				{
					dist[j] = min(dist[j], dist[current]+graph[current][j]);
				}
			}
		}
		double ans = Double.MAX_VALUE;
		for(int t=0; t<=k; t++)
			if(ans > dist[1+N*t])
				ans = dist[1+N*t];
		return dist[1];
	}
}
