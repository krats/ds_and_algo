import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EvenRoute {
	
	public String isItPossible(int[] x, int[] y, int wantedParity) {
		
		boolean is_odd_present = false;
		boolean is_even_present = false;
		for(int i=0; i<x.length; i++)
		{
			int dist = Math.abs(x[i]) + Math.abs(y[i]);
			if(dist %2 == 0)
				is_even_present = true;
			else
				is_odd_present = true;
		}
		if(wantedParity == 1 && !is_odd_present)
			return "CANNOT";
		if(wantedParity == 0 && !is_even_present)
			return "CANNOT";
		return "CAN";
	}
}
