import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SortingGame {
	
	public int fewestMoves(int[] board, int k) {
		int givenBoard = 0;
		for(int i=0; i<board.length; i++)
		{
			givenBoard = givenBoard*10 + board[i];
		}
		int sortedBoard = 12345678;
		sortedBoard /= (int) Math.pow(10, 8-board.length);
		if(sortedBoard == givenBoard)
			return 0;
		Deque<Integer> que = new ArrayDeque<>(1000);
		HashMap<Integer, Integer> map= new HashMap<>(1000);
		que.add(sortedBoard);
		map.put(sortedBoard, 0);
		while(que.size() != 0)
		{
			int current = que.pop();
			int distance = map.get(current) + 1;
			for(int i=0; i<board.length-k+1; i++)
			{
				int next = getNext(current, i, k, board.length);
				if(givenBoard == next)
					return distance;
				if(map.get(next) == null)
				{
					que.add(next);
					map.put(next, distance);
				}
			}
		}
		return -1;
	}
	
	int getNext(int current, int i, int k, int n)
	{
		String ans = Integer.toString(current);
		ans = ans.substring(0,i) + new StringBuffer(ans.substring(i,i+k)).reverse().toString() + ans.substring(i+k,n);
		return Integer.parseInt(ans);
	}
}
