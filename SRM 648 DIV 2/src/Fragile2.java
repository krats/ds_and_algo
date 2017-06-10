import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Fragile2 {
	
	public int countPairs(String[] graph) {
		int num = numOfConnectedComponents(graph, -1, -1);
		int ans = 0;
		for(int i=0; i<graph.length; i++)
		{
			for(int j=i+1; j<graph.length; j++)
			{
				if(num < numOfConnectedComponents(graph, i, j))
					ans++;
			}
		}
		return ans;
	}
	
	int numOfConnectedComponents(String[] graph, int v1, int v2)
	{
		HashMap<Integer, Boolean> visited = new HashMap<>(graph.length);
		int count = 0;
		for(int i=0; i<graph.length; i++)
		{
			if(visited.get(i) == null && i != v1 && i!= v2)
			{
				count++;
				dfsVisit(graph, v1, v2, i, visited);
			}
		}
		return count;
	}
	
	void dfsVisit(String[] graph, int v1, int v2, int root, HashMap<Integer, Boolean> visited)
	{
		visited.put(root, true);
		for(int i=0; i<graph.length; i++)
		{
			if(graph[root].charAt(i) == 'Y' && visited.get(i) == null && i!= v1 && i!= v2)
			{
				visited.put(i, true);
				dfsVisit(graph, v1, v2, i, visited);
			}
		}
	}
}
