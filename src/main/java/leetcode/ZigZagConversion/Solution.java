package leetcode.ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int N = s.length();
        StringBuilder ans = new StringBuilder();
        int current = 0;
        while (current < N) {
            ans.append(s.charAt(current));
            current += 2 * (numRows) - 2;
        }
        for(int i=1; i<numRows; i++) {
            current = i;
            boolean zig = true;
            while (current < N) {
                ans.append(s.charAt(current));
                if(zig) {
                    current += 2 * (numRows - i) - 2;
                } else {
                    current += 2 * i;
                }
                zig = !zig;
            }
        }
        current = numRows - 1;
        while (current < N) {
            ans.append(s.charAt(current));
            current += 2 * (numRows) - 2;
        }
        return ans.toString();
    }
}
