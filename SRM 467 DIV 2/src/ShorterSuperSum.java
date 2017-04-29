import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ShorterSuperSum {
	
	public int calculate(int k, int n) {
		int arr[][] = new int[2][n+1];
		for(int i=1; i<=n; i++)
		{
			arr[0][i] = i;
		}
		int flag = 1;
		for(int i=1; i<=k; i++)
		{
			for(int j=1; j<=n; j++)
			{
					arr[flag][j] = arr[flag][j-1] + arr[flag^1][j];
			}
			flag  = flag^1;
		}
		return arr[flag^1][n];
	}
}
