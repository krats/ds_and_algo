import java.util.*;
import java.math.*;
import static java.lang.Math.*;

class Node {
	int index;
	ArrayList<Integer> children;
	ArrayList<Integer> weights;
}

public class LuckyCycle {
	
	public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
		int N = edge1.length+1;
		int root = edge1[0];
		Node[] nodes = new Node[N+1];
		for(int i=1; i<N+1; i++)
		{
			nodes[i] = new Node();
			nodes[i].index = i;
			nodes[i].children = new ArrayList<Integer>(N);
			nodes[i].weights = new ArrayList<Integer>(N);
		}
		for(int i=0; i<N-1; i++)
		{
			nodes[edge1[i]].children.add(edge2[i]);
			nodes[edge1[i]].weights.add(weight[i]);
			nodes[edge2[i]].children.add(edge1[i]);
			nodes[edge2[i]].weights.add(weight[i]);
		}
		int[][] noOf4s = new int[N+1][N+1];
		int[][] noOf7s = new int[N+1][N+1];
		for(int i=1; i<N+1; i++)
		{
			int src = i;
			Deque<Integer> que = new ArrayDeque<>(N);
			boolean[] visited = new boolean[N+1];
			que.add(src);
			while(que.size() != 0)
			{
				int current = que.pop();
				visited[current] = true;
				for(int j=0 ;j<nodes[current].children.size(); j++)
				{
					int k = nodes[current].children.get(j);
					int w = nodes[current].weights.get(j);
					if(!visited[k])
					{
						que.add(k);
						noOf4s[i][k] = noOf4s[i][current];
						noOf7s[i][k] = noOf7s[i][current];
						if(w == 4)
						{
							noOf4s[i][k] += 1;
						}
						else
						{
							noOf7s[i][k] += 1;
						}
						if(noOf4s[i][k] != 0 && noOf7s[i][k] != 0 && abs(noOf4s[i][k] - noOf7s[i][k]) == 1)
						{
							if(noOf4s[i][k] > noOf7s[i][k])
							{
								return new int[]{i, k, 7};
							}
							else
							{
								return new int[]{i, k, 4};
							}
						}
					}
				}
			}
		}
		return new int[0];
	}
}
