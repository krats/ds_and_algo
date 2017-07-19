package interviewbit.hashing.StringConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by karthikb on 16-07-2017.
 */
public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int[] map2 = new int[a.length()];
		for(int i=0; i<b.size(); i++)
		{
			if(!map.containsKey(b.get(i)))
			{
				map.put(b.get(i), 1);
				for(int j=0; j<a.length()-b.get(i).length()+1; j++)
				{
					if(a.substring(j, j+b.get(i).length()).equals(b.get(i)))
					{
						map2[j] = i+1;
					}
				}
			}
			else
			{
				map.put(b.get(i), map.get(b.get(i))+1);
			}
		}
		for(int i=0; i<a.length(); i++)
		{
			if(map2[i] != 0)
			{
				HashMap<String, Integer> mapCopy = new HashMap<>();
				for(String key: map.keySet())
				{
					mapCopy.put(key, map.get(key));
				}
				int j = i;
				while (mapCopy.size() != 0 && j < a.length() && map2[j] != 0)
				{
					String ckey = b.get(map2[j]-1);
					if(!mapCopy.containsKey(ckey))
						break;
					int c = mapCopy.get(ckey);
					if(c == 1)
					{
						mapCopy.remove(ckey);
					}
					else
					{
						mapCopy.put(ckey, c-1);
					}
					j += ckey.length();
				}
				if(mapCopy.size() == 0)
				{
					ans.add(i);
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String test = in.nextLine();
		String words[] = test.split("\\s+");
		int n = Integer.parseInt(words[0]);
		List<String> b = new ArrayList<>(n);
		for(int i=0; i<n; i++)
		{
			b.add(words[i+1]);
		}
		System.out.println(sol.findSubstring(a,b));
	}
}
