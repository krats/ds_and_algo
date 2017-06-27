import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class JumpDistancesOnTreeEasy {
	
	public String isPossible(int[] p, int[] S) {
		int[][] graph = new int[p.length+1][p.length+1];
		for(int i=0; i<p.length; i++)
		{
			graph[i+1][p[i]] = 1;
			graph[p[i]][i+1] = 1;
		}
		graph = floydWarsharl(graph);
		int maximum = 0;
		int N = graph.length;
		for(int i=0; i<N; i++) {
			for (int j = 0; j < N; j++) {
				maximum = Math.max(graph[i][j], maximum);
			}
		}
		if(S[S.length-1] > maximum)
			return "Impossible";
		HashMap<Integer, Boolean> set = new HashMap<>(S.length);
		for(int i=0; i<S.length; i++)
		{
			set.put(S[i], false);
		}
		Deque<Integer> que = new ArrayDeque<>(N);
		boolean visited[] = new boolean[N];
		que.add(0);
		int count = 0;
		while(que.size() > 0 && count < S.length)
		{
			int current = que.pop();
			visited[current] = true;
			for(int i=0; i<N; i++)
			{
				if(set.containsKey(graph[current][i]) && !visited[i])
				{
					que.add(i);
					if(!set.get(graph[current][i]))
					{
						set.put(graph[current][i], true);
						count+=1;
					}
				}
			}
		}
		return count == S.length? "Possible": "Impossible";
	}
	
	int[][] floydWarsharl(int[][] graph)
	{
		int N = graph.length;
		int[][][] w = new int[2][N][N];
		int index = 0;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				w[index][i][j] = graph[i][j] == 1 ? 1 : Integer.MAX_VALUE;
				w[index^1][i][j] = graph[i][j] == 1 ? 1 : Integer.MAX_VALUE;
			}
			w[index][i][i] = 0;
			w[index^1][i][i] = 0;
		}
		for(int k=0; k<N; k++)
		{
			index^= 1;
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(w[index^1][i][k] != Integer.MAX_VALUE && w[index^1][k][j] != Integer.MAX_VALUE)
					{
						w[index][i][j] = Math.min(w[index^1][i][j], w[index^1][i][k]+w[index^1][k][j]);
					}
				}
			}
		}
		return w[index];
	}
}
