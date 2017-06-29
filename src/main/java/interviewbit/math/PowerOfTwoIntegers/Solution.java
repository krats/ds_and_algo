package interviewbit.math.PowerOfTwoIntegers;

/**
 * Created by karthikb on 28-06-2017.
 */
public class Solution {
	public boolean isPower(int a) {
		for(int p =2; p<32; p++)
		{
			int A = (int) Math.pow(a, 1.0/p);
			if(a == (int) Math.pow(A, p))
			{
				return true;
			}
			if(a == (int) Math.pow(A+1, p))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		new Solution().isPower(1024000000);
	}
}
