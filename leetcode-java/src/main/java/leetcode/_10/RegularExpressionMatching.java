package leetcode._10;

/**
 * @author wenqi.wei created on 16/11/30
 * @version 1.0
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s.length() <= 0) {
            return false;
        }
        if (p.length() <= 0) {
            return true;
        }
        for (int i = 0; i < p.length(); i++) {
            char value = p.charAt(i);
        }
        return false;
    }
}
