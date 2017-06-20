import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class AddElectricalWires {
	
	public int maxNewWires(String[] wires, int[] gridConnections) {
		int N = wires.length;
		int[] gridId = new int[N];
		for(int i=0; i<N; i++)
		{
			gridId[i] = -1;
		}
		for(int i=0; i<gridConnections.length; i++)
		{
			int src = gridConnections[i];
			Deque<Integer> que = new ArrayDeque<>(N);
			que.add(src);
			gridId[src] = src;
			while(que.size() != 0)
			{
				int current = que.pop();
				
				for(int j=0; j<wires[current].length(); j++)
				{
					if(wires[current].charAt(j) == '1' && gridId[j] == -1)
					{
						que.add(j);
						gridId[j] = src;
					}
				}
			}
		}
		HashMap<Integer, Integer> counts = new HashMap<>(gridConnections.length+1);
		counts.put(-1, 0);
		for(int i=0; i<N; i++)
		{
			if(!counts.containsKey(gridId[i]))
			{
				counts.put(gridId[i], 0);
			}
			counts.put(gridId[i], counts.get(gridId[i])+1);
		}
		int maxGrid = -1;
		int maxGridCount = -1;
		for(int i=0; i<gridConnections.length; i++)
		{
			if(maxGridCount < counts.get(gridConnections[i]))
			{
				maxGrid = gridConnections[i];
				maxGridCount = counts.get(gridConnections[i]);
			}
		}
		int GridConnections = 0;
		for (int i = 0; i < N; i++) {
			for(int j=i+1; j<N; j++)
			{
				if(gridId[i] == gridId[j] && wires[i].charAt(j) != '1')
				{
					GridConnections += 1;
				}
			}
		}
		return GridConnections+counts.get(-1)*maxGridCount;
	}
}
