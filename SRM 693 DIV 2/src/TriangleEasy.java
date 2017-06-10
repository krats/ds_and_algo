import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TriangleEasy {
	
	public int find(int n, int[] x, int[] y) {
		int adjMatrix[][] = new int[n][n];
		for(int i=0; i<x.length; i++)
		{
			adjMatrix[x[i]][y[i]] = 1;
			adjMatrix[y[i]][x[i]] = 1;
		}
		int count = 1;
		for(int i=0; i<x.length&&count!=3; i++)
		{
			for(int j=0; j < n; j++) {
				if(j != y[i] && adjMatrix[j][x[i]] == 1) {
					if (adjMatrix[j][y[i]] == 1) {
						count = 3;
						break;
					} else {
						count = 2;
					}
				}
			}
		}
		for(int i=0; i<y.length&&count!=3; i++)
		{
			for(int j=0; j < n; j++) {
				if(j != x[i] && adjMatrix[j][y[i]] == 1) {
					if (adjMatrix[j][x[i]] == 1) {
						count = 3;
						break;
					} else {
						count = 2;
					}
				}
			}
		}
		if(count == 3)
			return 0;
		else if(count == 2)
			return 1;
		else if(x.length != 0)
			return 2;
		else
			return 3;
	}
}
