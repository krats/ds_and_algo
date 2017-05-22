import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class AstronomicalRecordsEasy {
	
	public int minimalPlanets(int[] A, int[] B) {
		int ans = A.length + B.length;
		for(int i=0; i<A.length; i++)
		{
			for(int j=0; j<B.length; j++)
			{
				int count = 0;
				HashMap<Integer, Boolean> dp = new HashMap<Integer, Boolean>(A.length + B.length);
				for(int k=0; k<A.length; k++)
				{
					if(dp.get(A[k]*B[j]) == null) {
						count += 1;
						dp.put(A[k]*B[j], true);
					}
				}
				for(int k=0; k<B.length; k++)
				{
					if(dp.get(B[k]*A[i]) == null) {
						count += 1;
						dp.put(B[k]*A[i], true);
					}
				}
				if(count < ans)
					ans = count;
			}
		}
		return ans;
	}
}
