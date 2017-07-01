import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LexmaxReplace {
	
	public String get(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		Arrays.sort(tt);
		for(int i = 0, j = tt.length-1; i < s.length() && j >= 0; i++ )
		{
			if(ss[i] < tt[j])
			{
				ss[i] = tt[j];
				j--;
			}
		}
		return new String(ss);
	}
}
