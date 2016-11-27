package leetcode._03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenqi.wei created on 16/11/27
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 0, current = 0, lastConflict = 0;
        Map<Integer, Integer> location = new HashMap<>();
        for (int i = 1; i <= s.length(); i++) {
            int code = s.codePointAt(i - 1);
            if (location.containsKey(code) && lastConflict <= location.get(code)) {
                int conflict = location.get(code);
                max = current > max ? current : max;
                current = i - conflict;
                lastConflict = conflict;
            } else {
                current++;
            }
            location.put(code, i);
        }
        return current > max ? current : max;
    }
}
