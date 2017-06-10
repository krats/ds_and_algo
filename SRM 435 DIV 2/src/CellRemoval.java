import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CellRemoval {
	
	public int cellsLeft(int[] parent, int deletedCell) {
		ArrayList<Integer>[] adj = new ArrayList[parent.length+1];
		for(int i=0; i<parent.length+1; i++)
		{
			adj[i] = new ArrayList<>(parent.length);
		}
		for(int i=0; i<parent.length; i++)
		{
			adj[parent[i]+1].add(i);
		}
		return countleafs(adj, deletedCell, -1);
	}
	
	int countleafs(ArrayList<Integer>[] adj, int deletedCell, int root)
	{
		if(root == deletedCell)
			return 0;
		if(adj[root+1].size() == 0)
			return 1;
		else{
			int ans = 0;
			for(int i=0; i<adj[root+1].size(); i++)
			{
				ans += countleafs(adj, deletedCell, adj[root+1].get(i));
			}
			return ans;
		}
	}
}
