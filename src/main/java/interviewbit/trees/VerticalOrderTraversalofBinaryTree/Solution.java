package interviewbit.trees.VerticalOrderTraversalofBinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		Deque<Pair> que = new ArrayDeque<>();
		if(A != null)
			que.add(new Pair(0, A));
		while (que.size() != 0)
		{
			Pair c = que.poll();
			if(c.node.left != null)
			{
				que.add(new Pair(c.index-1, c.node.left));
			}
			if(c.node.right != null)
			{
				que.add(new Pair(c.index+1, c.node.right));
			}
			if(!map.containsKey(c.index))
			{
				map.put(c.index, new ArrayList<>());
			}
			map.get(c.index).add(c.node.val);
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int key : map.keySet())
		{
			min = Math.min(min, key);
			max = Math.max(max, key);
		}
		for(int i=min; i<=max; i++)
		{
			ans.add(map.get(i));
		}
		return ans;
	}
	
	class Pair {
		int index;
		TreeNode node;
		public Pair(int index, TreeNode node)
		{
			this.index = index;
			this.node = node;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
