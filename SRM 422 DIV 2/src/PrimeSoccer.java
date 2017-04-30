import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PrimeSoccer {
	
	public double getProbability(int skillOfTeamA, int skillOfTeamB) {
		int c[] = {1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1};
		int nonPrimes[] = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
		double p1 = ((double) skillOfTeamA)/100;
		double p2 = ((double) skillOfTeamB)/100;
		double ans = 0;
		double t1=0,t2=0;
		for(int i=0; i<12; i++)
		{
			t1 += c[nonPrimes[i]]*Math.pow(p1,nonPrimes[i])*Math.pow(1-p1,18-nonPrimes[i]);
			t2 += c[nonPrimes[i]]*Math.pow(p2,nonPrimes[i])*Math.pow(1-p2,18-nonPrimes[i]);
		}
		ans = 1-t1*t2;
		return ans;
	}
}
