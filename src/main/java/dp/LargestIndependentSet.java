// Question Link: http://www.geeksforgeeks.org/largest-independent-set-problem/

package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestIndependentSet {
    static HashMap<Node, Integer> map = new HashMap<Node, Integer>(100);
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        System.out.println(LIS(root));
    }

    static int LIS(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        if(map.containsKey(root))
        {
            return map.get(root);
        }
        int ans1 = 0;
        int ans2 = 1;

        ans1 += LIS(root.left);
        ans1 += LIS(root.right);
        if(root.left != null)
        {
            ans2 += LIS(root.left.left);
            ans2 += LIS(root.left.right);
        }
        if(root.left != null)
        {
            ans2 += LIS(root.right.left);
            ans2 += LIS(root.right.right);
        }

        int ans = Math.max(ans1, ans2);
        map.put(root, ans);
        return ans;
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
    }
}
