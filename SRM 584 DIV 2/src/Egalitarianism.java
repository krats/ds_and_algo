import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Egalitarianism {
	
	public int maxDifference(String[] isFriend, int d) {
		int N = isFriend.length;
		boolean[][] graph = new boolean[N][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(isFriend[i].charAt(j) == 'Y')
					graph[i][j] = true;
			}
		}
		int count = noOfConnectedComponents(graph);
		if(count != 1)
			return -1;
		int ans = 0;
		for(int i=0; i<N; i++)
		{
			int current = noOfBFSLevels(graph, i);
			if(current > ans)
				ans = current;
		}
		return ans*d;
	}
	
	int noOfBFSLevels(boolean[][] graph, int src)
	{
		int ans = 0;
		int N = graph.length;
		boolean[] visited = new boolean[N];
		Deque<Integer> que = new ArrayDeque<Integer>(N);
		Deque<Integer> queAns = new ArrayDeque<Integer>(N);
		que.add(src);
		queAns.add(0);
		visited[src] = true;
		while(que.size() > 0)
		{
			int current = que.pop();
			ans = queAns.pop();
			for(int i=0; i<N; i++)
			{
				if(graph[current][i] && !visited[i])
				{
					que.add(i);
					queAns.add(ans+1);
					visited[i] = true;
				}
			}
		}
		return ans;
	}
	
	int noOfConnectedComponents(boolean[][] graph)
	{
		int N = graph.length;
		boolean visited[] = new boolean[N];
		int count = 0;
		for(int i=0; i<N; i++)
		{
			if(!visited[i])
			{
				count++;
				Deque<Integer> stack = new ArrayDeque<Integer>(N);
				stack.push(i);
				while(stack.size() != 0)
				{
					int current = stack.pop();
					visited[current] = true;
					for(int j=0; j<N; j++)
					{
						if(graph[current][j] && !visited[j])
							stack.push(j);
					}
				}
			}
		}
		return count;
	}
}
