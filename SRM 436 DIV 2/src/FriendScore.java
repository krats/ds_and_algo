import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FriendScore {
	
	public int highestScore(String[] friends) {
		int n = friends.length;
		int[] popular = new int[n];
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++) {
				if (friends[i].charAt(j) == 'Y'){
					popular[i] += 1;
					popular[j] += 1;
				}
				else{
					for (int k = 0; k < n; k++) {
						if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							popular[i] += 1;
							popular[j] += 1;
							break;
						}
					}
				}
			}
		}
		int ans = 0;
		for(int i=0; i<n; i++)
		{
			if(ans < popular[i])
				ans = popular[i];
		}
		return ans;
	}
}
