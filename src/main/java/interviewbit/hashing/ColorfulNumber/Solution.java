package interviewbit.hashing.ColorfulNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karthikb on 11-07-2017.
 */
public class Solution {
	public int colorful(int a) {
		ArrayList<Integer> digits = new ArrayList<>();
		while (a>0)
		{
			digits.add(a%10);
			a /= 10;
		}
		HashSet<Integer> set = new HashSet<>();
		for(int len=1; len <= digits.size(); len++)
		{
			for(int i=0; i<digits.size()-len+1; i++)
			{
				int prod = 1;
				for(int j=i; j<i+len; j++)
				{
					prod*=digits.get(j);
				}
				if(set.contains(prod))
					return 0;
				set.add(prod);
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.colorful(3245));
	}
}
