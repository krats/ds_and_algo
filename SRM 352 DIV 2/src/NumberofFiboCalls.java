import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NumberofFiboCalls {
	
	public int[] fiboCallsMade(int n) {
		int[] a1 = {1,0};
		int[] a2 = {0,1};
		if(n==0)
			return a1;
		if(n==1)
			return a2;
		for(int i=2; i<=n; i++)
		{
			a2[0] = a1[0] + a2[0];
			a1[0] = a2[0] - a1[0];
			a2[1] = a1[1] + a2[1];
			a1[1] = a2[1] - a1[1];
		}
		return a2;
	}
}
