import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PathGameDiv2 {
	
	public int calc(String[] board) {
		int[][] ans = new int[2][board[0].length()];
		ans[0][0] = board[0].charAt(0) == '.'? board[1].charAt(0) == '.'? 1: 0 : -1;
		ans[1][0] = board[1].charAt(0) == '.'? board[0].charAt(0) == '.'? 1: 0 : -1;
		for(int i=1; i<board[0].length(); i++)
		{
			ans[0][i] = -1;
			ans[1][i] = -1;
			if(ans[0][i-1] != -1 && board[0].charAt(i) == '.')
			{
				ans[0][i] = ans[0][i-1];
				if(board[1].charAt(i) == '.')
					ans[0][i] += 1;
			}
			if(ans[1][i-1] != -1 && board[1].charAt(i) == '.')
			{
				ans[1][i] = ans[1][i-1];
				if(board[0].charAt(i) == '.')
					ans[1][i] += 1;
			}
			if(board[0].charAt(i) == '.' && board[1].charAt(i) == '.')
			{
				int a = max(ans[0][i], ans[1][i] - 1);
				int b = max(ans[1][i], ans[0][i] - 1);
				ans[0][i] = a;
				ans[1][i] = b;
			}
		}
		return max(ans[0][board[0].length()-1], ans[1][board[0].length()-1]);
	}
}
