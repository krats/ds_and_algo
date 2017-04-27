// Question Link: http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

package dp;
import java.util.*;

public class SubsetSum {
    private static boolean solve(int[] set, int N)
    {
        int sum = Arrays.stream(set).map(i -> i).sum();
        if(sum % 2 != 0)
            return false;
        sum /=2;
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i=0; i<N; i++)
            dp[i][0] = true;
        for(int i=1; i<=N; i++)
            for (int j = 1; j <= sum; j++)
                dp[i][j] = dp[i - 1][j] || (((j - set[i - 1]) >= 0) && dp[i - 1][j - set[i - 1]]);
        return dp[N][sum];
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T > 0)
        {
            T--;
            int N = in.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = in.nextInt();
            if(solve(arr, N))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
