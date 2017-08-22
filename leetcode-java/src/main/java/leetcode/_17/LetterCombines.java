package leetcode._17;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法很简单，主要还是一个考虑，是以空间换时间，还是以时间换空间，这里是以空间换时间的
 *
 * @author wenqi.wei created on 2017/7/26
 * @version 1.0
 */
public class LetterCombines {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<>();
        }
        char[][] T = new char[][]{
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        List<String> res = new ArrayList<>();
        List<String> suffix = new ArrayList<>();
        StringBuilder prefixBuilder = new StringBuilder();
        StringBuilder digitsBuilder = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (c == '1' || c == '0') continue;
            int p = c - '0';
            prefixBuilder.append(T[p][0]);
            digitsBuilder.append(c);
        }
        digits = digitsBuilder.toString();
        String prefix = prefixBuilder.toString();
        for (int i = digits.length() - 1; i >= 0; i--) {
            char c = digits.charAt(i);
            if (c == '1' || c == '0') continue;
            int p = c - '0';
            String substring = prefix.substring(0, i);
            List<String> another = new ArrayList<>();
            for (int j = 0; j < T[p].length; j++) {
                char chars = T[p][j];
                if (suffix.size() <= 0) {
                    res.add(substring + chars);
                    another.add(String.valueOf(chars));
                } else {
                    for (String s : suffix) {
                        if (j != 0) {
                            res.add(substring + chars + s);
                        }
                        another.add(chars + s);
                    }
                }
            }
            suffix = another;
        }
        return res;
    }
}
