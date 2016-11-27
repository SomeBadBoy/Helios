package leetcode._05;

import java.util.Arrays;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        int[] chars = new int[s.length() * 2 + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 1 ? s.charAt(i / 2) : Integer.MAX_VALUE;
        }
        int maxStart = 0, maxEnd = 0, maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            int start = i;
            int end = i;
            int length = 0;
            while (start >= 0 && end < chars.length) {
                if (chars[start--] == chars[end++]) {
                    if (++length > maxLength) {
                        maxLength = length;
                        maxStart = start + 1;
                        maxEnd = end - 1;
                    }
                } else {
                    break;
                }
            }
        }
        return s.substring((maxStart) / 2, maxEnd / 2);
    }
}
