package leetcode.StringtoInteger;

public class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int N = str.length();
        int sign = 1;
        long ans = 0;
        while (i < N && str.charAt(i) == ' ') {
            i++;
        }
        if(i < N) {
            if(str.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if(str.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }
        while (i < N && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            ans = ans*10 + (str.charAt(i) - '0');
            if(ans*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(ans*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (ans*sign);
    }
}
