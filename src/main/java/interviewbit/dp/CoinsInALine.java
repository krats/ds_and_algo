package interviewbit.dp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by karthikb on 24-05-2017.
 */
public class CoinsInALine {
	public static int maxcoin(ArrayList<Integer> a) {
		int dp1[][] = new int[a.size()][a.size()];
		int sum[][] = new int[a.size()][a.size()];
		for(int i=1; i<a.size(); i++)
		{
			dp1[i][i] = a.get(i);
			sum[i][i] = a.get(i);
		}
		for(int len=2; len <=a.size(); len++)
		{
			for(int i=0; i<a.size()-len+1; i++)
			{
				int j = i + len - 1;
				if(len == 2)
				{
					sum[i][j] = a.get(i) + a.get(j);
					dp1[i][j] = Math.max(a.get(i), a.get(j));
				}
				else
				{
					sum[i][j] = sum[i][j-1] + a.get(j);
					dp1[i][j] = Math.max(sum[i+1][j] - dp1[i+1][j] + a.get(i), sum[i][j-1] - dp1[i][j-1] + a.get(j));
				}
				
			}
		}
		return dp1[0][a.size()-1];
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for(int i=0; i<N; i++)
		{
			arr.add(in.nextInt());
		}
		System.out.println(maxcoin(arr));
	}
}

