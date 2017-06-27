import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Permutiple {
	
	public String isPossible(int x) {
		String num = Integer.toString(x);
		if(num.length() == 1)
			return "Impossible";
		if(heapPermutation(num.toCharArray(), num.length(), num.length(), x))
			return "Possible";
		else
			return "Impossible";
	}
	
	boolean heapPermutation(char[] num, int size, int n, int originalNum)
	{
		if (size == 1)
		{
			int k = Integer.parseInt(new String(num));
			return (k%originalNum) == 0 && k != originalNum;
		}
		for (int i=0; i<size; i++)
		{
			if(heapPermutation(num,size-1,n, originalNum))
				return true;
			if (size%2==1)
			{
				char temp = num[0];
				num[0] = num[size-1];
				num[size-1] = temp;
			}
			else
			{
				char temp = num[i];
				num[i] = num[size-1];
				num[size-1] = temp;
			}
		}
		return false;
	}
}
