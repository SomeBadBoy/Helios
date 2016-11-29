package leetcode._07;

/**
 * @author wenqi.wei created on 16/11/28
 * @version 1.0
 */
public class ReverseInteger {
    public int reverse(int x) {
        // -2147483648 is bigger than Integer.MAX_VALUE and Integer.MIN_VALUE
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = x < 0, reachBound = false;
        int bound = Integer.MAX_VALUE / 10;
        int maxDigit = Integer.MAX_VALUE % 10;
        int reverse = 0;
        x = negative ? -x : x;
        while (x != 0) {
            if (reachBound) {
                return 0;
            }
            int d = x % 10;
            x /= 10;
            // beyond the bound
            if (reverse > bound) {
                return 0;
            }
            if (reverse == bound && maxDigit < d) {
                return 0;
            }
            if (negative && reverse == bound && d - maxDigit == 1) {
                reachBound = true;
                continue;
            }
            reverse = reverse * 10 + d;
        }
        if (reachBound) {
            return Integer.MIN_VALUE;
        }
        return negative ? -reverse : reverse;
    }
}
