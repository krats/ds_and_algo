import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearPlaysDiv2 {
	HashMap<Long, Boolean> dp;
	long a,b,c;
	boolean equalPilesRecursive(long a1, long b1, long c1) {
		if(dp.get(a1*8192*8192+b1*8192+c1) != null)
			return false;
		if(a1 == a && b1 == b && c1 == c)
			return true;
		boolean ans = false;
		dp.put((a1*8192*8192+b1*8192+c1), true);
		if(a1 % 2 == 0 && a1/2 < b1 + a1/2)
		{
			ans = ans || equalPilesRecursive(a1/2, b1+a1/2, c1);
		}
		if(b1 % 2 == 0 && b1/2 < a1 + b1/2)
		{
			ans = ans || equalPilesRecursive(a1+b1/2, b1/2, c1);
		}
		if(c1 % 2 == 0 && c1/2 < a1 + c1/2)
		{
			ans = ans || equalPilesRecursive(a1+c1/2, b1, c1/2);
		}
		if(a1 % 2 == 0 && a1/2 < c1 + a1/2)
		{
			ans = ans || equalPilesRecursive(a1/2, b1, c1+a1/2);
		}
		if(c1 % 2 == 0 && c1/2 < b1 + c1/2)
		{
			ans = ans || equalPilesRecursive(a1, b1+c1/2, c1/2);
		}
		if(b1 % 2 == 0 && b1/2 < c1 + b1/2)
		{
			ans = ans || equalPilesRecursive(a1, b1/2, c1+b1/2);
		}
		return ans;
	}
	public String equalPiles(int A, int B, int C) {
		if(A == B && B == C)
			return "possible";
		int k = A + B + C;
		if(k%3 != 0)
			return "impossible";
		dp = new HashMap<Long, Boolean>(1500);
		a = A;
		b = B;
		c = C;
		return equalPilesRecursive(k/3, k/3, k/3)? "possible": "impossible";
	}
}
