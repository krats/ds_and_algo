import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ErdosNumber {
	
	public String[] calculateNumbers(String[] publications) {
		HashMap<String,Integer> map = new HashMap<>(50);
		int count = 0;
		int erdos = -1;
		for(int i=0; i<publications.length; i++)
		{
			String[] authors = publications[i].split("\\s+");
			for(int j=0; j<authors.length; j++)
			{
				if(!map.containsKey(authors[j]))
				{
					if(authors[j].equals("ERDOS"))
						erdos = count;
					map.put(authors[j], count);
					count++;
				}
			}
		}
		boolean[][] graph = new boolean[count][count];
		for(int i=0; i<publications.length; i++)
		{
			String[] authors = publications[i].split("\\s+");
			for(int j=0; j<authors.length; j++)
			{
				for(int k=j+1; k<authors.length; k++)
				{
					graph[map.get(authors[j])][map.get(authors[k])] = true;
					graph[map.get(authors[k])][map.get(authors[j])] = true;
				}
			}
		}
		String[] authors = new String[count];
		int k = 0;
		for(String key: map.keySet())
		{
			authors[k] = key;
			k++;
		}
		int[] ans = djkistra(graph, erdos);
		Arrays.sort(authors);
		for(int i=0; i<count; i++)
		{
			if(map.containsKey(authors[i]) && ans[map.get(authors[i])] != Integer.MAX_VALUE)
				authors[i] = authors[i] + " " + Integer.toString(ans[map.get(authors[i])]);
		}
		
		return authors;
	}
	
	int[] djkistra(boolean[][] graph, int src)
	{
		int N = graph.length;
		int[] ans = new int[N];
		for(int i=0; i<N; i++)
		{
			ans[i] = Integer.MAX_VALUE;
		}
		ans[src] = 0;
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++)
		{
			int current = -1;
			int currentMin = Integer.MAX_VALUE;
			for(int j=0; j<N; j++)
			{
				if(currentMin > ans[j] && !visited[j])
				{
					currentMin = ans[j];
					current = j;
				}
			}
			if(current == -1)
				break;
			visited[current] = true;
			for(int j=0; j<N; j++)
			{
				if(graph[current][j] && !visited[j])
				{
					ans[j] = min(ans[j], ans[current] + 1);
				}
			}
		}
		return ans;
	}
}
