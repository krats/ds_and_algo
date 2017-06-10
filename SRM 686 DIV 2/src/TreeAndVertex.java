import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TreeAndVertex {
	
	public int get(int[] tree) {
		int degree[] = new int[tree.length+1];
		for(int i=0; i<tree.length; i++)
		{
			degree[tree[i]] += 1;
			degree[i+1] += 1;
		}
		int max = 0;
		for(int i=0; i<degree.length; i++)
		{
			if(max < degree[i])
				max = degree[i];
		}
		return max;
	}
}
