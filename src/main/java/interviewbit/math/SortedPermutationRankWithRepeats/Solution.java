package interviewbit.math.SortedPermutationRankWithRepeats;

import java.util.ArrayList;

/**
 * Created by karthikb on 29-06-2017.
 */
public class Solution {
	public int[] facts;
	public int findRank(String a) {
		this.facts = new int[a.length()+1];
		long rank = 1;
		int MOD = 1000003;
		this.facts[0]=1;
		for(int i=1; i<=a.length(); i++)
		{
			this.facts[i] = (facts[i-1]*i)%MOD;
		}
		int[] charCount = new int[256];
		for (int i = 0; i < a.length(); i++)
		{
			int index = a.charAt(i)-'0';
			charCount[index]++;
		}
		for (int i = 0; i < a.length(); i++) {
			int index = a.charAt(i)-'0';
			long less = 0;
			int remaining = a.length() - i - 1;
			for (int ch = 0; ch < index; ch++) {
				if(charCount[ch] == 0)
					continue;
				charCount[ch]--;
				long numPermutation = facts[remaining];
				for (int c = 0; c < 128; c++) {
					if (charCount[c] <= 1) continue;
					numPermutation = (numPermutation * inverse(facts[charCount[c]])) % MOD;
				}
				charCount[ch]++;
				less = (less + numPermutation) % MOD;
			}
			rank = (rank + less) % MOD;
			charCount[index]--;
		}
		
		return (int) rank;
	}
	
	long inverse(int num)
	{
		int MOD = 1000003;
		int pow = MOD-2;
		long ans = 1;
		long base = num;
		while(pow > 0)
		{
			if(pow == 1)
				return (ans*base)%MOD;
			if(pow % 2 == 0)
			{
				base = (base*base)%MOD;
				pow/=2;
			}
			else
			{
				ans = (base*ans)%MOD;
				pow--;
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		Solution sol = new Solution();
		System.out.println(sol.findRank("bbbbaaaa"));
	}
}
