package interviewbit.trees.ShortestUniquePrefix;

import java.util.ArrayList;

public class Solution {
	ArrayList<String> ans;
	public ArrayList<String> prefix(ArrayList<String> a) {
		TreeNode root = new TreeNode('0', -1);
		for(int i=0; i<a.size(); i++) {
			insert(root, a.get(i), i);
		}
		ans = new ArrayList<>(a.size());
		for(int i=0; i<a.size(); i++) {
			ans.add("");
		}
		StringBuilder c = new StringBuilder();
		for (int i=0; i<root.childs.size(); i++) {
			traverse(root.childs.get(i), c);
		}
		return ans;
	}
	
	void traverse(TreeNode root, StringBuilder c) {
		if(root.count == 1) {
			c.append(root.val);
			ans.set(root.index, c.toString());
			c.deleteCharAt(c.length()-1);
		}
		else {
			c.append(root.val);
			for(int i=0; i<root.childs.size(); i++) {
				traverse(root.childs.get(i), c);
			}
			c.deleteCharAt(c.length()-1);
		}
	}
	
	void insert(TreeNode root, String current, int index) {
		for(int i=0; i<current.length(); i++) {
			char c = current.charAt(i);
			boolean found = false;
			for(int j=0; j<root.childs.size(); j++){
				if(root.childs.get(j).val == c) {
					found = true;
					root = root.childs.get(j);
					root.count = root.count+1;
					break;
				}
			}
			if(!found){
				root.childs.add(new TreeNode(c, index));
				root = root.childs.get(root.childs.size()-1);
			}
		}
	}
	
	class TreeNode {
		char val;
		int index;
		int count;
		ArrayList<TreeNode> childs;
		TreeNode(char x, int index) {
			val = x;
			childs = new ArrayList<>();
			this.index = index;
			count = 1;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ArrayList<String> a = new ArrayList<>();
		a.add("bearcat");
		a.add("ber");
		System.out.println(sol.prefix(a));
	}
}
