import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheBoringStoreDivTwo {
	
	public String find(String John, String Brus) {
		int N = John.length();
		int M = Brus.length();
		int maxLength = 0;
		String ans = "";
		for(int i1=0; i1<N; i1++)
		{
			for(int j1=i1; j1<N; j1++)
			{
				for(int k1=j1+1;k1<N;k1++)
				{
					for(int l1=k1;l1<N;l1++)
					{
						if(j1+1-i1 > 0 && l1+1-k1 > 0)
						{
							for(int i2=0; i2<M; i2++)
							{
								for(int j2=i2; j2<M; j2++)
								{
									for(int k2=j2+1;k2<M;k2++)
									{
										for(int l2=k2;l2<M;l2++)
										{
											if(j2+1-i2 > 0 && l2+1-k2 > 0)
											{
												int a1 = j1+1-i1;
												int b1 = l1+1-k1;
												int c1 = j2+1-i2;
												int d1 = l2+1-k2;
												if((a1+c1 == b1+d1 && maxLength <= a1+c1) || (a1+d1 == b1+c1 && maxLength <= a1+d1))
												{
													String A = John.substring(i1,j1+1);
													String B = John.substring(k1, l1+1);
													String C = Brus.substring(i2,j2+1);
													String D = Brus.substring(k2, l2+1);
													if(a1+c1 == b1+d1 && maxLength <= a1+c1) {
														int length = a1+c1;
														String s1 = A + C;
														String s2 = B + D;
														if (s1.equals(s2)) {
															if (maxLength != length)
																ans = s1;
															else
																ans = ans.compareTo(s1) < 0 ? ans : s1;
															maxLength = length;
														}
													}
													if(a1+d1 == b1+c1 && maxLength <= a1+d1) {
														int length = a1+d1;
														String s1 = A + D;
														String s2 = B + C;
														if (s1.equals(s2)) {
															if (maxLength != length)
																ans = s1;
															else
																ans = ans.compareTo(s1) < 0 ? ans : s1;
															maxLength = length;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return ans;
	}
}
