import java.util.*;
import java.math.*;
import static java.lang.Math.*;

class Tuple {
	public int index, weight;
	public Tuple(int index, int weight)
	{
		this.index = index;
		this.weight = weight;
	}
}

public class ArcadeManao {
	
	public int shortestLadder(String[] level, int coinRow, int coinColumn) {
		int N = level.length;
		int M = level[0].length();
		ArrayList<Tuple>[] graph = new ArrayList[N*M];
		for(int i=0; i<N*M; i++)
			graph[i] = new ArrayList<>(2);
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(level[i].charAt(j) == 'X')
				{
					int l = j-1;
					while (l>=0 && level[i].charAt(l) == 'X')
					{
						graph[i*M+j].add(new Tuple(i*M + l, 0));
						l--;
					}
					l = j+1;
					while (l<M && level[i].charAt(l) == 'X')
					{
						graph[i*M+j].add(new Tuple(i*M + l, 0));
						l++;
					}
					int k = i-1;
					while(k >= 0)
					{
						if(level[k].charAt(j) == 'X')
						{
							graph[i*M+j].add(new Tuple(k*M + j, i-k));
							break;
						}
						k--;
					}
					k = i+1;
					while(k < N)
					{
						if(level[k].charAt(j) == 'X')
						{
							graph[i*M+j].add(new Tuple(k*M+j, k-i));
							break;
						}
						k++;
					}
				}
			}
		}
		
		int src = (coinRow-1)*M + coinColumn-1;
		
		int[] dist = djkistra(graph, src);
		int ans = Integer.MAX_VALUE;
		for(int i = N*M-1; i>(N-1)*M-1; i--)
		{
			if(ans > dist[i])
				ans = dist[i];
		}
		return ans;
	}
	
	int[] djkistra(ArrayList<Tuple>[] graph, int src)
	{
		int[] dist = new int[graph.length];
		for(int i=0; i<dist.length; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		boolean[] visited = new boolean[graph.length];
		for(int i=0; i<graph.length; i++)
		{
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=0; j<dist.length; j++)
			{
				if(!visited[j] && dist[j] < min)
				{
					min = dist[j];
					current = j;
				}
			}
			if(current == -1)
				break;
			visited[current] = true;
			for(int j=0; j<graph[current].size(); j++)
			{
				if(!visited[graph[current].get(j).index])
					dist[graph[current].get(j).index] = min(dist[graph[current].get(j).index], max(dist[current], graph[current].get(j).weight));
			}
		}
		return dist;
	}
}
