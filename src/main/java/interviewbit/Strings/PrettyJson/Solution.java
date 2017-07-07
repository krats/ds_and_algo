package interviewbit.Strings.PrettyJson;

import java.util.ArrayList;

/**
 * Created by karthikb on 02-07-2017.
 */
public class Solution {
	public ArrayList<String> prettyJSON(String a) {
		ArrayList<String> ans = new ArrayList<>(a.length()/5);
		int indentation = 0;
		for(int i=0; i<a.length();)
		{
			StringBuilder line = new StringBuilder();
			for(int j = 0; j < indentation; j++)
			{
				line.append("\t");
			}
			if(a.charAt(i) == '{' || a.charAt(i) == '[')
			{
				line.append(a.charAt(i));
				ans.add(line.toString());
				indentation+=1;
				i++;
			}
			else if(a.charAt(i) == '}' || a.charAt(i) == ']') {
				if (line.length() > 0) {
					line.delete(line.length() - 1, line.length());
				}
				line.append(a.charAt(i));
				i++;
				if (i < a.length() && a.charAt(i) == ',')
				{
					line.append(a.charAt(i));
					i++;
				}
				indentation -=1 ;
				ans.add(line.toString());
				
			}
			else
			{
				while(i < a.length() && !(a.charAt(i) == '{' || a.charAt(i) == '[' || a.charAt(i) == '}' || a.charAt(i) == ']' || a.charAt(i) == ','))
				{
					line.append(a.charAt(i));
					i++;
				}
				if(i < a.length() && a.charAt(i) == ',')
				{
					line.append(a.charAt(i));
					i++;
				}
				ans.add(line.toString());
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ArrayList<String> ans = sol.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
		for(String line: ans)
			System.out.println(line);
		ans = sol.prettyJSON("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]");
		for(String line: ans)
			System.out.println(line);
		ans = sol.prettyJSON("\"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}\"");
		for(String line: ans)
			System.out.println(line);
	}
}
