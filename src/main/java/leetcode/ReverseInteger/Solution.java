package leetcode.ReverseInteger;

public class Solution {
    public int reverse(int x) {
        int ans = aux(x);
        while (x%10 == 0 && x != 0) {
            x/=10;
        }
        if(aux(ans) != x) {
            return 0;
        }
        return ans;
    }

    public int aux(int x) {
        int num = x;
        int ans = 0;
        while (num != 0) {
            ans = ans*10+ num%10;
            num/=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
        System.out.println(new Solution().reverse(-1234));
        System.out.println(new Solution().reverse(-120));
    }
}
