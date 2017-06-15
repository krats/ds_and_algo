import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MazeWanderingEasy {
	
	public int decisions(String[] maze) {
		int Mi=0,Mj=0,Ci=0,Cj=0;
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length();j++)
			{
				if(maze[i].charAt(j) == 'M')
				{
					Mi = i;
					Mj = j;
				}
				if(maze[i].charAt(j) == '*')
				{
					Ci = i;
					Cj = j;
				}
			}
		}
		Deque<Integer> quei = new ArrayDeque<>(maze.length*maze[0].length());
		Deque<Integer> quej = new ArrayDeque<>(maze.length*maze[0].length());
		boolean visited[][] = new boolean[maze.length][maze[0].length()];
		int previousx[][] = new int[maze.length][maze[0].length()];
		int previousy[][] = new int[maze.length][maze[0].length()];
		quei.add(Mi);
		quej.add(Mj);
		visited[Mi][Mj] = true;
		while(quei.size() > 0)
		{
			int currenti = quei.pop();
			int currentj = quej.pop();
			if(currenti - 1 >= 0 && currentj >= 0)
			{
				if((maze[currenti-1].charAt(currentj) == '.' || maze[currenti-1].charAt(currentj) == '*') && !visited[currenti-1][currentj])
				{
					previousx[currenti-1][currentj] = currenti;
					previousy[currenti-1][currentj] = currentj;
					quei.add(currenti-1);
					quej.add(currentj);
					visited[currenti-1][currentj] = true;
				}
			}
			if(currenti >= 0 && currentj - 1 >= 0)
			{
				if((maze[currenti].charAt(currentj-1) == '.' || maze[currenti].charAt(currentj-1) == '*') && !visited[currenti][currentj-1])
				{
					previousx[currenti][currentj-1] = currenti;
					previousy[currenti][currentj-1] = currentj;
					quei.add(currenti);
					quej.add(currentj-1);
					visited[currenti][currentj-1] = true;
				}
			}
			if(currenti + 1 < maze.length && currentj >= 0)
			{
				if((maze[currenti+1].charAt(currentj) == '.' || maze[currenti+1].charAt(currentj) == '*') && !visited[currenti+1][currentj])
				{
					previousx[currenti+1][currentj] = currenti;
					previousy[currenti+1][currentj] = currentj;
					quei.add(currenti+1);
					quej.add(currentj);
					visited[currenti+1][currentj] = true;
				}
			}
			if(currenti >= 0 && currentj + 1 < maze[0].length())
			{
				if((maze[currenti].charAt(currentj+1) == '.' || maze[currenti].charAt(currentj+1) == '*') && !visited[currenti][currentj+1])
				{
					previousx[currenti][currentj+1] = currenti;
					previousy[currenti][currentj+1] = currentj;
					quei.add(currenti);
					quej.add(currentj+1);
					visited[currenti][currentj+1] = true;
				}
			}
		}
		int ans = 0;
		int degree=0;
		while (Ci != Mi || Cj != Mj)
		{
			int a = previousx[Ci][Cj];
			int b = previousy[Ci][Cj];
			degree = 0;
			if(a >= 0 && b-1 >=0 && (maze[a].charAt(b-1) == '.' || maze[a].charAt(b-1) == '*' || maze[a].charAt(b-1) == 'M'))
				degree ++;
			if(a-1 >= 0 && b >=0 && (maze[a-1].charAt(b) == '.' || maze[a-1].charAt(b) == '*' || maze[a-1].charAt(b) == 'M'))
				degree ++;
			if(a >= 0 && b+1 < maze[0].length() && (maze[a].charAt(b+1) == '.' || maze[a].charAt(b+1) == '*' || maze[a].charAt(b+1) == 'M'))
				degree ++;
			if(a+1 < maze.length && b >=0 && (maze[a+1].charAt(b) == '.' || maze[a+1].charAt(b) == '*' || maze[a+1].charAt(b) == 'M'))
				degree ++;
			if(degree > 2)
				ans++;
			Ci = a;
			Cj = b;
		}
		if(degree == 2)
			ans++;
		return ans;
	}
}
