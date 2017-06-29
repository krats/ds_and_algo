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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class TaskA {
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int c = in.nextInt();
			int v0 = in.nextInt();
			int v1 = in.nextInt();
			int a = in.nextInt();
			int l = in.nextInt();
			int count = v0;
			int ans = 1;
			while (count < c) {
				ans++;
				if (v1 < v0 + (ans - 1) * a)
					count = count + v1 - Math.min(count, l);
				else
					count = count + v0 + (ans - 1) * a - Math.min(count, l);
			}
			out.println(ans);
		}
		
	}
}

