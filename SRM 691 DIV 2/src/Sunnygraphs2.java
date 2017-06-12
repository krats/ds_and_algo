import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Sunnygraphs2 {
	
	public long count(int[] a) {
		int n = a.length;
		boolean visited[] = new boolean[n];
		ArrayList<Integer> cycles= new ArrayList<Integer>(n);
		int not_in_cycles = n;
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				int y = a[i];
				boolean foundCycle = false;
				for (int j = 0; j < n; j++) {
					if (y == i) {
						foundCycle = true;
						break;
					}
					y = a[y];
				}
				if(foundCycle)
				{
					visited[i] = true;
					y = a[i];
					int c = 1;
					while(y != i)
					{
						c++;
						visited[y] = true;
						y = a[y];
					}
					cycles.add(c);
					not_in_cycles -= c;
				}
			}
		}
		
		long res = 1L << not_in_cycles;
		for(int i=0; i<cycles.size(); i++) {
			res *= ((1L << cycles.get(i)) - 1);
		}
		if(cycles.size() == 1)
			res++;
		return res;
	}
}
