import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NoRepeatPlaylist {
	
	public int numPlaylists(int N, int M, int P) {
		long ans = 0;
		long con = 1000000007;
		long comb[][] = new long[N+1][N+1];
		comb[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= N; j++) {
				comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % con;
			}
		}
		for (int i=N; i>=M; i--) {
			long curr = 1;
			for(int j=i-M+1; j<=i; j++)
				curr = (curr*j)%con;
			int k = P-M;
			for(int j=0; j<k; j++)
			{
				curr = (curr*(i-M))%con;
			}
			if((N-i) %2 != 0)
				ans = (ans - curr*comb[N][i])%con;
			else
				ans = (ans + curr*comb[N][i])%con;
		}
		return (int) ans;
	}
}
