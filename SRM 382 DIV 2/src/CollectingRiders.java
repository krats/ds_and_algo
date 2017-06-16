import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CollectingRiders {
	
	public int minimalMoves(String[] board) {
		int N = board.length;
		int M = board[0].length();
		int[][] graph = new int[N*M][N*M];
		ArrayList<Knight> knights = new ArrayList<>(N*M);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(board[i].charAt(j) != '.')
				{
					Knight k1 = new Knight();
					k1.i = i;
					k1.j = j;
					k1.k = board[i].charAt(j) - '0';
					knights.add(k1);
				}
			}
		}
		for(int i=0; i<N*M; i++)
		{
			for(int j=0; j<N*M; j++)
			{
				int x1,y1,x2,y2;
				x1 = i/M;
				y1 = i%M;
				x2 = j/M;
				y2 = j%M;
				if((x2 == x1+1 && y2 == y1+2) || (x2 == x1+1 && y2 == y1-2) || (x2 == x1+2 && y2 == y1+1) || (x2 == x1+2 && y2 == y1-1) || (x2 == x1-1 && y2 == y1+2) || (x2 == x1-1 && y2 == y1-2) || (x2 == x1-2 && y2 == y1+1) || (x2 == x1-2 && y2 == y1-1))
				{
					graph[i][j] = 1;
					graph[j][i] = 1;
				}
				else
				{
					graph[i][j] = Integer.MAX_VALUE;
					graph[j][i] = Integer.MAX_VALUE;
				}
			}
			graph[i][i] = 0;
		}
		graph = floydWarshall(graph);
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				int current = 0;
				boolean possible = true;
				for(int k = 0; k<knights.size(); k++)
				{
					Knight k1 = knights.get(k);
					if(graph[i*M+j][k1.i*M+k1.j] == Integer.MAX_VALUE)
					{
						possible = false;
						break;
					}
					int steps = graph[i*M+j][k1.i*M+k1.j];
					current+= (steps/k1.k);
					if(steps %k1.k != 0)
						current +=1;
				}
				if(ans > current && possible)
					ans = current;
			}
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	int[][] floydWarshall(int[][] graph)
	{
		int N = graph.length;
		int[][][] A = new int[2][N][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				A[0][i][j] = graph[i][j];
			}
		}
		int index = 0;
		for(int k=0; k<N; k++)
		{
			index ^= 1;
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					if(A[index^1][i][k] != Integer.MAX_VALUE && A[index^1][k][j] != Integer.MAX_VALUE)
						A[index][i][j] = min(A[index^1][i][j], A[index^1][i][k]+A[index^1][k][j]);
					else
						A[index][i][j] = A[index^1][i][j];
				}
			}
		}
		return A[index];
	}
}

class Knight{
	public int i,j,k;
}
