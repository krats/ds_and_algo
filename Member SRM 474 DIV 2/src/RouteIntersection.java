import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RouteIntersection {
	
	public String isValid(int N, int[] coords, String moves) {
		HashMap <Integer, Integer> map = new HashMap<>(50);
		int k = 0;
		for(int i=0; i<coords.length; i++)
		{
			if(map.get(coords[i]) == null)
			{
				map.put(coords[i], k);
				k += 1;
			}
		}
		int dp[][] = new int[coords.length+1][k];
		for(int i=1; i<=coords.length; i++)
		{
			for(int j=0; j<k; j++)
			{
				dp[i][j] = dp[i-1][j];
			}
			if(moves.charAt(i-1) == '+')
			{
				dp[i][map.get(coords[i-1])] += 1;
			}
			if(moves.charAt(i-1) == '-')
			{
				dp[i][map.get(coords[i-1])] -= 1;
			}
			for(int j=i-2; j>=0; j--)
			{
				if(Arrays.equals(dp[i], dp[j]))
					return "NOT VALID";
			}
		}
		return "VALID";
	}
}
