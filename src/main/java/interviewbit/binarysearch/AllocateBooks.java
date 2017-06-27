package interviewbit.binarysearch;

import static java.lang.Math.*;
import java.util.*;
public class AllocateBooks {
	public static int books(ArrayList<Integer> a, int b) {
		if(a.size() < b)
			return -1;
		else if(a.size() == b)
		{
			int ans = 0;
			for(int i=0; i<a.size(); i++)
			{
				ans = max(ans, a.get(i));
			}
			return ans;
		}
		else
		{
			int ans = 0;
			int first = 0;
			int second = 0;
			for(int i=0; i<a.size(); i++)
			{
				second += a.get(i);
			}
			ans = (first+second)/2;
			int count = 0;
			int maxim = 0;
			while(first < second)
			{
				count = 0;
				int sum = 0;
				ans = (first+second)/2;
				for(int i=0; i<a.size(); i++)
				{
					if(sum + a.get(i) > ans)
					{
						if(sum != 0) {
							count++;
							sum = a.get(i);
						}
						else
						{
							sum = a.get(i);
						}
					}
					else
					{
						sum += a.get(i);
					}
				}
				if(sum != 0) {
					count++;
				}
				if(count > b)
					first = ans+1;
				else
					second = ans;
			}
			int sum = 0;
			ans = (first+second)/2;
			for(int i=0; i<a.size(); i++)
			{
				if(sum + a.get(i) > ans)
				{
					if(sum != 0) {
						maxim = max(maxim, sum);
						sum = a.get(i);
					}
					else
					{
						sum = a.get(i);
					}
				}
				else
				{
					sum += a.get(i);
				}
			}
			if(sum != 0) {
				maxim = max(maxim, sum);
			}
			return maxim;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a;
		int[] arr = new int[]{12, 34, 67, 90};
		int b = 2;
		a = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
		{
			a.add(arr[i]);
		}
		System.out.println(books(a,b));
		
		arr = new int[]{ 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24 };
		b = 26;
		a = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
		{
			a.add(arr[i]);
		}
		System.out.println(books(a,b));
	}
}