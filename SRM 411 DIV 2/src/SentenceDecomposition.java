import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SentenceDecomposition {
	
	String sortedWords[];
	String sentence;
	String[] validWords;
	HashMap<Integer, Integer> dp;
	
	public int decompose(String sentence, String[] validWords) {
		this.validWords = validWords;
		this.sentence = sentence;
		int N = sentence.length();
		dp = new HashMap<Integer, Integer>(N);
		this.sortedWords = new String[validWords.length];
		for(int i=0; i<validWords.length; i++)
		{
			char[] arr = validWords[i].toCharArray();
			Arrays.sort(arr);
			sortedWords[i] = new String(arr);
		}
		return calculateCost(0);
	}
	
	int calculateCost(int index)
	{
		if(dp.get(index) != null)
			return dp.get(index);
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<this.sortedWords.length; i++)
		{
			int next_index = index + this.sortedWords[i].length();
			if(next_index <= this.sentence.length())
			{
				String substr = this.sentence.substring(index, next_index);
				char[] sorted = substr.toCharArray();
				Arrays.sort(sorted);
				if(new String(sorted).equals(this.sortedWords[i]))
				{
					int this_cost = 0;
					for(int j=index; j<next_index; j++)
					{
						if(this.validWords[i].charAt(j-index) != this.sentence.charAt(j))
							this_cost += 1;
					}
					if(next_index < this.sentence.length())
					{
						int cost = calculateCost(next_index);
						
						if(cost != -1)
							ans = Math.min(ans, this_cost + cost);
					}
					else
					{
						ans = Math.min(ans, this_cost);
					}
				}
			}
		}
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		dp.put(index, ans);
		return ans;
	}
}
