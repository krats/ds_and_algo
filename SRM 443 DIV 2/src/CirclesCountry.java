import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CirclesCountry {
	
	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
		boolean reverse = false;
		if(x1 == x2)
			reverse = true;
		double m = 0;
		if(reverse)
			m = 0;
		else
			m = (y2 - y1)/((double) (x2 - x1));
		double a,b,c;
		if(reverse)
		{
			a = -1;
			b = m;
			c = x1 - m*y1;
		}
		else
		{
			a = m;
			b = -1;
			c = y1 - m*x1;
		}
		ArrayList<Integer> points = new ArrayList<>(X.length);
		double sqrtab = sqrt(a*a + b*b);
		for(int i=0; i<X.length; i++)
		{
			double dist = abs(a*X[i]+b*Y[i]+c)/sqrtab;
			if(dist < R[i])
				points.add(i);
		}
		int ans = 0;
		for(int i=0; i<points.size(); i++)
		{
			int index = points.get(i);
			double dist1 = sqrt((x1 - X[index])*(x1 - X[index]) + (y1 - Y[index])*(y1 - Y[index]));
			double dist2 = sqrt((x2 - X[index])*(x2 - X[index]) + (y2 - Y[index])*(y2 - Y[index]));
			if(dist1 < R[index])
				ans += 1;
			else if(dist2 < R[index])
				ans += 1;
			if(dist1 < R[index] && dist2 < R[index])
				ans -= 1;
		}
		return ans;
	}
}
