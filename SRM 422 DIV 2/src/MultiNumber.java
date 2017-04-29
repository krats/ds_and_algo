import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MultiNumber {
	
	public String check(int number) {
		long arr[] = new long[11];
		int n = 0;
		long total = 1;
		int zeroes = 0;
		while(number > 0)
		{
			arr[n] = number%10;
			number/=10;
			total*=arr[n];
			if(arr[n] == 0)
			{
				zeroes += 1;
			}
			if(zeroes == 2)
			{
				return "YES";
			}
			n++;
		}
		if(zeroes == 1)
		{
			return "NO";
		}
		int present = 1;
		for(int i=0; i<n-1; i++)
		{
			if(present*arr[i] == total/arr[i])
			{
				return "YES";
			}
			present*= arr[i];
			total/=arr[i];
		}
		return "NO";
	}
}
