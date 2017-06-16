import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CarolsSinging {
	
	public int choose(String[] lyrics) {
		int noOfSongs = lyrics[0].length();
		int noOfPeople = lyrics.length;
		int masks[] = new int[lyrics.length];
		int res = noOfSongs;
		for(int i=0; i<lyrics.length; i++)
		{
			masks[i] = Integer.parseInt(lyrics[i].replace('Y', '1').replace('N', '0'), 2);
		}
		for(int i = 0; i < 1<<noOfSongs; i++)
		{
			boolean ok = true;
			for(int j=0; j<masks.length; j++)
				if((i & masks[j]) == 0)
					ok = false;
			if(ok && res > Integer.bitCount(i))
				res = Integer.bitCount(i);
		}
		return res;
	}
}
