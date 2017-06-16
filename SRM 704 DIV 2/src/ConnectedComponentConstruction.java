import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ConnectedComponentConstruction {
	
	public String[] construct(int[] s) {
		int N = s.length;
		HashMap<Integer, ArrayList<Integer>> map= new HashMap<>(N);
		for(int i=0; i<N; i++) {
			if(map.containsKey(s[i])) {
				map.get(s[i]).add(i);
			}
			else {
				map.put(s[i], new ArrayList<Integer>(N));
				map.get(s[i]).add(i);
			}
		}
		boolean possible = true;
		for(int key : map.keySet()) {
			int num = map.get(key).size();
			if(num % key != 0) {
				possible = false;
				break;
			}
		}
		if(!possible)
			return new String[0];
		boolean[][] ans = new boolean[N][N];
		for(int key : map.keySet()) {
			ArrayList<Integer> list= map.get(key);
			int num = list.size();
			for(int i=0 ;i<num/key; i++)
			{
				for(int j=0; j<key; j++)
				{
					for(int k=0; k<key; k++)
					{
						int index = list.get(i*key+j);
						int toIndex = list.get(i*key+k);
						if(index != toIndex)
							ans[index][toIndex] = true;
					}
				}
			}
		}
		String[] actualAns = new String[N];
		for(int i=0; i<N; i++)
		{
			StringBuilder row = new StringBuilder();
			for(int j=0; j<N; j++)
			{
				if(ans[i][j])
					row.append('Y');
				else
					row.append('N');
			}
			actualAns[i] = row.toString();
		}
		return actualAns;
	}
}
