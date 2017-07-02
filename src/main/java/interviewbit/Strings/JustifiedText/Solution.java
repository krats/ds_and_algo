package interviewbit.Strings.JustifiedText;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by karthikb on 01-07-2017.
 */
public class Solution {
	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
		ArrayList<String> ansArr = new ArrayList<String>(a.size());
		for(int i=0; i<a.size(); i++)
		{
			int j = i+1;
			int len = a.get(i).length();
			while(j < a.size() && len + a.get(j).length()+1 <= b)
			{
				len += a.get(j).length()+1;
				j++;
			}
			int spaces = b - len;
			StringBuilder ans = new StringBuilder();
			int t = j-i;
			boolean isLastLine = (j == a.size());
			for(int k=i; k<j-1; k++)
			{
				ans.append(a.get(k));
				ans.append(' ');
				if(t > 1 && !isLastLine)
				{
					for(int s=0; s<spaces/(t-1); s++)
						ans.append(' ');
					if(k-i < spaces%(t-1))
						ans.append(' ');
				}
			}
			ans.append(a.get(j-1));
			if(isLastLine || t==1)
			{
				for(int s=0; s<spaces; s++)
				{
					ans.append(' ');
				}
			}
			ansArr.add(ans.toString());
			i = j-1;
		}
		return ansArr;
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		String arr[];
		ArrayList<String> myarr;
		
		arr = new String[]{"glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m"};
		myarr = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
		{
			myarr.add(arr[i]);
		}
		myarr = sol.fullJustify(myarr,144);
		for(int i=0; i<myarr.size(); i++)
		{
			System.out.println("\""+ myarr.get(i) + "\"");
		}
		
		
		arr = new String[]{"am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"};
		myarr = new ArrayList<>(arr.length);
		for(int i=0; i<arr.length; i++)
		{
			myarr.add(arr[i]);
		}
		myarr = sol.fullJustify(myarr,14);
		for(int i=0; i<myarr.size(); i++)
		{
			System.out.println("\""+ myarr.get(i) + "\"");
		}
	}
}
