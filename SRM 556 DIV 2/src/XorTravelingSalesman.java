import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class XorTravelingSalesman {
	
	public int maxProfit(int[] cityValues, String[] roads) {
		int ans = 0;
		int N = cityValues.length;
		Deque<Node> que = new ArrayDeque<>(N);
		que.add(new Node(0, cityValues[0]));
		ans = max(ans, cityValues[0]);
		HashMap<Integer, HashMap<Integer, Boolean>> map = new HashMap<>(N);
		map.put(0, new HashMap<>(N));
		map.get(0).put(cityValues[0], true);
		while (que.size() != 0)
		{
			Node n = que.pop();
			int index = n.index;
			int currentProfit = n.profit;
			for(int i=0; i<N; i++)
			{
				if(i != index && (roads[index].charAt(i) == 'Y' || roads[i].charAt(index) == 'Y')&& !(map.containsKey(i) && map.get(i).containsKey(currentProfit^cityValues[i])))
				{
					if(!map.containsKey(i))
					{
						map.put(i, new HashMap<>(N));
					}
					map.get(i).put(currentProfit^cityValues[i], true);
					ans = max(ans, currentProfit^cityValues[i]);
					que.add(new Node(i, currentProfit^cityValues[i]));
				}
			}
		}
		return ans;
	}
}

class Node{
	int index, profit;
	public Node(int index, int profit)
	{
		this.index = index;
		this.profit = profit;
	}
}