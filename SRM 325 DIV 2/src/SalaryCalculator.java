import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SalaryCalculator {
	
	public double calcHours(int P1, int P2, int salary) {
		double ans = 0.0;
		if(salary <= P1*200)
			ans = ((double) salary)/P1;
		if(salary > P1*200)
		{
			ans = 200;
			salary -= P1*200;
			ans += ((double) salary)/P2;
		}
		return ans;
	}
}
