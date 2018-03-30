package leetcode.PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x <= 0) {
            return false;
        }
        int num = x;
        int digits = 0;
        while (num != 0) {
            num/=10;
            digits++;
        }
        for (int i=0; i<digits; i++) {
            int j = digits-i-1;
            int a = getDigit(x,i);
            int b = getDigit(x,j);
            if (getDigit(x,i) != getDigit(x,j)) {
                return false;
            }
        }
        return true;

    }

    int getDigit(int x, int i) {
        while (i > 0) {
            x/=10;
            i--;
        }
        return x%10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(112211));
    }
}
