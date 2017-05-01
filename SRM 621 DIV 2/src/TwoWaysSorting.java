import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TwoWaysSorting {
	
	public String sortingMethod(String[] stringList) {
		boolean lengths = true;
		int N = stringList.length;
		String s2[] = new String [N];
		for(int i=0; i<N-1; i++)
		{
			if(stringList[i].length() > stringList[i+1].length())
			{
				lengths = false;
				break;
			}
		}
		boolean lexographic = true;
		for(int i=0; i<N-1; i++)
		{
			if(stringList[i].compareTo(stringList[i+1]) > 0)
			{
				lexographic = false;
				break;
			}
		}
		if(lengths && lexographic)
			return "both";
		if(lengths)
			return "lengths";
		if(lexographic)
			return "lexicographically";
		return "none";
	}
}
