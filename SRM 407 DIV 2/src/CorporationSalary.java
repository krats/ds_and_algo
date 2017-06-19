import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CorporationSalary {
	
	public long totalSalary(String[] relations) {
		int N = relations.length;
		long[] salaries = new long[N];
		for(int i=0; i<N; i++)
		{
			boolean isLeaf = true;
			for(int j=0; j<N; j++)
			{
				if(relations[i].charAt(j) == 'Y')
				{
					isLeaf = false;
					break;
				}
			}
			salaries[i] = -1;
			if(isLeaf)
			{
				salaries[i] = 1;
			}
		}
		for(int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(salaries[i] == -1) {
					long sal = 0;
					boolean possible = true;
					for (int j = 0; j < N; j++) {
						if (relations[i].charAt(j) == 'Y') {
							if(salaries[j] != -1)
								sal += salaries[j];
							else
								possible = false;
						}
					}
					if(possible)
						salaries[i] = sal;
				}
			}
		}
		long ans = 0;
		for(int i=0; i<salaries.length; i++)
		{
			ans += salaries[i];
		}
		return ans;
	}
}
