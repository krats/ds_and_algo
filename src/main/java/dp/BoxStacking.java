// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BoxStacking {

    public static int partition(int arr[][], int low, int high)
    {
        int pivot[] = arr[high];
        int i = (low-1);
        for (int j=low; j<=high-1; j++)
        {
            if (arr[j][1]*arr[j][2] >= pivot[1]*pivot[2])
            {
                i++;
                int temp[] = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp[] = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void sortTriplets(int[][] triplets, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(triplets, low, high);
            sortTriplets(triplets, low, pi-1);
            sortTriplets(triplets, pi+1, high);
        }
    }

    public static int[][] permutate(int[][] boxes, int N)
    {
        int newBoxes[][] = new int[N*3][3];
        for(int i =0; i<N; i++)
        {
            newBoxes[3*i][0] = boxes[i][0];
            newBoxes[3*i][1] = boxes[i][1];
            newBoxes[3*i][2] = boxes[i][2];
            newBoxes[3*i+1][0] = boxes[i][1];
            newBoxes[3*i+1][1] = boxes[i][0];
            newBoxes[3*i+1][2] = boxes[i][2];
            newBoxes[3*i+2][0] = boxes[i][2];
            newBoxes[3*i+2][1] = boxes[i][0];
            newBoxes[3*i+2][2] = boxes[i][1];
        }
        return newBoxes;
    }

    public static int maxBoxStackSize(int[][] boxes)
    {
        int N = boxes.length;
        boxes = permutate(boxes, N);
        sortTriplets(boxes, 0, 3*N-1);
        int dp[] = new int[3*N];
        for(int i=0; i<3*N; i++)
        {
            dp[i] = boxes[i][0];
            for(int j=i; j>=0; j--)
            {
                if(boxes[i][1] < boxes[j][1] && boxes[i][2] < boxes[j][2])
                {
                    dp[i] = dp[i] > dp[j]+boxes[i][0]? dp[i] : dp[j]+boxes[i][0];
                }
            }
        }
        int ans=0;
        for(int i=0; i<3*N; i++)
        {
            if(ans < dp[i])
            {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        int boxes[][] = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
        System.out.println(maxBoxStackSize(boxes));
    }

}
