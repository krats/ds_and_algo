import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class StepsConstruct {
	
	public String construct(String[] board, int K) {
		int N = board.length;
		int M = board[0].length();
		boolean[][][] nodes = new boolean[N][M][K+1];
		Deque<Node> que = new ArrayDeque<>(N*M*(K+1));
		if(board[N-1].charAt(M-1) == '.') {
			nodes[N-1][M-1][0] = true;
			que.add(new Node(N-1, M-1, 0));
		}
		while(que.size() != 0)
		{
			Node current = que.pop();
			int i = current.x;
			int j = current.y;
			int k = current.k;
			if(k < K)
			{
				if(i-1 >= 0 && j < M && !nodes[i-1][j][k+1] && board[i-1].charAt(j) == '.')
				{
					nodes[i-1][j][k+1] = true;
					que.add(new Node(i-1, j, k+1));
				}
				if(i+1 < N && j < M && !nodes[i+1][j][k+1] && board[i+1].charAt(j) == '.')
				{
					nodes[i+1][j][k+1] = true;
					que.add(new Node(i+1, j, k+1));
				}
				if(i < N && j-1 >= 0 && !nodes[i][j-1][k+1] && board[i].charAt(j-1) == '.')
				{
					nodes[i][j-1][k+1] = true;
					que.add(new Node(i, j-1, k+1));
				}
				if(i < N && j+1 < M && !nodes[i][j+1][k+1] && board[i].charAt(j+1) == '.')
				{
					nodes[i][j+1][k+1] = true;
					que.add(new Node(i, j+1, k+1));
				}
			}
		}
		String ans = "";
		if(nodes[0][0][K])
		{
			ans = ans + traverse(nodes, 0, 0, K);
		}
		return ans;
	}
	
	String traverse(boolean[][][] nodes, int i, int j, int k)
	{
		int N = nodes.length;
		int M = nodes[0].length;
		int K = nodes[0][0].length;
		if(i == N-1 && j == M-1 && k == 0)
		{
			return "";
		}
		if(i-1 >= 0 && j < M && k-1 >= 0 && nodes[i-1][j][k-1])
		{
			return "U" + traverse(nodes, i-1, j, k-1);
		}
		if(i+1 < N && j < M && k-1 >= 0 && nodes[i+1][j][k-1])
		{
			return "D" + traverse(nodes, i+1, j, k-1);
		}
		if(i < N && j-1 >= 0 && k-1 >= 0 && nodes[i][j-1][k-1])
		{
			return "L" + traverse(nodes, i, j-1, k-1);
		}
		if(i < N && j+1 < M && k-1 >= 0 && nodes[i][j+1][k-1])
		{
			return "R" + traverse(nodes, i, j+1, k-1);
		}
		return "";
	}
}

class Node {
	int x,y,k;
	public Node(int x, int y, int k)
	{
		this.x = x;
		this.y = y;
		this.k = k;
	}
}
