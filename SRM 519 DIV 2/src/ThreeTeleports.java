import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ThreeTeleports {
	
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
		int[] xpoints = new int[8];
		int[] ypoints = new int[8];
		xpoints[0] = xMe;
		ypoints[0] = yMe;
		xpoints[1] = xHome;
		ypoints[1] = yHome;
		int idx = 2;
		for(int i=0; i<teleports.length; i++)
		{
			String[] components = teleports[i].split("\\s+");
			xpoints[idx] = Integer.parseInt(components[0]);
			ypoints[idx] = Integer.parseInt(components[1]);
			xpoints[idx+1] = Integer.parseInt(components[2]);
			ypoints[idx+1] = Integer.parseInt(components[3]);
			idx += 2;
		}
		int[][] graph = new int[xpoints.length][ypoints.length];
		for(int i=0; i<xpoints.length; i++)
		{
			for(int j=i; j<ypoints.length; j++)
			{
				graph[i][j] = abs(xpoints[i]-xpoints[j]) + abs(ypoints[i]-ypoints[j]);
				graph[j][i] = graph[i][j];
			}
		}
		graph[2][3] = min(10, graph[2][3]);
		graph[3][2] = graph[2][3];
		graph[4][5] = min(10, graph[4][5]);
		graph[5][4] = graph[4][5];
		graph[6][7] = min(10, graph[6][7]);
		graph[7][6] = graph[6][7];
		return (int) djkistra(graph, 0)[1];
	}
	
	long[][] floydWarshall(int[][] graph)
	{
		long[][][] dist = new long[2][graph.length][graph.length];
		int current = 0;
		for(int i=0; i<graph.length; i++)
		{
			for(int j=0; j<graph.length; j++)
			{
				dist[current][i][j] = graph[i][j];
			}
		}
		for(int k=0; k<graph.length; k++)
		{
			current = current^1;
			for(int i=0; i<graph.length; i++)
			{
				for(int j=0; j<graph.length; j++)
				{
					dist[current][i][j] = min(dist[current^1][i][j], dist[current^1][i][k] + dist[current^1][k][j]);
				}
			}
		}
		return dist[current];
	}
	
	long[] djkistra(int[][] graph, int src)
	{
		long[] dist = new long[graph.length];
		for(int i=0; i<dist.length; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		boolean[] visited = new boolean[dist.length];
		for(int i=0; i<dist.length; i++)
		{
			long min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=0; j<dist.length; j++)
			{
				if(!visited[j] && dist[j] < min)
				{
					min = dist[j];
					current = j;
				}
			}
			visited[current] = true;
			for(int j=0; j<dist.length; j++)
			{
				if(!visited[j])
					dist[j] = min(dist[j], dist[current] + graph[current][j]);
			}
		}
		return dist;
	}
}
