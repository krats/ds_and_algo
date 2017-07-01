import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NiceTable {
	
	public String isNice(String[] t) {
		int count0;
		int count1;
		int n = t[0].length();
		for(int i=0; i<t.length-1; i++)
		{
			count0 = 0;
			count1 = 0;
			for(int j=0; j < n; j++)
			{
				if(t[i].charAt(j) != t[i+1].charAt(j))
					count1++;
				else
					count0++;
			}
			if(count0 !=n && count1 != n)
				return "Not nice";
		}
		return "Nice";
	}
}
