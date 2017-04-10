// Question Link: http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FloydWarshall {
    final static int INF = Integer.MAX_VALUE;
    public static void floydWarshall(int[][] graph)
    {
        int N = graph.length;
        int dist[][] = new int[N][N];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }
        for(int k=0; k<N; k++)
        {
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    if(dist[i][j] > dist[i][k] + dist[k][j] && dist[i][k] != INF && dist[k][j] != INF)
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }
    public static void printSolution(int[][] sol)
    {
        int N = sol.length;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(sol[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        floydWarshall(graph);
    }
}
