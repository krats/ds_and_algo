import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EmoticonsDiv2 {
	
	public int printSmiles(int smiles) {
		int emoticons[] = new int[smiles+1];
		for(int i=2; i<=smiles; i++)
		{
			emoticons[i] = Integer.MAX_VALUE;
			for(int j=1; i/j>0; j++)
			{
				if(i%j==0)
					emoticons[i] = Math.min(emoticons[i], emoticons[j] + (i/j));
			}
		}
		return emoticons[smiles];
	}
}
