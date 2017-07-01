import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
	
	static class TaskC {
		public void solve(int testNumber, Scanner in, PrintWriter out) {
			int numOfSofas = in.nextInt();
			int n = in.nextInt();
			int m = in.nextInt();
			Sofa[] sofas = new Sofa[numOfSofas];
			int x1, y1, x2, y2;
			for (int i = 0; i < numOfSofas; i++) {
				x1 = in.nextInt();
				y1 = in.nextInt();
				x2 = in.nextInt();
				y2 = in.nextInt();
				sofas[i] = new Sofa(x1, y1, x2, y2, i);
			}
			Arrays.sort(sofas);
			int cl = in.nextInt();
			int cr = in.nextInt();
			int ct = in.nextInt();
			int cb = in.nextInt();
			int ans = -1;
			for (int i = 0; i < numOfSofas - 1; i++) {
				int j = i + 1;
				if (sofas[i].x1 < sofas[j].x1 || sofas[i].x2 < sofas[j].x2) {
					sofas[j].cl++;
				} else if (sofas[i].x1 > sofas[j].x1 || sofas[i].x2 > sofas[j].x2) {
					sofas[j].cr++;
				}
			}
			for (int i = 0; i < numOfSofas - 1; i++) {
				sofas[i].cl += sofas[i + 1].cl;
				sofas[i].cr += sofas[i + 1].cr;
			}
			Arrays.sort(sofas);
			for (int i = 0; i < numOfSofas - 1; i++) {
				int j = i + 1;
				if (sofas[i].y1 < sofas[j].y1 || sofas[i].y2 < sofas[j].y2) {
					sofas[j].cb++;
				} else if (sofas[i].x1 > sofas[j].x1 || sofas[i].x2 > sofas[j].x2) {
					sofas[j].ct++;
				}
			}
			for (int i = 0; i < numOfSofas - 1; i++) {
				sofas[i].cb += sofas[i + 1].cb;
				sofas[i].ct += sofas[i + 1].ct;
			}
			for (int i = 0; i < numOfSofas - 1; i++) {
				if (sofas[i].cl == cl && sofas[i].cr == cr && sofas[i].ct == ct && sofas[i].cb == cb) {
					ans = sofas[i].i + 1;
				}
			}
			out.println(ans);
		}
		
		class Sofa implements Comparable<Sofa> {
			int x1;
			int y1;
			int x2;
			int y2;
			int i;
			int k;
			int cl = 0;
			int cr = 0;
			int ct = 0;
			int cb = 0;
			
			public Sofa(int x1, int x2, int x3, int x4, int i) {
				this.x1 = x1;
				this.y1 = x2;
				this.x2 = x3;
				this.y2 = x4;
				this.i = i;
				this.k = 0;
			}
			
			public int compareTo(Sofa b) {
				if (k == 0) {
					if (x1 != b.x1)
						return x1 - b.x1;
					else
						return x2 - b.x2;
				} else {
					if (y1 != b.y1)
						return y1 - b.y1;
					else
						return y2 - b.y2;
				}
			}
			
		}
		
	}
}

