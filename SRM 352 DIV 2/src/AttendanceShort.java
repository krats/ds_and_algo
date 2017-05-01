import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class AttendanceShort {
	
	public String[] shortList(String[] names, String[] attendance) {
		int N = names.length;
		ArrayList<String> fail= new ArrayList<String>(N);
		for(int i=0; i<N; i++)
		{
			if(percent(attendance[i]) < 75)
			{
				fail.add(names[i]);
			}
		}
		return fail.toArray(new String[0]);
	}
	
	int percent(String s)
	{
		int a = 0;
		int p = 0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == 'A')
				a+=1;
			if(s.charAt(i) == 'P')
				p+=1;
		}
		return p*100/(a+p);
	}
}
