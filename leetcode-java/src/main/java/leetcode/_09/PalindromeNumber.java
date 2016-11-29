package leetcode._09;

/**
 * @author wenqi.wei created on 16/11/28
 * @version 1.0
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = 0;
        int tmp = x;
        int low = 10, high = 0;
        while (tmp != 0) {
            tmp /= 10;
            length++;
            if (high == 0) {
                high = 1;
            } else {
                high *= 10;
            }
        }
        int forward = 1;
        while (forward++ <= length--) {
            if (x / high != x % low) {
                return false;
            }
            x %= high;
            x /= low;
            high /= 100;
        }
        return true;
    }
}
