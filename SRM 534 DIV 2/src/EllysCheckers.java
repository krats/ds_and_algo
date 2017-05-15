import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EllysCheckers {

	public String getWinner(String board) {
		HashMap<String, Boolean> mymap = new HashMap<String, Boolean>(2000);
		return canWinSubtask(board, board.length(), mymap) ? "YES" : "NO";
	}

	public boolean canWinSubtask(String board, int n, HashMap<String, Boolean> map)
	{
		boolean canWin = false;
		if(board.charAt(n-1) == 'o')
		{
			board = board.substring(0,n-1) + '.';
		}
		if(map.get(board) != null)
			return map.get(board);
		for(int i=0; i<n-1; i++)
		{
			if(board.charAt(i) == 'o')
			{
				if(board.charAt(i+1) == '.')
				{
					canWin = canWin || !canWinSubtask(board.substring(0,i)+".o"+board.substring(i+2,n), n, map);
				}
				else if(i+3 < n && board.charAt(i+3) == '.')
				{
					canWin = canWin || !canWinSubtask(board.substring(0,i)+'.'+board.substring(i+1,i+3)+'o'+board.substring(i+4,n), n, map);
				}
			}
		}
		map.put(board, canWin);
		return canWin;
	}
}
