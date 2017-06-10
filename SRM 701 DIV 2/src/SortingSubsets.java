import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SortingSubsets {
	
	public int getMinimalSize(int[] a) {
		int[] k  = new int[a.length];
		for(int i=0; i<a.length; i++)
		{
			k[i] = a[i];
		}
		Arrays.sort(k);
		int ans = 0;
		for(int i=0; i<a.length; i++)
		{
			if(a[i] != k[i])
				ans += 1;
		}
		return ans;
	}
}
