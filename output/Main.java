import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class TaskB {
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			in.nextLine();
			char[][] grid = new char[n][m];
			int count = 0;
			int right = Integer.MIN_VALUE;
			int left = Integer.MAX_VALUE;
			int top = Integer.MAX_VALUE;
			int bottom = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				String next = in.nextLine();
				for (int j = 0; j < m; j++) {
					grid[i][j] = next.charAt(j);
					if (next.charAt(j) == 'B') {
						count++;
						left = Math.min(left, j);
						right = Math.max(right, j);
						top = Math.min(top, i);
						bottom = Math.max(bottom, i);
					}
				}
			}
			
			if (count == 0)
				out.print(1);
			else {
				int width = right - left + 1;
				int height = bottom - top + 1;
				int square = Math.max(width, height);
				if (square > Math.min(n, m)) {
					out.print(-1);
				} else {
					out.print(square * square - count);
				}
			}
		}
		
	}
}

