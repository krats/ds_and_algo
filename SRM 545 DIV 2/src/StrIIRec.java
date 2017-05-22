import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class StrIIRec {
	
	public String recovstr(int n, int minInv, String minStr) {
		char[] alphabets = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		boolean isPresent[] = new boolean[26];
		String ans = "";
		for(int i=0; i<minStr.length(); i++)
		{
			isPresent[minStr.charAt(i)-'a'] = true;
		}
		for(int i=0; i<n; i++)
		{
			if(!isPresent[i])
			{
				minStr = minStr + alphabets[i];
			}
			ans += alphabets[i];
		}
		return solve(ans, minStr, minInv);
	}
	
	String solve(String ans, String minStr, int minInv)
	{
		if(ans == "")
			return ans;
		for(int i=0; i<ans.length(); i++)
		{
			if(minStr.length() > 0 && minStr.charAt(0) > ans.charAt(i))
				continue;
			int inv = max(minInv -i, 0);
			int nn = ans.length() -1;
			if(nn*(nn-1)/2 >= inv)
			{
				String new_ans = ans.substring(0,i) + ans.substring(i+1);
				String nminStr = "";
				if ( (minStr.length() > 0) && (minStr.charAt(0) == ans.charAt(i)) ) {
					nminStr = minStr.substring(1);
				}
				// Concatenate the chosen letter with the sub-problem's result
				return ans.charAt(i) + solve(new_ans, nminStr, inv);
			}
		}
		return "";
	}
}
