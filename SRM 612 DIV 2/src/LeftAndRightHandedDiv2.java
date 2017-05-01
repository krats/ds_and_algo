import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LeftAndRightHandedDiv2 {
	
	public int count(String S) {
		int ans = 0;
		int N = S.length();
		for(int i=1; i<N; i++)
		{
			if(S.charAt(i) == 'L' && S.charAt(i-1) == 'R')
				ans += 1;
		}
		return ans;
	}
}
