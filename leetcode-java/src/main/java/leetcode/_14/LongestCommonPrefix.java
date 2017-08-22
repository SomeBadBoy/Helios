package leetcode._14;

/**
 * 找到一堆字符串中的最长前缀
 * <p>
 * 最容易想到的办法，就是从第一位开始，遍历所有的字符串，找到前缀
 *
 * @author wenqi.wei created on 2017/7/16
 * @version 1.0
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; ; i++) {
            char now;
            boolean continueFlag = true;
            if (strs.length > 0 && strs[0].length() > i) {
                now = strs[0].charAt(i);
            } else {
                break;
            }
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != now) {
                    continueFlag = false;
                    break;
                }
            }
            if (!continueFlag) {
                break;
            } else {
                builder.append(now);
            }
        }
        return builder.toString();
    }
}
