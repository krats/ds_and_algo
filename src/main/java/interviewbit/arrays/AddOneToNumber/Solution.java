package interviewbit.arrays.AddOneToNumber;

import java.util.ArrayList;

/**
 * Created by karthikb on 24-06-2017.
 */
public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> num)
	{
		int carry = 1;
		int i = num.size()-1;
		while (carry == 1 && i >= 0)
		{
			if(num.get(i) + 1 == 10)
			{
				num.set(i, 0);
			}
			else
			{
				num.set(i, num.get(i)+1);
				carry = 0;
			}
			i--;
		}
		if(carry == 1)
		{
			num.add(0, 1);
		}
		while(num.get(0) == 0)
		{
			num.remove(0);
		}
		return num;
	}
}
